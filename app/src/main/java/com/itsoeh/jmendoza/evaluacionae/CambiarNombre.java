package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.ADocente;

import java.util.regex.Pattern;

public class CambiarNombre extends AppCompatActivity {

    private Button btn_login_back2, btnGuardarCambios;
    private EditText txtNombre,  txtApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_nombre);
        btn_login_back2 = findViewById(R.id.chaname_btn_back);
        btnGuardarCambios = findViewById(R.id.chaname_btn_guardar);
        txtNombre = findViewById(R.id.chaname_txt_nombre);
        txtApellidos = findViewById(R.id.chaname_txt_apellidos);
        btn_login_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreNuevo = txtNombre.getText().toString();
                String apellidosNuevo = txtApellidos.getText().toString();
                if (nombreNuevo.equals("") || apellidosNuevo.equals("")) {
                    if (Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", nombreNuevo)) {
                        if (Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", apellidosNuevo)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(CambiarNombre.this);
                            LayoutInflater inflater = CambiarNombre.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(dialogView);

                            AlertDialog dialog = builder.create();

                            TextView title = dialogView.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = dialogView.findViewById(R.id.message);
                            message.setText("Completa los datos requeridos");
                            Button button = dialogView.findViewById(R.id.button);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(CambiarNombre.this);
                            LayoutInflater inflater = CambiarNombre.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(dialogView);

                            AlertDialog dialog = builder.create();

                            TextView title = dialogView.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = dialogView.findViewById(R.id.message);
                            message.setText("Formato de apellidos incorrecto");
                            Button button = dialogView.findViewById(R.id.button);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();

                        }
                        }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(CambiarNombre.this);
                        LayoutInflater inflater = CambiarNombre.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                        builder.setView(dialogView);

                        AlertDialog dialog = builder.create();

                        TextView title = dialogView.findViewById(R.id.title);
                        title.setText("Ocurrió un error");
                        TextView message = dialogView.findViewById(R.id.message);
                        message.setText("Formato de nombre incorrecto");
                        Button button = dialogView.findViewById(R.id.button);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();

                        }
                }else{
                    SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                    int idDocente = sharedPref.getInt("idDocente", -1);
                    ADocente aDocente = new ADocente(getApplicationContext());
                    try {
                        boolean actualizacionExitosa = aDocente.actualizarNombre(idDocente, nombreNuevo, apellidosNuevo);
                        if (actualizacionExitosa) {
                            Toast.makeText(CambiarNombre.this, "Nombre actualizado a: " + nombreNuevo + " " + apellidosNuevo, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }catch(Exception e){
                        Toast.makeText(CambiarNombre.this, "Ocurrió un error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}