package com.itsoeh.jmendoza.evaluacionae;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AEstudiante;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MEstudiante;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterEstudiante;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstudianteSelection extends AppCompatActivity {
    private TextView txtMateria, txtAsignat, txtGrupo, txtcodigoGrupo, txtAtributo, txtAsignarAtri;
    private Button btnBack;
    private RecyclerView recLista;
    private ImageView btnEliminar;
    private NavController nav;
    private ArrayList<MAsignatura> lista;
    //private AdapterAsignatura x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_selection);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        txtMateria = findViewById(R.id.student_select_txt_materia);
        txtAsignarAtri = findViewById(R.id.student_select_btn_atribu);
        txtAsignarAtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brinco = new Intent(EstudianteSelection.this, SeleccionarAtributo.class);
                startActivity(brinco);
            }
        });
        txtAsignat = findViewById(R.id.student_select_txt_claveAsig);
        txtGrupo = findViewById(R.id.student_select_txt_claveGrupo);
        txtcodigoGrupo = findViewById(R.id.student_select_txt_codiGrupo);
        recLista = findViewById(R.id.student_select_rec_lista);
        btnBack = findViewById(R.id.studnet_select_btn__back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Obtiene los datos del Intent
        Intent intent = getIntent();
        String asignatura = intent.getStringExtra("asignatura");
        String claveAsignatura = intent.getStringExtra("claveAsignatura");
        String claveGrupo = intent.getStringExtra("claveGrupo");
        String codigoAsignatura = intent.getStringExtra("codigoAsignatura");

        // Establece los datos en las vistas de texto
        txtMateria.setText(asignatura);
        txtAsignat.setText(claveAsignatura);
        txtGrupo.setText(claveGrupo);
        txtcodigoGrupo.setText(codigoAsignatura);
        btnEliminar = findViewById(R.id.student_select_btn_eliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(EstudianteSelection.this).getRequestQueue();
                StringRequest solicitud = new StringRequest(Request.Method.POST, Api.ELIMINAR_ASIGNATURA, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject respuesta = new JSONObject(response);
                            Toast.makeText(EstudianteSelection.this, "Se eliminó la asignatura", Toast.LENGTH_SHORT).show();
                            finish();
                        } catch (JSONException e) {
                            Toast.makeText(EstudianteSelection.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "" + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EstudianteSelection.this, "Falló al eliminar" + error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "" + error.getMessage());

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parametros = new HashMap<String, String>();
                        parametros.put("codigoAsignatura", codigoAsignatura);
                        return parametros;
                    }
                };
                colaDeSolicitudes.add(solicitud);
            }
        });

        listarDesdeAPI(codigoAsignatura).observe(this, new Observer<ArrayList<MEstudiante>>() {
            @Override
            public void onChanged(ArrayList<MEstudiante> mEstudiantes) {
                AdapterEstudiante adapter = new AdapterEstudiante(mEstudiantes);
                recLista.setAdapter(adapter);
            }
        });
    }
    public void brincarConDatos(int idEstudiante, Context context){
        String codigoAsig = AdapterAsignatura.codigoAsignatura;
        Intent intent = new Intent(context, AtributosEgreso.class);
        intent.putExtra("idEstudiante", idEstudiante);
        intent.putExtra("codigoAsig", codigoAsig);
        context.startActivity(intent);
    }

    public LiveData<ArrayList<MEstudiante>> listarDesdeAPI(String codigoAsignatura) {
        final MutableLiveData<ArrayList<MEstudiante>> liveData = new MutableLiveData<>();

        // Crea un nuevo objeto de solicitud
        StringRequest request = new StringRequest(Request.Method.POST, Api.LISTAR_ESTUDIANTE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            ArrayList<MEstudiante> lista = new ArrayList<>();
                            if (!error) {
                                JSONArray contenidoArray = jsonResponse.getJSONArray("contenido");
                                for (int i = 0; i < contenidoArray.length(); i++) {
                                    JSONObject estudianteObject = contenidoArray.getJSONObject(i);

                                    MEstudiante estudiante = new MEstudiante();
                                    estudiante.setIdEstudiante(estudianteObject.getInt("idEstudiante"));
                                    estudiante.setNombre(estudianteObject.getString("nombre"));
                                    estudiante.setApellido(estudianteObject.getString("apellido"));
                                    estudiante.setCorreo(estudianteObject.getString("correo"));
                                    estudiante.setMatricula(estudianteObject.getInt("matricula"));

                                    lista.add(estudiante);
                                }
                            }
                            if (lista.isEmpty()) {
                                LinearLayout txtEmpty = findViewById(R.id.tv_empty_estudiante);
                                recLista.setVisibility(View.GONE);
                                txtEmpty.setVisibility(View.VISIBLE);
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
                params.put("codigoAsignatura", codigoAsignatura);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(request);

        return liveData;
    }

}
