package com.itsoeh.jmendoza.evaluacionae;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAtributo;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAtributo;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAsignatura;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterAtributo;

import java.util.ArrayList;

public class AtributosEgreso extends AppCompatActivity {
    private EditText txtBuscar;
    private Button btnBack;
    private ImageButton btnAgregar;
    private RecyclerView recLista;
    private ArrayList<MAtributo> lista;
    private AdapterAtributo x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos_egreso);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //btnAgregar = findViewById(R.id.condoc_fbtn_agregar);
        //txtBuscar = findViewById(R.id.condoc_txtBusca);
        recLista = findViewById(R.id.atributos_egre_rec_lista);
        btnAgregar = findViewById(R.id.atributos_egre_add_button);
        TextView emptyView = findViewById(R.id.tv_empty);
        btnBack= findViewById(R.id.atributos_egre_btn__back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAgregar();
            }
        });
        AAtributo u = new AAtributo(this);
        lista = u.listar();
        x = new AdapterAtributo(lista, emptyView);
        recLista.setAdapter(x);
        x.updateData(lista);
        /* btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clicAgregar();
            }
        });
        txtBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //yfiltrar(s.toString());
            }
        });
    }

         */

    /*private void filtrar(String t){
        ArrayList<MDocente> listaFiltrada  = new ArrayList<MDocente>();
        for(MDocente e:lista){
            if(e.getNombre().toLowerCase().contains(t.toLowerCase())||e.getApp().toLowerCase().contains(t.toLowerCase())
                    ||e.getApm().toLowerCase().contains(t.toLowerCase()))
                listaFiltrada.add(e);
        }
        x.filtro(listaFiltrada);
    }
*/
  /* private void clicAgregar() {
        nav.navigate(R.id.docente);
    }

   */
    }

    private void clicAgregar() {
        Intent intent = new Intent(this, SeleccionarAtributo.class);
        startActivity(intent);
    }
}
