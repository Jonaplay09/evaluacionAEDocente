package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EstudianteSelection extends AppCompatActivity {
    private Button estsel_btn_est1, estsel_btn_est2, estsel_btn_est3, estsel_btn_est4, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_selection);
        /*estsel_btn_est1 = findViewById(R.id.estsel_btn_est1);
        estsel_btn_est2 = findViewById(R.id.estsel_btn_est2);
        estsel_btn_est3 = findViewById(R.id.estsel_btn_est3);
        estsel_btn_est4 = findViewById(R.id.estsel_btn_est4);
        btnBack = findViewById(R.id.estselect_btn__back);



        estsel_btn_est1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEst1();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        estsel_btn_est2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEst2();
            }
        });
        estsel_btn_est3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEst3();
            }
        });
        estsel_btn_est4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEst4();
            }
        });
    }



    private void clicEst2() {
        Intent intent = new Intent(this, EvalAtributtes.class);
        startActivity(intent);
    }

    private void clicEst1() {
        Intent intent = new Intent(this, EvalAtributtes.class);
        startActivity(intent);
    }
    private void clicEst3() {
        Intent intent = new Intent(this, EvalAtributtes.class);
        startActivity(intent);
    }
    private void clicEst4() {
        Intent intent = new Intent(this, EvalAtributtes.class);
        startActivity(intent);
    }

         */
    }
}