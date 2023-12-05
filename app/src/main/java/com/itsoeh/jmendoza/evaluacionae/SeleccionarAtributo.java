package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SeleccionarAtributo extends AppCompatActivity {
    private LinearLayout linearAtrib1, linearAtrib2, linearAtrib3, linearAtrib4, linearAtrib5;
    private TextView txtAtrib1, txtAtrib2, txtAtrib3, txtAtrib4, txtAtrib5;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_atributo);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        linearAtrib1 = findViewById(R.id.select_atri_layout_atributo1);
        linearAtrib2 = findViewById(R.id.select_atri_layout_atributo2);
        linearAtrib3 = findViewById(R.id.select_atri_layout_atributo3);
        linearAtrib4 = findViewById(R.id.select_atri_layout_atributo4);
        linearAtrib5 = findViewById(R.id.select_atri_layout_atributo5);
        Intent intent = getIntent();
        int idEstudiante = intent.getIntExtra("idEstudiante", -1);
        String codigoAsignatura = intent.getStringExtra("codigoAsignatura");
        linearAtrib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib1(idEstudiante, codigoAsignatura);
            }
        });
        linearAtrib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib2(idEstudiante, codigoAsignatura);
            }
        });
        linearAtrib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib3(idEstudiante, codigoAsignatura);
            }
        });
        linearAtrib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib4(idEstudiante, codigoAsignatura);
            }
        });
        linearAtrib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib5(idEstudiante, codigoAsignatura);
            }
        });

        txtAtrib1 =  findViewById(R.id.select_atri_txt_atributo1_nombre);
        txtAtrib2 =  findViewById(R.id.select_atri_txt_atributo2_nombre);
        txtAtrib3 =  findViewById(R.id.select_atri_txt_atributo3_nombre);
        txtAtrib4 =  findViewById(R.id.select_atri_txt_atributo4_nombre);
        txtAtrib5 =  findViewById(R.id.select_atri_txt_atributo5_nombre);
        btnBack = findViewById(R.id.select_atri_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void clicAtrib1(int idStudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, AsignarAtributo.class);
        intent.putExtra("atributo1", "A1.-Aplicaciones Computacionales");
        intent.putExtra("idStudiante", idStudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        startActivity(intent);
    }
    private void clicAtrib2(int idStudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, AsignarAtributo.class);
        intent.putExtra("atributo2", "A2.-Modelos Computacionales");
        intent.putExtra("idStudiante", idStudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        startActivity(intent);
    }
    private void clicAtrib3(int idStudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, AsignarAtributo.class);
        intent.putExtra("atributo3", "A3.- Trabajo en Equipo y Comunicación");
        intent.putExtra("idStudiante", idStudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        startActivity(intent);
    }
    private void clicAtrib4(int idStudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, AsignarAtributo.class);
        intent.putExtra("atributo4", "A4.- Investigación");
        intent.putExtra("idStudiante", idStudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        startActivity(intent);
    }
    private void clicAtrib5(int idStudiante, String codigoAsignatura) {
        Intent intent = new Intent(this, AsignarAtributo.class);
        intent.putExtra("idStudiante", idStudiante);
        intent.putExtra("codigoAsignatura", codigoAsignatura);
        intent.putExtra("atributo5", "A5.- Preparación para la vida profesional");
        startActivity(intent);
    }
}