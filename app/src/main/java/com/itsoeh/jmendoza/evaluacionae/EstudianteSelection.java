package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AEstudiante;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MEstudiante;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterEstudiante;

import java.util.ArrayList;

public class EstudianteSelection extends AppCompatActivity {
    private TextView txtMateria, txtAsignat, txtGrupo, txtcodigoGrupo, txtAtributo, txtAsignarAtri;
    private Button btnBack;
    private RecyclerView recLista;
    private NavController nav;
    private ArrayList<MAsignatura> lista;
    //private AdapterAsignatura x;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_selection);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        txtMateria = findViewById(R.id.student_select_txt_materia);
        txtAsignarAtri = findViewById(R.id.student_select_btn_atribu);
        txtAsignarAtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brinco = new Intent(EstudianteSelection.this, SeleccionarAtributo.class);
                startActivity(brinco);
            }
        });
        txtAsignat = findViewById(R.id.student_select_txt_claveAsig);
        txtGrupo = findViewById(R.id.student_select_txt_claveGrupo);
        txtcodigoGrupo = findViewById(R.id.student_select_txt_codiGrupo);
        recLista = findViewById(R.id.student_select_rec_lista);
        btnBack = findViewById(R.id.studnet_select_btn__back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
        AEstudiante u = new AEstudiante(this);
        ArrayList<MEstudiante> lista = u.listar();
        AdapterEstudiante adapter = new AdapterEstudiante(lista);
        recLista.setAdapter(adapter);
    }

}