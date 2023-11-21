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

public class CambiarPassword extends AppCompatActivity {

    private Button btn_login_back2, btnGuardarCambios;
    private EditText txtOldPass, txtNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_password);
        btnGuardarCambios = findViewById(R.id.chapass_btn_guardar);
        txtOldPass = findViewById(R.id.chapass_txt_oldpass);
        txtNewPass = findViewById(R.id.chapass_txt_newpass);
        btn_login_back2 = findViewById(R.id.chapass_btn_back);
        btn_login_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordAntiguo = txtOldPass.getText().toString();
                String passwordNuevo = txtNewPass.getText().toString();
                if(passwordAntiguo.equals("") && passwordNuevo.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(CambiarPassword.this);
                    LayoutInflater inflater = CambiarPassword.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Ocurrió un error");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Debes completar todos los datos requeridos");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }else {
                    if (Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d:,.!?@°]+$", passwordNuevo)) {
                        if(passwordNuevo.length() >= 8) {
                            SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                            int idDocente = sharedPref.getInt("idDocente", -1);
                            ADocente aDocente = new ADocente(getApplicationContext());
                            boolean actualizacionExitosa = aDocente.actualizarPassword(idDocente, passwordAntiguo, passwordNuevo);
                            if (actualizacionExitosa) {
                                Toast.makeText(CambiarPassword.this, "Contraseña actualizada exitosamente", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CambiarPassword.this);
                                LayoutInflater inflater = CambiarPassword.this.getLayoutInflater();
                                View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                                builder.setView(dialogView);
                                AlertDialog dialog = builder.create();
                                TextView title = dialogView.findViewById(R.id.title);
                                title.setText("Ocurrió un error");
                                TextView message = dialogView.findViewById(R.id.message);
                                message.setText("No se pudo actualizar la contraseña");
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
                            AlertDialog.Builder builder = new AlertDialog.Builder(CambiarPassword.this);
                            LayoutInflater inflater = CambiarPassword.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                            builder.setView(dialogView);
                            AlertDialog dialog = builder.create();
                            TextView title = dialogView.findViewById(R.id.title);
                            title.setText("Ocurrió un error");
                            TextView message = dialogView.findViewById(R.id.message);
                            message.setText("La nueva contraseña debe de contener más de 8 caracteres");
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(CambiarPassword.this);
                        LayoutInflater inflater = CambiarPassword.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                        builder.setView(dialogView);
                        AlertDialog dialog = builder.create();
                        TextView title = dialogView.findViewById(R.id.title);
                        title.setText("Ocurrió un error");
                        TextView message = dialogView.findViewById(R.id.message);
                        message.setText("La nueva contraseña debe contener letras y números");
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