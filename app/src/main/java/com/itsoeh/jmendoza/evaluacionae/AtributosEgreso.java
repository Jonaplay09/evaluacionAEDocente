package com.itsoeh.jmendoza.evaluacionae;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAtributo;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAtributo;
import com.itsoeh.jmendoza.evaluacionae.models.MEstudiante;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAtributo;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterEstudiante;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AtributosEgreso extends AppCompatActivity {
    private EditText txtBuscar;
    private Button btnBack;
    private ImageButton btnAgregar;
    private RecyclerView recLista;
    private ArrayList<MAtributo> lista;
    private AdapterAtributo x;
    public static int idEstudianteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos_egreso);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //btnAgregar = findViewById(R.id.condoc_fbtn_agregar);
        //txtBuscar = findViewById(R.id.condoc_txtBusca);
        Intent intent = getIntent();
        int idEstudiante = intent.getIntExtra("idEstudiante", -1);
        idEstudianteFinal = idEstudiante;
        String codigoAsignatura = intent.getStringExtra("codigoAsig");
        recLista = findViewById(R.id.atributos_egre_rec_lista);
        btnAgregar = findViewById(R.id.atributos_egre_add_button);
        TextView emptyView = findViewById(R.id.tv_empty);
        btnBack= findViewById(R.id.atributos_egre_btn__back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAgregar(idEstudiante, codigoAsignatura);
            }
        });
        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(AtributosEgreso.this).getRequestQueue();
        StringRequest solicitud = new StringRequest(Request.Method.POST, Api.OBTENER_ID_ASIGNATURA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject respuesta = new JSONObject(response);
                    int idAsignaturaR = respuesta.getJSONArray("contenido").getJSONObject(0).getInt("idAsignaturas");
                    AAtributo u = new AAtributo(AtributosEgreso.this);
                    listarDesdeAPI(idAsignaturaR).observe(AtributosEgreso.this, new Observer<ArrayList<MAtributo>>() {
                        @Override
                        public void onChanged(ArrayList<MAtributo> mAtributos) {
                            x = new AdapterAtributo(mAtributos, emptyView);
                            recLista.setAdapter(x);
                            x.updateData(mAtributos);
                        }
                    });
                } catch (JSONException e) {
                    Toast.makeText(AtributosEgreso.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "" + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AtributosEgreso.this, "Falló el registro" + error.getMessage(), Toast.LENGTH_SHORT).show();
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

    private void clicAgregar(int idEstudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, SeleccionarAtributo.class);
        intent.putExtra("idEstudiante", idEstudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        startActivity(intent);
    }
    public LiveData<ArrayList<MAtributo>> listarDesdeAPI(int idAsignatura) {
        final MutableLiveData<ArrayList<MAtributo>> liveData = new MutableLiveData<>();

        // Crea un nuevo objeto de solicitud
        StringRequest request = new StringRequest(Request.Method.POST, Api.LISTAR_ATRIBUTOS_EGRESO_POR_IDASIGNATURA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            ArrayList<MAtributo> lista = new ArrayList<>();
                            if (!error) {
                                JSONArray contenidoArray = jsonResponse.getJSONArray("contenido");
                                for (int i = 0; i < contenidoArray.length(); i++) {
                                    JSONObject atributoEgresoObject = contenidoArray.getJSONObject(i);

                                    MAtributo atributoEgreso = new MAtributo();
                                    atributoEgreso.setId(atributoEgresoObject.getInt("idAtributoE"));
                                    atributoEgreso.setAtributoE(atributoEgresoObject.getString("atributoE"));
                                    atributoEgreso.setMeta(atributoEgresoObject.getInt("meta"));
                                    atributoEgreso.setLogro(atributoEgresoObject.getInt("logro"));
                                    lista.add(atributoEgreso);
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
                params.put("idAsignatura", String.valueOf(idAsignatura));
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(request);

        return liveData;
    }


}
