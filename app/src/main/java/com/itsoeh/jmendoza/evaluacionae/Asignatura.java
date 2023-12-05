package com.itsoeh.jmendoza.evaluacionae;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.ADocente;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AEstudiante;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Asignatura extends AppCompatActivity {
    private Button btnBackLog, btnRegistrar;
    private EditText txtClaveAsignatura, txtClaveGrupo;
    private Spinner spAsignatura;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        txtClaveAsignatura = findViewById(R.id.regasig_txt_claveasig);
        txtClaveGrupo = findViewById(R.id.regasig_txt_clavegrupo);
        spAsignatura = findViewById(R.id.regasig_sp_asignatura);
        btnRegistrar = findViewById(R.id.regasig_btn_guardar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicRegistrar();
            }
        });
        btnBackLog = findViewById(R.id.regasig_btn_back);
        btnBackLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicBack();
            }
        });
    }

    private void clicRegistrar() {
        String claveAsignatura = txtClaveAsignatura.getText().toString();
        String claveGrupo = txtClaveGrupo.getText().toString();

        if (claveAsignatura.equals("") |claveGrupo.equals("") ) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_layout, null);
            builder.setView(view);

            AlertDialog dialog = builder.create();

            TextView title = view.findViewById(R.id.title);
            title.setText("Correo y contraseña vacíos");
            TextView message = view.findViewById(R.id.message);
            message.setText("Faltan campos por llenar");
            Button button = view.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        } else {
            try {
                if (isConnectedToInternet()) {

                    SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                    int idDocente = sharedPref.getInt("idDocente", -1);
                    RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
                    StringRequest solicitud = new StringRequest(Request.Method.POST, Api.GUARDAR_ASIGNATURA, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject respuesta = new JSONObject(response);
                                if (!respuesta.getBoolean("error")) {
                                    guardarAsignatura();
                                    Toast.makeText(Asignatura.this, "Se realizó correctamente el registro", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Asignatura.this, MainActivity.class);
                                    intent.putExtra("FRAGMENT_TO_LOAD", "Asignaturas");
                                    startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Asignatura.this);
                                    LayoutInflater inflater = Asignatura.this.getLayoutInflater();
                                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                                    builder.setView(dialogView);

                                    AlertDialog dialog = builder.create();

                                    TextView title = dialogView.findViewById(R.id.title);
                                    title.setText("Ocurrió un error");
                                    TextView message = dialogView.findViewById(R.id.message);
                                    message.setText("No se pudo guardar el grupo");
                                    Button button = dialogView.findViewById(R.id.button);
                                    button.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog.dismiss();
                                        }
                                    });
                                    dialog.show();
                                }
                            } catch (JSONException e) {
                                Log.d(TAG, "" + e.getMessage());
                                AlertDialog.Builder builder = new AlertDialog.Builder(Asignatura.this);
                                LayoutInflater inflater = Asignatura.this.getLayoutInflater();
                                View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                                builder.setView(dialogView);

                                AlertDialog dialog = builder.create();

                                TextView title = dialogView.findViewById(R.id.title);
                                title.setText("Ocurrió un error");
                                TextView message = dialogView.findViewById(R.id.message);
                                message.setText("No se pudo guardar el grupo");
                                Button button = dialogView.findViewById(R.id.button);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, "" + error.getMessage());
                            AlertDialog.Builder builder = new AlertDialog.Builder(Asignatura.this);
                            LayoutInflater inflater = Asignatura.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(dialogView);

                            AlertDialog dialog = builder.create();

                            TextView title = dialogView.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = dialogView.findViewById(R.id.message);
                            message.setText("Se ocasionó un error al obtener respuesta del servidor");
                            Button button = dialogView.findViewById(R.id.button);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> parametros = new HashMap<String, String>();
                            parametros.put("asignatura", spAsignatura.getSelectedItem().toString());
                            parametros.put("claveAsignatura", txtClaveAsignatura.getText().toString());
                            parametros.put("claveGrupo", txtClaveGrupo.getText().toString());
                            parametros.put("codigoAsignatura", generarCodigo());
                            parametros.put("idDocente", String.valueOf(idDocente));
                            return parametros;
                        }
                    };
                    colaDeSolicitudes.add(solicitud);
                }else{
                    SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                    int idDocente = sharedPref.getInt("idDocente", -1);
                    AAsignatura g = new AAsignatura(this);
                    MAsignatura m = new MAsignatura();
                    String asignaturaSeleccionada = spAsignatura.getSelectedItem().toString();
                    m.setAsignatura(asignaturaSeleccionada);
                    m.setClaveAsignatura(txtClaveAsignatura.getText().toString());
                    m.setClaveGrupo(txtClaveGrupo.getText().toString());
                    m.setCodigoAsignatura(generarCodigo());
                    m.setIdDocente(idDocente);
                    AEstudiante e = new AEstudiante(this);
                    e.insertarEstudiantes();
                    g.guardar(m);
                }
            }catch(Exception e){
                Toast.makeText(Asignatura.this, "Falló el registro" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void guardarAsignatura() {
        SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        int idDocente = sharedPref.getInt("idDocente", -1);
        AAsignatura g = new AAsignatura(this);
        MAsignatura m = new MAsignatura();
        String asignaturaSeleccionada = spAsignatura.getSelectedItem().toString();
        m.setAsignatura(asignaturaSeleccionada);
        m.setClaveAsignatura(txtClaveAsignatura.getText().toString());
        m.setClaveGrupo(txtClaveGrupo.getText().toString());
        m.setCodigoAsignatura(generarCodigo());
        m.setIdDocente(idDocente);
        AEstudiante e = new AEstudiante(this);
        e.insertarEstudiantes();
        g.guardar(m);
    }

    private void clicBack() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("FRAGMENT_TO_LOAD", "Asignaturas");
        startActivity(intent);
    }
    private String generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();
        while (codigo.length() < 3) { // length of the random string.
            int index = (int) (rnd.nextFloat() * caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        String claveGrupo = txtClaveGrupo.getText().toString();
        if (claveGrupo.length() >= 2) {
            codigo.append(claveGrupo.substring(claveGrupo.length() - 2));
        }
        return codigo.toString();
    }
    public boolean isConnectedToInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
