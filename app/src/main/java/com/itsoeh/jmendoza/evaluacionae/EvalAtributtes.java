package com.itsoeh.jmendoza.evaluacionae;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EvalAtributtes extends AppCompatActivity {
    private Button btnBack, guardarCalificacion, btnDescripcion;
    private EditText txtCalicacion1, txtCalicacion2, txtCalicacion3;
    private TextView txtCriterioEsp1, txtCriterioEsp2, txtCriterioEsp3, txtPuntos1, txtPuntos2, txtPuntos3, txtMeta, txtLogro, txtNivel, txtNombreAtri,
    txtIdCriterio1, txtIDCriterio2, txtIDCriterio3, txtNombreAlumno;
    private CardView card1, card2, card3;
    public static int idEstudianteFinal;
    public static JSONArray contenidoArrayFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval_atributtes);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        txtCalicacion1 = findViewById(R.id.eval_atributtes_txt_calificacion1);
        txtCalicacion2 = findViewById(R.id.eval_atributtes_txt_calificacion2);
        txtCalicacion3 = findViewById(R.id.eval_atributtes_txt_calificacion3);
        txtCriterioEsp1 = findViewById(R.id.eval_atributtes_txt_criterioEspe1);
        txtCriterioEsp2 = findViewById(R.id.eval_atributtes_txt_criterioEspe2);
        txtCriterioEsp3 = findViewById(R.id.eval_atributtes_txt_criterioEspe3);
        txtIdCriterio1 = findViewById(R.id.eval_atributtes_txt_id_criterio1);
        txtIDCriterio2 = findViewById(R.id.eval_atributtes_txt_id_criterio2);
        txtIDCriterio3 = findViewById(R.id.eval_atributtes_txt_id_criterio3);
        txtPuntos1 = findViewById(R.id.eval_atributtes_txt_puntos1);
        txtPuntos2 = findViewById(R.id.eval_atributtes_txt_puntos2);
        txtPuntos3 = findViewById(R.id.eval_atributtes_txt_puntos3);
        txtMeta = findViewById(R.id.eval_atributo_txt_meta);
        txtLogro = findViewById(R.id.eval_atributo_txt_logro);
        txtNombreAlumno = findViewById(R.id.eval_atributo_txt_nombre_alumno);
        txtNivel = findViewById(R.id.eval_atributo_txt_nivel);
        txtNombreAtri = findViewById(R.id.eval_atributo_txt_atributo);
        card1 = findViewById(R.id.eval_atributtes_card1);
        card2 = findViewById(R.id.eval_atributtes_card2);
        card3 = findViewById(R.id.eval_atributtes_card3);
        btnBack = findViewById(R.id.eval_atributo_btn__back);
        guardarCalificacion = findViewById(R.id.eval_atributo_btn_asignar);
        Intent intent = getIntent();
        int idAtributoE = intent.getIntExtra("idAtributoE", -1);
        String atributoE = intent.getStringExtra("atributoE");
        int meta = intent.getIntExtra("meta", -1);
        int logro = intent.getIntExtra("logro", -1);
        idEstudianteFinal = intent.getIntExtra("idEstudiante", -1);
        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
        StringRequest requestEstudent = new StringRequest(Request.Method.POST, Api.OBTENER_NOMBRE_POR_IDESTUDIANTE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            if (!error) {
                                JSONArray nombreYApellidosArray = jsonResponse.getJSONArray("nombreYApellidos");
                                if (nombreYApellidosArray.length() > 0) {
                                    JSONObject nombreYApellidosObject = nombreYApellidosArray.getJSONObject(0);
                                    String nombre = nombreYApellidosObject.getString("nombre");
                                    String apellido = nombreYApellidosObject.getString("apellido");
                                    txtNombreAlumno.setText(nombre + " " + apellido);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d(TAG, "Error: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error: " + error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("idEstudiante", String.valueOf(idEstudianteFinal));
                return params;
            }
        };

        colaDeSolicitudes.add(requestEstudent);

        if(atributoE.equals("A2.-Modelos Computacionales")){
            card3.setVisibility(View.GONE);
            txtNombreAtri.setText(atributoE);
            txtMeta.setText(String.valueOf(meta));
            txtLogro.setText(String.valueOf(logro));
        }else{
            txtNombreAtri.setText(atributoE);
            txtMeta.setText(String.valueOf(meta));
            txtLogro.setText(String.valueOf(logro));
        }
        StringRequest request = new StringRequest(Request.Method.POST, Api.OBTENER_CRITERIOS_POR_ATRIBUTO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            contenidoArrayFinal = jsonResponse.getJSONArray("contenido");
                            if (contenidoArrayFinal.length() == 2) {
                                String indicadorEspecifico1 = "", indicadorEspecifico2 = "", puntos1 = "", puntos2 = "";
                                for (int i = 0; i < contenidoArrayFinal.length(); i++) {
                                    JSONObject criterioObject = contenidoArrayFinal.getJSONObject(i);
                                    String nivel = criterioObject.getString("nivel");
                                    txtNivel.setText(nivel);

                                    if (i == 0) {
                                        indicadorEspecifico1 = criterioObject.getString("indicadorEspecifico");
                                        puntos1 = String.valueOf(criterioObject.getInt("puntos"));
                                    } else if (i == 1) {
                                        indicadorEspecifico2 = criterioObject.getString("indicadorEspecifico");
                                        puntos2 = String.valueOf(criterioObject.getInt("puntos"));
                                    }
                                }
                                establecerTextoDosElementos(indicadorEspecifico1, indicadorEspecifico2, puntos1, puntos2);
                            } else {
                                for (int i = 0; i < contenidoArrayFinal.length(); i++) {
                                    JSONObject criterioObject = contenidoArrayFinal.getJSONObject(i);
                                    String nivel = criterioObject.getString("nivel");
                                    txtNivel.setText(nivel);

                                    String indicadorEspecifico = criterioObject.getString("indicadorEspecifico");
                                    String puntos = String.valueOf(criterioObject.getInt("puntos"));

                                    switch (i) {
                                        case 0:
                                            establecerTexto(indicadorEspecifico, "", "", puntos, "", "");
                                            break;
                                        case 1:
                                            establecerTexto(txtCriterioEsp1.getText().toString(), indicadorEspecifico, "", txtPuntos1.getText().toString(), puntos, "");
                                            break;
                                        case 2:
                                            establecerTexto(txtCriterioEsp1.getText().toString(), txtCriterioEsp2.getText().toString(), indicadorEspecifico, txtPuntos1.getText().toString(), txtPuntos2.getText().toString(), puntos);
                                            break;
                                    }
                                }
                            }
                        }catch(JSONException e){
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
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("idAtributoE", String.valueOf(idAtributoE));
                return parametros;
            }
        };
        colaDeSolicitudes.add(request);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        guardarCalificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCalificacion();
            }
        });
    }
    public void establecerTexto(String criterioEsp1, String criterioEsp2, String criterioEsp3, String puntos1, String puntos2, String puntos3) {
        txtCriterioEsp1.setText(criterioEsp1);
        txtCriterioEsp2.setText(criterioEsp2);
        txtCriterioEsp3.setText(criterioEsp3);
        txtPuntos1.setText(puntos1);
        txtPuntos2.setText(puntos2);
        txtPuntos3.setText(puntos3);
    }

    public void guardarCalificacion() {
        if (EvalAtributtes.contenidoArrayFinal.length() == 2) {
            for (int i = 1; i <= 2; i++) {
                if (i == 1) {
                    obtenerIDcriterio(txtCriterioEsp1.getText().toString(), txtPuntos1.getText().toString(), txtCalicacion1.getText().toString());
                } else if (i == 2) {
                    obtenerIDcriterio(txtCriterioEsp2.getText().toString(), txtPuntos2.getText().toString(), txtCalicacion2.getText().toString());
                }
            }
        }else {

            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    obtenerIDcriterio(txtCriterioEsp1.getText().toString(), txtPuntos1.getText().toString(), txtCalicacion1.getText().toString());
                } else if (i == 2) {
                    obtenerIDcriterio(txtCriterioEsp2.getText().toString(), txtPuntos2.getText().toString(), txtCalicacion2.getText().toString());
                } else if (i == 3) {
                    obtenerIDcriterio(txtCriterioEsp3.getText().toString(), txtPuntos3.getText().toString(), txtCalicacion3.getText().toString());
                }
            }
        }
    }

    private void obtenerIDcriterio(String criterioEsp1, String puntos1, String calificacion) {
        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.POST, Api.OBTENER_ID_CRITERIO_POR_INDICADOR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            if (!error) {
                                JSONArray contenidoArray = jsonResponse.getJSONArray("contenido");
                                for (int i = 0; i < contenidoArray.length(); i++) {
                                    JSONObject criterioObject = contenidoArray.getJSONObject(i);
                                    int idCriterio = criterioObject.getInt("idCriterio");
                                    guardarCalificaciones(idCriterio, calificacion);
                                }
                            } else {
                                Toast.makeText(EvalAtributtes.this, "Ocurrió un error, intenta nuevamente", Toast.LENGTH_SHORT).show();
                            }
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
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("indicadorEspecifico", criterioEsp1);
                return parametros;
            }
        };
        colaDeSolicitudes.add(request);

    }

    private void guardarCalificaciones(int idCriterio, String calificacion) {
        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.POST, Api.GUARDAR_CALIFICACION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean error = jsonResponse.getBoolean("error");
                            if (!error) {
                                Toast.makeText(EvalAtributtes.this, "Calificación guardada correctamente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(EvalAtributtes.this, "Ocurrió un error, intenta nuevamente", Toast.LENGTH_SHORT).show();
                            }
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
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("idEstudiante", String.valueOf(idEstudianteFinal));
                parametros.put("idCriterio", String.valueOf(idCriterio));
                parametros.put("calificacion", calificacion);
                return parametros;
            }
        };
        colaDeSolicitudes.add(request);
    }

    public void establecerTextoDosElementos(String criterioEsp1, String criterioEsp2, String puntos1, String puntos2 ) {
        txtCriterioEsp1.setText(criterioEsp1);
        txtCriterioEsp2.setText(criterioEsp2);
        txtPuntos1.setText(puntos1);
        txtPuntos2.setText(puntos2);
    }


}