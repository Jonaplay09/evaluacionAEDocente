package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        linearAtrib1 = findViewById(R.id.select_atri_layout_atributo1);
        linearAtrib2 = findViewById(R.id.select_atri_layout_atributo2);
        linearAtrib3 = findViewById(R.id.select_atri_layout_atributo3);
        linearAtrib4 = findViewById(R.id.select_atri_layout_atributo4);
        linearAtrib5 = findViewById(R.id.select_atri_layout_atributo5);
        linearAtrib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib1();
            }
        });
        linearAtrib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib2();
            }
        });
        linearAtrib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib3();
            }
        });
        linearAtrib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib4();
            }
        });
        linearAtrib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAtrib5();
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

    private void clicAtrib1() {
        Intent intent = new Intent(this, AsignarAtributo.class);
        startActivity(intent);
    }
    private void clicAtrib2() {
        Intent intent = new Intent(this, AsignarAtributo.class);
        startActivity(intent);
    }
    private void clicAtrib3() {
        Intent intent = new Intent(this, AsignarAtributo.class);
        startActivity(intent);
    }
    private void clicAtrib4() {
        Intent intent = new Intent(this, AsignarAtributo.class);
        startActivity(intent);
    }
    private void clicAtrib5() {
        Intent intent = new Intent(this, AsignarAtributo.class);
        startActivity(intent);
    }
}