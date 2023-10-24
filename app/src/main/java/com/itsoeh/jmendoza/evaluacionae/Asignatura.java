package com.itsoeh.jmendoza.evaluacionae;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.ADocente;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;

import java.util.Random;

public class Asignatura extends AppCompatActivity {
    private Button btnBackLog, btnRegistrar;
    private EditText txtClaveAsignatura, txtClaveGrupo;
    private Spinner spAsignatura;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);
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
            AlertDialog.Builder aviso = new AlertDialog.Builder(this);
            aviso.setTitle("Campos vacíos")
                    .setMessage("Por favor llena todos los datos requeridos")
                    .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        } else {
            try {

                AAsignatura g = new AAsignatura(this);
                MAsignatura m = new MAsignatura();
                String asignaturaSeleccionada = spAsignatura.getSelectedItem().toString();
                m.setAsignatura(asignaturaSeleccionada);
                m.setClaveAsignatura(txtClaveAsignatura.getText().toString());
                m.setClaveGrupo(txtClaveGrupo.getText().toString());
                m.setCodigoAsignatura(generarCodigo());
                g.guardar(m);
                Toast.makeText(Asignatura.this, "Se realizó correctamente el registro", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("FRAGMENT_TO_LOAD", "Asignaturas");
                startActivity(intent);
            }catch(Exception e){
                Toast.makeText(Asignatura.this, "Falló el registro" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
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

}
