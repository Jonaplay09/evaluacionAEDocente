package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.itsoeh.jmendoza.evaluacionae.models.MCriterio;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterCriterio;
import java.util.ArrayList;

public class AsignarAtributo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_atributo);

        Spinner spinner = findViewById(R.id.asig_atributo_sp_Nivel);
    }
}

