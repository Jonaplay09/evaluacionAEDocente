package com.itsoeh.jmendoza.evaluacionae;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AEstudiante;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Asignaturas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Asignaturas extends Fragment {
    private EditText txtBuscar;
    private ImageButton btnAgregar;
    private RecyclerView recLista;
    private NavController nav;
    private ArrayList<MAsignatura> lista;
    private AdapterAsignatura x;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Asignaturas() {
        // Required empty public constructor
    }

    public static Asignaturas newInstance(String param1, String param2) {
        Asignaturas fragment = new Asignaturas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getActivity().getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asignaturas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recLista = view.findViewById(R.id.asignaturas_rec_lista);
        btnAgregar = view.findViewById(R.id.add_button);
        TextView emptyView = view.findViewById(R.id.tv_empty);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAgregar();
            }
        });
        SharedPreferences sharedPref = getContext().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        int idDocente = sharedPref.getInt("idDocente", -1);
        listarDesdeAPI(idDocente).observe(getViewLifecycleOwner(), new Observer<ArrayList<MAsignatura>>() {
            @Override
            public void onChanged(ArrayList<MAsignatura> mAsignaturas) {
                x = new AdapterAsignatura(mAsignaturas, emptyView);
                recLista.setAdapter(x);
                x.updateData(mAsignaturas);
            }
        });
    }

    private void clicAgregar() {
        Intent intent = new Intent(getActivity(), Asignatura.class);
        startActivity(intent);
    }

    public LiveData<ArrayList<MAsignatura>> listarDesdeAPI(int idDocente) {
        final MutableLiveData<ArrayList<MAsignatura>> liveData = new MutableLiveData<>();

        // Realizar la solicitud a la API
        StringRequest request = new StringRequest(Request.Method.POST, Api.LISTAR_ASIGNATURA_POR_IDDOCENTE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            ArrayList<MAsignatura> lista = new ArrayList<>();
                            if (!error) {
                                JSONArray contenidoArray = jsonResponse.getJSONArray("contenido");
                                for (int i = 0; i < contenidoArray.length(); i++) {
                                    JSONObject asignaturaObject = contenidoArray.getJSONObject(i);

                                    MAsignatura asignatura = new MAsignatura();
                                    asignatura.setIdAsignaturas(asignaturaObject.getInt("idAsignaturas"));
                                    asignatura.setAsignatura(asignaturaObject.getString("asignatura"));
                                    asignatura.setClaveAsignatura(asignaturaObject.getString("claveAsignatura"));
                                    asignatura.setClaveGrupo(asignaturaObject.getString("claveGrupo"));
                                    asignatura.setCodigoAsignatura(asignaturaObject.getString("codigoAsignatura"));
                                    asignatura.setIdDocente(asignaturaObject.getInt("idDocente"));
                                    // Continúa para el resto de los campos...

                                    lista.add(asignatura);
                                }
                            }
                            liveData.postValue(lista);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar errores de la solicitud
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("idDocente", String.valueOf(idDocente));
                return params;
            }
        };

        VolleySingleton.getInstance(getContext()).addToRequestQueue(request);

        return liveData;
    }

}
