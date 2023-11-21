package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.ADocente;

public class CambiarCorreo extends AppCompatActivity {

    private Button btn_back, btnGuardarCambios;
    private EditText txtOldEmail, txtNewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_correo);
        btn_back = findViewById(R.id.chaemail_btn_back);
        btnGuardarCambios = findViewById(R.id.chaemail_btn_guardar);
        txtOldEmail = findViewById(R.id.chaemail_txt_oldemail);
        txtNewEmail = findViewById(R.id.chaemail_txt_newemail);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoAntiguo = txtOldEmail.getText().toString();
                String correoNuevo = txtNewEmail.getText().toString();
                if (correoAntiguo.equals("") || correoNuevo.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CambiarCorreo.this);
                    LayoutInflater inflater = CambiarCorreo.this.getLayoutInflater();
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
                } else {
                    ADocente aDocente = new ADocente(getApplicationContext());
                    SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                    String correoAlmacenado = sharedPref.getString("email", "");
                    if (correoAlmacenado.equals(correoAntiguo)) {
                        boolean actualizacionExitosa = aDocente.actualizarCorreo(correoAntiguo, correoNuevo);
                        if (!actualizacionExitosa) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(CambiarCorreo.this);
                            LayoutInflater inflater = CambiarCorreo.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(dialogView);

                            AlertDialog dialog = builder.create();
                            TextView title = dialogView.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = dialogView.findViewById(R.id.message);
                            message.setText("El correo anterior no existe");
                            Button button = dialogView.findViewById(R.id.button);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });

                            dialog.show();
                        }else{
                            Toast.makeText(CambiarCorreo.this, "Correo actualizado exitosamente", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CambiarCorreo.this, Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finishAffinity();
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CambiarCorreo.this);
                        LayoutInflater inflater = CambiarCorreo.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                        builder.setView(dialogView);
                        AlertDialog dialog = builder.create();
                        TextView title = dialogView.findViewById(R.id.title);
                        title.setText("Ocurrió un error");
                        TextView message = dialogView.findViewById(R.id.message);
                        message.setText("El correo anterior no existe");
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
            }
        });
    }
}