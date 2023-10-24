package com.itsoeh.jmendoza.evaluacionae;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;
import java.util.ArrayList;

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Asignaturas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultaDocente.
     */
    // TODO: Rename and change types and number of parameters
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
        //btnAgregar = view.findViewById(R.id.condoc_fbtn_agregar);
        //txtBuscar = view.findViewById(R.id.condoc_txtBusca);
        recLista = view.findViewById(R.id.asignaturas_rec_lista);
        btnAgregar = view.findViewById(R.id.add_button);
        TextView emptyView = view.findViewById(R.id.tv_empty);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAgregar();
            }
        });
        AAsignatura u = new AAsignatura(view.getContext());
        lista = u.listar();
        x = new AdapterAsignatura(lista, emptyView);
        recLista.setAdapter(x);
        x.updateData(lista);
        /* btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clicAgregar();
            }
        });
        txtBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //yfiltrar(s.toString());
            }
        });
    }

         */

    /*private void filtrar(String t){
        ArrayList<MDocente> listaFiltrada  = new ArrayList<MDocente>();
        for(MDocente e:lista){
            if(e.getNombre().toLowerCase().contains(t.toLowerCase())||e.getApp().toLowerCase().contains(t.toLowerCase())
                    ||e.getApm().toLowerCase().contains(t.toLowerCase()))
                listaFiltrada.add(e);
        }
        x.filtro(listaFiltrada);
    }
*/
  /* private void clicAgregar() {
        nav.navigate(R.id.docente);
    }

   */
    }

    private void clicAgregar() {
        Intent intent = new Intent(getActivity(), Asignatura.class);
        startActivity(intent);
    }
}