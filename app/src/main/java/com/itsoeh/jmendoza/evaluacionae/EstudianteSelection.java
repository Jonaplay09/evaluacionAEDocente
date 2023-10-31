package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;

import java.util.ArrayList;

public class EstudianteSelection extends AppCompatActivity {
    private TextView txtMateria, txtAsignat, txtGrupo, txtcodigoGrupo, txtAtributo;
    private RecyclerView recLista;
    private NavController nav;
    private ArrayList<MAsignatura> lista;
    //private AdapterAsignatura x;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_selection);
        txtMateria = findViewById(R.id.student_select_txt_materia);
        txtAsignat = findViewById(R.id.student_select_txt_claveAsig);
        txtGrupo = findViewById(R.id.student_select_txt_claveGrupo);
        txtcodigoGrupo = findViewById(R.id.student_select_txt_codiGrupo);

        // Obtiene los datos del Intent
        Intent intent = getIntent();
        String asignatura = intent.getStringExtra("asignatura");
        String claveAsignatura = intent.getStringExtra("claveAsignatura");
        String claveGrupo = intent.getStringExtra("claveGrupo");
        String codigoAsignatura = intent.getStringExtra("codigoAsignatura");

        // Establece los datos en las vistas de texto
        txtMateria.setText(asignatura);
        txtAsignat.setText(claveAsignatura);
        txtGrupo.setText(claveGrupo);
        txtcodigoGrupo.setText(codigoAsignatura);
    }

}