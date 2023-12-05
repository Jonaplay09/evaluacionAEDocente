package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.google.android.material.tabs.TabLayout;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.ADocente;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private Button btnEntrada, btnRegistro;
    private EditText txtUsuario, txtPassword;
    private TextView  txtForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        btnEntrada = findViewById(R.id.login_btn_entrar);
        btnRegistro = findViewById(R.id.login_btn_registrar);
        txtUsuario = findViewById(R.id.login_txt_correo);
        txtPassword = findViewById(R.id.login_txt_contrasenia);
        txtForgot = (TextView) findViewById(R.id.login_btn_forgetPassword);
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicForgot();
            }
        });
        btnEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicEntrar();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicRegistro();
            }
        });
    }

    private void clicForgot() {
        Intent brinco = new Intent(Login.this, Recuperarcontra.class);
        startActivity(brinco);
    }

    private void clicRegistro() {
        Intent brinco = new Intent(this, Registrar.class);
        startActivity(brinco);
    }

    private void clicEntrar() {
        String correo = txtUsuario.getText().toString();
        String contrasenia = txtPassword.getText().toString();
        if(correo.equals("")||contrasenia.equals("")) {
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
        }else{
            if (Pattern.matches("^[a-zA-Z0-9._%+-]+@itsoeh\\.edu\\.mx\\s*$", correo)) {
                try {
                    if (isConnectedToInternet()) {

                        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
                        StringRequest solicitud = new StringRequest(Request.Method.POST, Api.BUSCARCONTRASENIA, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject respuesta = new JSONObject(response);
                                    if (!respuesta.getBoolean("error")) {
                                        JSONArray datos = respuesta.getJSONArray("contenido");
                                        String nombre = datos.getString(0);
                                        String password = datos.getString(1);
                                        if (datos != null) {
                                            loggearse();
                                        }
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                        LayoutInflater inflater = Login.this.getLayoutInflater();
                                        View view = inflater.inflate(R.layout.dialog_layout, null);
                                        builder.setView(view);
                                        AlertDialog dialog = builder.create();
                                        TextView title = view.findViewById(R.id.title);
                                        title.setText("Ocurrió un error");
                                        TextView message = view.findViewById(R.id.message);
                                        message.setText("El usuario o contraseña son incorrectos");
                                        Button button = view.findViewById(R.id.button);
                                        button.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.dismiss();
                                            }
                                        });
                                        dialog.show();
                                    }
                                } catch (JSONException e) {
                                    Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Error al procesar la respuesta JSON: " + e.getMessage());
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                alertDialogLog();
                            }
                        }){
                            @Override
                            protected Map<String, String> getParams(){
                                Map<String, String> parametros = new HashMap<String, String>();
                                parametros.put("correo", correo);
                                parametros.put("contrasenia", contrasenia);
                                return parametros;
                            }
                        };
                        colaDeSolicitudes.add(solicitud);
                    } else {
                        ADocente docente = new ADocente(this);
                        String [] datos = docente.buscarContrasenia(correo, contrasenia);
                        if (datos != null) {
                            ADocente aDocente = new ADocente(getApplicationContext());
                            int idDocente = aDocente.obtenerIdDocente(correo);
                            SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("email", correo);
                            editor.putInt("idDocente", idDocente);
                            editor.apply();
                            Log.d(TAG, "Correo guardado: " + sharedPref.getString("email", null));
                            Log.d(TAG, "ID del docente guardado: " + sharedPref.getInt("idDocente", -1));
                            Intent brinco = new Intent(this, MainActivity.class);
                            startActivity(brinco);
                            Toast.makeText(Login.this, "Te has loggeado exitosamente", Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            LayoutInflater inflater = this.getLayoutInflater();
                            View view = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(view);
                            AlertDialog dialog = builder.create();
                            TextView title = view.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = view.findViewById(R.id.message);
                            message.setText("El usuario o contraseña son incorrectos");
                            Button button = view.findViewById(R.id.button);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    LayoutInflater inflater = this.getLayoutInflater();
                    View view = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(view);
                    AlertDialog dialog = builder.create();
                    TextView title = view.findViewById(R.id.title);
                    title.setText("Ocurrió un error");
                    TextView message = view.findViewById(R.id.message);
                    message.setText("Se produjo un error desconocido");
                    Button button = view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Ocurrió un error");
                TextView message = view.findViewById(R.id.message);
                message.setText("El correo electrónico no pertenece al dominio itsoeh o no esta registrado");
                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        }
    }

    private void alertDialogLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        TextView title = view.findViewById(R.id.title);
        title.setText("Ocurrió un error");
        TextView message = view.findViewById(R.id.message);
        message.setText("El usuario o contraseña son incorrectos");
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void loggearse() {
        String correo = txtUsuario.getText().toString();
        RequestQueue colaDeSolicitudes = VolleySingleton.getInstance(this).getRequestQueue();
        StringRequest solicitud = new StringRequest(Request.Method.POST, Api.OBTENERIDDOCENTE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject respuesta = new JSONObject(response);
                    if (!respuesta.getBoolean("error")) {
                        int idDocente = respuesta.getInt("contenido");
                        SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("email", correo);
                        editor.putInt("idDocente", idDocente);
                        editor.apply();
                        Log.d(TAG, "Correo guardado: " + sharedPref.getString("email", null));
                        Log.d(TAG, "ID del docente guardado: " + sharedPref.getInt("idDocente", -1));
                        Intent brinco = new Intent(Login.this, MainActivity.class);
                        startActivity(brinco);

                        Toast.makeText(Login.this, "Te has loggeado exitosamente", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, respuesta.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                alertDialogId();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("correo", correo);
                return parametros;
            }
        };
        colaDeSolicitudes.add(solicitud);
    }

    private void alertDialogId() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        TextView title = view.findViewById(R.id.title);
        title.setText("Ocurrió un error");
        TextView message = view.findViewById(R.id.message);
        message.setText("El usuario no existe");
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public boolean isConnectedToInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }



}