package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.itsoeh.jmendoza.evaluacionae.models.MCriterio;
import com.itsoeh.jmendoza.evaluacionae.radapter.AdapterCriterio;
import java.util.ArrayList;

public class AsignarAtributo extends AppCompatActivity {
    private TextView txtNombreAtributo, txtEmpty;
    private CardView inc1Atri1, inc2Atri1, inc3Atri1, mid1Atri1, mid2Atri1, mid3Atri1, ava1Atri1, ava2Atri1, ava3Atri1,
            inc1Atri2, inc2Atri2, mid1Atri2, mid2Atri2, ava1Atri2, ava2Atri2,
            inc1Atri3, inc2Atri3, inc3Atri3, mid1Atri3, mid2Atri3, mid3Atri3, ava1Atri3, ava2Atri3, ava3Atri3,
            inc1Atri4, inc2Atri4, inc3Atri4, mid1Atri4, mid2Atri4, mid3Atri4, ava1Atri4, ava2Atri4, ava3Atri4,
            inc1Atri5, inc2Atri5, inc3Atri5, mid1Atri5, mid2Atri5, mid3Atri5, ava1Atri5, ava2Atri5, ava3Atri5;
    private Button btnAtributoDescripcion, botonBack,inc1_btnDescripAtri1, inc2_btnDescripAtri1, inc3_btnDescripAtri1, mid1_btnDescripAtri1, mid2_btnDescripAtri1, mid3_btnDescripAtri1, ava1_btnDescripAtri1, ava2_btnDescripAtri1, ava3_btnDescripAtri1,
            inc1_btnDescripAtri2, inc2_btnDescripAtri2, mid1_btnDescripAtri2, mid2_btnDescripAtri2, ava1_btnDescripAtri2, ava2_btnDescripAtri2,
            inc1_btnDescripAtri3, inc2_btnDescripAtri3, inc3_btnDescripAtri3, mid1_btnDescripAtri3, mid2_btnDescripAtri3, mid3_btnDescripAtri3, ava1_btnDescripAtri3, ava2_btnDescripAtri3, ava3_btnDescripAtri3,
            inc1_btnDescripAtri4, inc2_btnDescripAtri4, inc3_btnDescripAtri4, mid1_btnDescripAtri4, mid2_btnDescripAtri4, mid3_btnDescripAtri4, ava1_btnDescripAtri4, ava2_btnDescripAtri4, ava3_btnDescripAtri4,
            inc1_btnDescripAtri5, inc2_btnDescripAtri5, inc3_btnDescripAtri5, mid1_btnDescripAtri5, mid2_btnDescripAtri5, mid3_btnDescripAtri5, ava1_btnDescripAtri5, ava2_btnDescripAtri5, ava3_btnDescripAtri5;

    private EditText txtMeta, txtLogro,inc1_txtCriterioAtri1, inc2_txtCriterioAtri1, inc3_txtCriterioAtri1, mid1_txtCriterioAtri1, mid2_txtCriterioAtri1, mid3_txtCriterioAtri1, ava1_txtCriterioAtri1, ava2_txtCriterioAtri1, ava3_txtCriterioAtri1,
            inc1_txtCriterioAtri2, inc2_txtCriterioAtri2, mid1_txtCriterioAtri2, mid2_txtCriterioAtri2, ava1_txtCriterioAtri2, ava2_txtCriterioAtri2,
            inc1_txtCriterioAtri3, inc2_txtCriterioAtri3, inc3_txtCriterioAtri3, mid1_txtCriterioAtri3, mid2_txtCriterioAtri3, mid3_txtCriterioAtri3, ava1_txtCriterioAtri3, ava2_txtCriterioAtri3, ava3_txtCriterioAtri3,
            inc1_txtCriterioAtri4, inc2_txtCriterioAtri4, inc3_txtCriterioAtri4, mid1_txtCriterioAtri4, mid2_txtCriterioAtri4, mid3_txtCriterioAtri4, ava1_txtCriterioAtri4, ava2_txtCriterioAtri4, ava3_txtCriterioAtri4,
            inc1_txtCriterioAtri5, inc2_txtCriterioAtri5, inc3_txtCriterioAtri5, mid1_txtCriterioAtri5, mid2_txtCriterioAtri5, mid3_txtCriterioAtri5, ava1_txtCriterioAtri5, ava2_txtCriterioAtri5, ava3_txtCriterioAtri5;

    private EditText inc1_txtPuntosAtri1, inc2_txtPuntosAtri1, inc3_txtPuntosAtri1, mid1_txtPuntosAtri1, mid2_txtPuntosAtri1, mid3_txtPuntosAtri1, ava1_txtPuntosAtri1, ava2_txtPuntosAtri1, ava3_txtPuntosAtri1,
            inc1_txtPuntosAtri2, inc2_txtPuntosAtri2, mid1_txtPuntosAtri2, mid2_txtPuntosAtri2, ava1_txtPuntosAtri2, ava2_txtPuntosAtri2,
            inc1_txtPuntosAtri3, inc2_txtPuntosAtri3, inc3_txtPuntosAtri3, mid1_txtPuntosAtri3, mid2_txtPuntosAtri3, mid3_txtPuntosAtri3, ava1_txtPuntosAtri3, ava2_txtPuntosAtri3, ava3_txtPuntosAtri3,
            inc1_txtPuntosAtri4, inc2_txtPuntosAtri4, inc3_txtPuntosAtri4, mid1_txtPuntosAtri4, mid2_txtPuntosAtri4, mid3_txtPuntosAtri4, ava1_txtPuntosAtri4, ava2_txtPuntosAtri4, ava3_txtPuntosAtri4,
            inc1_txtPuntosAtri5, inc2_txtPuntosAtri5, inc3_txtPuntosAtri5, mid1_txtPuntosAtri5, mid2_txtPuntosAtri5, mid3_txtPuntosAtri5, ava1_txtPuntosAtri5, ava2_txtPuntosAtri5, ava3_txtPuntosAtri5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_atributo);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        Spinner spinner = findViewById(R.id.asig_atributo_sp_Nivel);
        txtNombreAtributo = findViewById(R.id.asig_atributo_txt_materia);
        botonBack = findViewById(R.id.asig_atributo_btn__back);
        txtEmpty = findViewById(R.id.asig_atrib_txt_empty);
        btnAtributoDescripcion = findViewById(R.id.asig_atributo_btn_descripcion);
        txtLogro = findViewById(R.id.asig_atrib_txt_logro);
        txtMeta = findViewById(R.id.asig_atrib_txt_meta);
        botonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        inc1Atri1 = findViewById(R.id.itemcrit_inc1_atri1_card);
        inc2Atri1 = findViewById(R.id.itemcrit_inc2_atri1_card);
        inc3Atri1 = findViewById(R.id.itemcrit_inc3_atri1_card);
        mid1Atri1 = findViewById(R.id.itemcrit_mid1_atri1_card);
        mid2Atri1 = findViewById(R.id.itemcrit_mid2_atri1_card);
        mid3Atri1 = findViewById(R.id.itemcrit_mid3_atri1_card);
        ava1Atri1 = findViewById(R.id.itemcrit_ava1_atri1_card);
        ava2Atri1 = findViewById(R.id.itemcrit_ava2_atri1_card);
        ava3Atri1 = findViewById(R.id.itemcrit_ava3_atri1_card);

        inc1Atri2 = findViewById(R.id.itemcrit_inc1_atri2_card);
        inc2Atri2 = findViewById(R.id.itemcrit_inc2_atri2_card);
        mid1Atri2 = findViewById(R.id.itemcrit_mid1_atri2_card);
        mid2Atri2 = findViewById(R.id.itemcrit_mid2_atri2_card);
        ava1Atri2 = findViewById(R.id.itemcrit_ava1_atri2_card);
        ava2Atri2 = findViewById(R.id.itemcrit_ava2_atri2_card);

        inc1Atri3 = findViewById(R.id.itemcrit_inc1_atri3_card);
        inc2Atri3 = findViewById(R.id.itemcrit_inc2_atri3_card);
        inc3Atri3 = findViewById(R.id.itemcrit_inc3_atri3_card);
        mid1Atri3 = findViewById(R.id.itemcrit_mid1_atri3_card);
        mid2Atri3 = findViewById(R.id.itemcrit_mid2_atri3_card);
        mid3Atri3 = findViewById(R.id.itemcrit_mid3_atri3_card);
        ava1Atri3 = findViewById(R.id.itemcrit_ava1_atri3_card);
        ava2Atri3 = findViewById(R.id.itemcrit_ava2_atri3_card);
        ava3Atri3 = findViewById(R.id.itemcrit_ava3_atri3_card);

        inc1Atri4 = findViewById(R.id.itemcrit_inc1_atri4_card);
        inc2Atri4 = findViewById(R.id.itemcrit_inc2_atri4_card);
        inc3Atri4 = findViewById(R.id.itemcrit_inc3_atri4_card);
        mid1Atri4 = findViewById(R.id.itemcrit_mid1_atri4_card);
        mid2Atri4 = findViewById(R.id.itemcrit_mid2_atri4_card);
        mid3Atri4 = findViewById(R.id.itemcrit_mid3_atri4_card);
        ava1Atri4 = findViewById(R.id.itemcrit_ava1_atri4_card);
        ava2Atri4 = findViewById(R.id.itemcrit_ava2_atri4_card);
        ava3Atri4 = findViewById(R.id.itemcrit_ava3_atri4_card);

        inc1Atri5 = findViewById(R.id.itemcrit_inc1_atri5_card);
        inc2Atri5 = findViewById(R.id.itemcrit_inc2_atri5_card);
        inc3Atri5 = findViewById(R.id.itemcrit_inc3_atri5_card);
        mid1Atri5 = findViewById(R.id.itemcrit_mid1_atri5_card);
        mid2Atri5 = findViewById(R.id.itemcrit_mid2_atri5_card);
        mid3Atri5 = findViewById(R.id.itemcrit_mid3_atri5_card);
        ava1Atri5 = findViewById(R.id.itemcrit_ava1_atri5_card);
        ava2Atri5 = findViewById(R.id.itemcrit_ava2_atri5_card);
        ava3Atri5 = findViewById(R.id.itemcrit_ava3_atri5_card);
        inc1_btnDescripAtri1 = findViewById(R.id.itemcrit_inc1_atri1_button_descripcion);
        inc2_btnDescripAtri1 = findViewById(R.id.itemcrit_inc2_atri1_button_descripcion);
        inc3_btnDescripAtri1 = findViewById(R.id.itemcrit_inc3_atri1_button_descripcion);
        mid1_btnDescripAtri1 = findViewById(R.id.itemcrit_mid1_atri1_button_descripcion);
        mid2_btnDescripAtri1 = findViewById(R.id.itemcrit_mid2_atri1_button_descripcion);
        mid3_btnDescripAtri1 = findViewById(R.id.itemcrit_mid3_atri1_button_descripcion);
        ava1_btnDescripAtri1 = findViewById(R.id.itemcrit_ava1_atri1_button_descripcion);
        ava2_btnDescripAtri1 = findViewById(R.id.itemcrit_ava2_atri1_button_descripcion);
        ava3_btnDescripAtri1 = findViewById(R.id.itemcrit_ava3_atri1_button_descripcion);

        inc1_btnDescripAtri2 = findViewById(R.id.itemcrit_inc1_atri2_button_descripcion);
        inc2_btnDescripAtri2 = findViewById(R.id.itemcrit_inc2_atri2_button_descripcion);
        mid1_btnDescripAtri2 = findViewById(R.id.itemcrit_mid1_atri2_button_descripcion);
        mid2_btnDescripAtri2 = findViewById(R.id.itemcrit_mid2_atri2_button_descripcion);
        ava1_btnDescripAtri2 = findViewById(R.id.itemcrit_ava1_atri2_button_descripcion);
        ava2_btnDescripAtri2 = findViewById(R.id.itemcrit_ava2_atri2_button_descripcion);

        inc1_btnDescripAtri3 = findViewById(R.id.itemcrit_inc1_atri3_button_descripcion);
        inc2_btnDescripAtri3 = findViewById(R.id.itemcrit_inc2_atri3_button_descripcion);
        inc3_btnDescripAtri3 = findViewById(R.id.itemcrit_inc3_atri3_button_descripcion);
        mid1_btnDescripAtri3 = findViewById(R.id.itemcrit_mid1_atri3_button_descripcion);
        mid2_btnDescripAtri3 = findViewById(R.id.itemcrit_mid2_atri3_button_descripcion);
        mid3_btnDescripAtri3 = findViewById(R.id.itemcrit_mid3_atri3_button_descripcion);
        ava1_btnDescripAtri3 = findViewById(R.id.itemcrit_ava1_atri3_button_descripcion);
        ava2_btnDescripAtri3 = findViewById(R.id.itemcrit_ava2_atri3_button_descripcion);
        ava3_btnDescripAtri3 = findViewById(R.id.itemcrit_ava3_atri3_button_descripcion);

        inc1_btnDescripAtri4 = findViewById(R.id.itemcrit_inc1_atri4_button_descripcion);
        inc2_btnDescripAtri4 = findViewById(R.id.itemcrit_inc2_atri4_button_descripcion);
        inc3_btnDescripAtri4 = findViewById(R.id.itemcrit_inc3_atri4_button_descripcion);
        mid1_btnDescripAtri4 = findViewById(R.id.itemcrit_mid1_atri4_button_descripcion);
        mid2_btnDescripAtri4 = findViewById(R.id.itemcrit_mid2_atri4_button_descripcion);
        mid3_btnDescripAtri4 = findViewById(R.id.itemcrit_mid3_atri4_button_descripcion);
        ava1_btnDescripAtri4 = findViewById(R.id.itemcrit_ava1_atri4_button_descripcion);
        ava2_btnDescripAtri4 = findViewById(R.id.itemcrit_ava2_atri4_button_descripcion);
        ava3_btnDescripAtri4 = findViewById(R.id.itemcrit_ava3_atri4_button_descripcion);

        inc1_btnDescripAtri5 = findViewById(R.id.itemcrit_inc1_atri5_button_descripcion);
        inc2_btnDescripAtri5 = findViewById(R.id.itemcrit_inc2_atri5_button_descripcion);
        inc3_btnDescripAtri5 = findViewById(R.id.itemcrit_inc3_atri5_button_descripcion);
        mid1_btnDescripAtri5 = findViewById(R.id.itemcrit_mid1_atri5_button_descripcion);
        mid2_btnDescripAtri5 = findViewById(R.id.itemcrit_mid2_atri5_button_descripcion);
        mid3_btnDescripAtri5 = findViewById(R.id.itemcrit_mid3_atri5_button_descripcion);
        ava1_btnDescripAtri5 = findViewById(R.id.itemcrit_ava1_atri5_button_descripcion);
        ava2_btnDescripAtri5 = findViewById(R.id.itemcrit_ava2_atri5_button_descripcion);
        ava3_btnDescripAtri5 = findViewById(R.id.itemcrit_ava3_atri5_button_descripcion);

        inc1_txtCriterioAtri1 = findViewById(R.id.itemcrit_inc1_atri1_txt_criterioEspe);
        inc2_txtCriterioAtri1 = findViewById(R.id.itemcrit_inc2_atri1_txt_criterioEspe);
        inc3_txtCriterioAtri1 = findViewById(R.id.itemcrit_inc3_atri1_txt_criterioEspe);
        mid1_txtCriterioAtri1 = findViewById(R.id.itemcrit_mid1_atri1_txt_criterioEspe);
        mid2_txtCriterioAtri1 = findViewById(R.id.itemcrit_mid2_atri1_txt_criterioEspe);
        mid3_txtCriterioAtri1 = findViewById(R.id.itemcrit_mid3_atri1_txt_criterioEspe);
        ava1_txtCriterioAtri1 = findViewById(R.id.itemcrit_ava1_atri1_txt_criterioEspe);
        ava2_txtCriterioAtri1 = findViewById(R.id.itemcrit_ava2_atri1_txt_criterioEspe);
        ava3_txtCriterioAtri1 = findViewById(R.id.itemcrit_ava3_atri1_txt_criterioEspe);

        inc1_txtCriterioAtri2 = findViewById(R.id.itemcrit_inc1_atri2_txt_criterioEspe);
        inc2_txtCriterioAtri2 = findViewById(R.id.itemcrit_inc2_atri2_txt_criterioEspe);
        mid1_txtCriterioAtri2 = findViewById(R.id.itemcrit_mid1_atri2_txt_criterioEspe);
        mid2_txtCriterioAtri2 = findViewById(R.id.itemcrit_mid2_atri2_txt_criterioEspe);
        ava1_txtCriterioAtri2 = findViewById(R.id.itemcrit_ava1_atri2_txt_criterioEspe);
        ava2_txtCriterioAtri2 = findViewById(R.id.itemcrit_ava2_atri2_txt_criterioEspe);

        inc1_txtCriterioAtri3 = findViewById(R.id.itemcrit_inc1_atri3_txt_criterioEspe);
        inc2_txtCriterioAtri3 = findViewById(R.id.itemcrit_inc2_atri3_txt_criterioEspe);
        inc3_txtCriterioAtri3 = findViewById(R.id.itemcrit_inc3_atri3_txt_criterioEspe);
        mid1_txtCriterioAtri3 = findViewById(R.id.itemcrit_mid1_atri3_txt_criterioEspe);
        mid2_txtCriterioAtri3 = findViewById(R.id.itemcrit_mid2_atri3_txt_criterioEspe);
        mid3_txtCriterioAtri3 = findViewById(R.id.itemcrit_mid3_atri3_txt_criterioEspe);
        ava1_txtCriterioAtri3 = findViewById(R.id.itemcrit_ava1_atri3_txt_criterioEspe);
        ava2_txtCriterioAtri3 = findViewById(R.id.itemcrit_ava2_atri3_txt_criterioEspe);
        ava3_txtCriterioAtri3 = findViewById(R.id.itemcrit_ava3_atri3_txt_criterioEspe);

        inc1_txtCriterioAtri4 = findViewById(R.id.itemcrit_inc1_atri4_txt_criterioEspe);
        inc2_txtCriterioAtri4 = findViewById(R.id.itemcrit_inc2_atri4_txt_criterioEspe);
        inc3_txtCriterioAtri4 = findViewById(R.id.itemcrit_inc3_atri4_txt_criterioEspe);
        mid1_txtCriterioAtri4 = findViewById(R.id.itemcrit_mid1_atri4_txt_criterioEspe);
        mid2_txtCriterioAtri4 = findViewById(R.id.itemcrit_mid2_atri4_txt_criterioEspe);
        mid3_txtCriterioAtri4 = findViewById(R.id.itemcrit_mid3_atri4_txt_criterioEspe);
        ava1_txtCriterioAtri4 = findViewById(R.id.itemcrit_ava1_atri4_txt_criterioEspe);
        ava2_txtCriterioAtri4 = findViewById(R.id.itemcrit_ava2_atri4_txt_criterioEspe);
        ava3_txtCriterioAtri4 = findViewById(R.id.itemcrit_ava3_atri4_txt_criterioEspe);

        inc1_txtCriterioAtri5 = findViewById(R.id.itemcrit_inc1_atri5_txt_criterioEspe);
        inc2_txtCriterioAtri5 = findViewById(R.id.itemcrit_inc2_atri5_txt_criterioEspe);
        inc3_txtCriterioAtri5 = findViewById(R.id.itemcrit_inc3_atri5_txt_criterioEspe);
        mid1_txtCriterioAtri5 = findViewById(R.id.itemcrit_mid1_atri5_txt_criterioEspe);
        mid2_txtCriterioAtri5 = findViewById(R.id.itemcrit_mid2_atri5_txt_criterioEspe);
        mid3_txtCriterioAtri5 = findViewById(R.id.itemcrit_mid3_atri5_txt_criterioEspe);
        ava1_txtCriterioAtri5 = findViewById(R.id.itemcrit_ava1_atri5_txt_criterioEspe);
        ava2_txtCriterioAtri5 = findViewById(R.id.itemcrit_ava2_atri5_txt_criterioEspe);
        ava3_txtCriterioAtri5 = findViewById(R.id.itemcrit_ava3_atri5_txt_criterioEspe);

        inc1_txtPuntosAtri1 = findViewById(R.id.itemcrit_inc1_atri1_txt_puntos);
        inc2_txtPuntosAtri1 = findViewById(R.id.itemcrit_inc2_atri1_txt_puntos);
        inc3_txtPuntosAtri1 = findViewById(R.id.itemcrit_inc3_atri1_txt_puntos);
        mid1_txtPuntosAtri1 = findViewById(R.id.itemcrit_mid1_atri1_txt_puntos);
        mid2_txtPuntosAtri1 = findViewById(R.id.itemcrit_mid2_atri1_txt_puntos);
        mid3_txtPuntosAtri1 = findViewById(R.id.itemcrit_mid3_atri1_txt_puntos);
        ava1_txtPuntosAtri1 = findViewById(R.id.itemcrit_ava1_atri1_txt_puntos);
        ava2_txtPuntosAtri1 = findViewById(R.id.itemcrit_ava2_atri1_txt_puntos);
        ava3_txtPuntosAtri1 = findViewById(R.id.itemcrit_ava3_atri1_txt_puntos);

        inc1_txtPuntosAtri2 = findViewById(R.id.itemcrit_inc1_atri2_txt_puntos);
        inc2_txtPuntosAtri2 = findViewById(R.id.itemcrit_inc2_atri2_txt_puntos);
        mid1_txtPuntosAtri2 = findViewById(R.id.itemcrit_mid1_atri2_txt_puntos);
        mid2_txtPuntosAtri2 = findViewById(R.id.itemcrit_mid2_atri2_txt_puntos);
        ava1_txtPuntosAtri2 = findViewById(R.id.itemcrit_ava1_atri2_txt_puntos);
        ava2_txtPuntosAtri2 = findViewById(R.id.itemcrit_ava2_atri2_txt_puntos);

        inc1_txtPuntosAtri3 = findViewById(R.id.itemcrit_inc1_atri3_txt_puntos);
        inc2_txtPuntosAtri3 = findViewById(R.id.itemcrit_inc2_atri3_txt_puntos);
        inc3_txtPuntosAtri3 = findViewById(R.id.itemcrit_inc3_atri3_txt_puntos);
        mid1_txtPuntosAtri3 = findViewById(R.id.itemcrit_mid1_atri3_txt_puntos);
        mid2_txtPuntosAtri3 = findViewById(R.id.itemcrit_mid2_atri3_txt_puntos);
        mid3_txtPuntosAtri3 = findViewById(R.id.itemcrit_mid3_atri3_txt_puntos);
        ava1_txtPuntosAtri3 = findViewById(R.id.itemcrit_ava1_atri3_txt_puntos);
        ava2_txtPuntosAtri3 = findViewById(R.id.itemcrit_ava2_atri3_txt_puntos);
        ava3_txtPuntosAtri3 = findViewById(R.id.itemcrit_ava3_atri3_txt_puntos);

        inc1_txtPuntosAtri4 = findViewById(R.id.itemcrit_inc1_atri4_txt_puntos);
        inc2_txtPuntosAtri4 = findViewById(R.id.itemcrit_inc2_atri4_txt_puntos);
        inc3_txtPuntosAtri4 = findViewById(R.id.itemcrit_inc3_atri4_txt_puntos);
        mid1_txtPuntosAtri4 = findViewById(R.id.itemcrit_mid1_atri4_txt_puntos);
        mid2_txtPuntosAtri4 = findViewById(R.id.itemcrit_mid2_atri4_txt_puntos);
        mid3_txtPuntosAtri4 = findViewById(R.id.itemcrit_mid3_atri4_txt_puntos);
        ava1_txtPuntosAtri4 = findViewById(R.id.itemcrit_ava1_atri4_txt_puntos);
        ava2_txtPuntosAtri4 = findViewById(R.id.itemcrit_ava2_atri4_txt_puntos);
        ava3_txtPuntosAtri4 = findViewById(R.id.itemcrit_ava3_atri4_txt_puntos);

        inc1_txtPuntosAtri5 = findViewById(R.id.itemcrit_inc1_atri5_txt_puntos);
        inc2_txtPuntosAtri5 = findViewById(R.id.itemcrit_inc2_atri5_txt_puntos);
        inc3_txtPuntosAtri5 = findViewById(R.id.itemcrit_inc3_atri5_txt_puntos);
        mid1_txtPuntosAtri5 = findViewById(R.id.itemcrit_mid1_atri5_txt_puntos);
        mid2_txtPuntosAtri5 = findViewById(R.id.itemcrit_mid2_atri5_txt_puntos);
        mid3_txtPuntosAtri5 = findViewById(R.id.itemcrit_mid3_atri5_txt_puntos);
        ava1_txtPuntosAtri5 = findViewById(R.id.itemcrit_ava1_atri5_txt_puntos);
        ava2_txtPuntosAtri5 = findViewById(R.id.itemcrit_ava2_atri5_txt_puntos);
        ava3_txtPuntosAtri5 = findViewById(R.id.itemcrit_ava3_atri5_txt_puntos);

        inc1_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Integra elementos computacionales para dar solución a una problemática delimitada en un contexto.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc2_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Identifica y compara hardware, software, plataformas, dispositivos  y/o interfaces hombre máquina.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc3_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Reconoce las implicaciones  de sostenibilidad, de legalidad, de políticas o de contextos sociales.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid1_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Desarrolla aplicaciones computacionales  para dar solución a una problemática de un contexto definido. ");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid2_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Usa hardware, software, plataformas, dispositivos  y/o interfaces hombre máquina.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid3_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("La aplicación computacional consideró cuestiones de sostenibilidad o de legalidad, o de políticas o de contextos sociales.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava1_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Implementa aplicaciones computacionales creativas para dar solución a una problemática a un problema compleja.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava2_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Evalúa y estable los componentes de un sistema complejo, que requiere de conocimientos profundos de ingeniería.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava3_btnDescripAtri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("La aplicación computacional atiende alguno(s) de 17 objetivos del desarrollo sustentables  (ODS) declarados por la ONU.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc1_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Conoce los principios de modelos en su  contexto, mediante el uso de matemáticas y las ciencias ingenieriles.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc2_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Reproduce modelos con base en principios generalizados de la ingeniería.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        mid1_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Establece modelos computacionales  en la solución de problemas complejos de ingeniería.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid2_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Desarrolla modelos computacionales aplicables a problemas que tienen un contexto limitado.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        ava1_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Diseña modelos ingenieriles innovadores en la solución de problemas complejos, integrando herramientas matemáticas, de ingeniería y tecnología.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava2_btnDescripAtri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Implementa modelos computacionales a problemas complejos de acuerdo a estándares internacionales aplicables en contextos multidisciplinarios.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc1_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Es miembro de un equipo");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc2_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Se comunica de forma escrita siguiendo reglas ortográficas básicas");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc3_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Realiza un análisis usando los aprendido en la asignatura del problema de una organización");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid1_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Participa activamente en equipos inclusivos");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid2_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Se comunica de forma oral y escrita de forma correcta y efectiva(con coherencia, cohesión y adecuación)");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid3_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Gestiona actividades de un proyecto para la solución del problema de una organización o empresa");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava1_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Coordina o participa en equipos multidisciplinarios, inclusivos o remotos");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava2_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Se comunica de forma oral y escrita de forma correcta y efectiva en diferentes contextos");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava3_btnDescripAtri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Toma decisiones económicas en la gestión del proyecto con una visión empresarial");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc1_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Redacta un planteamiento del problema, objetivo general y objetivos específicos.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc2_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Selecciona fuentes confiables de la disciplina para redactar un escrito de los temas investigados");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc3_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Redacta un análisis de la información");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid1_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Utiliza una metodología para dar solución a la problemática planteada");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid2_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Redacta antecedentes y marco teorico fruto de la investigación de fuentes confiables y la síntesis de la información");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid3_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Elabora conclusiones basadas en la información investigada");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava1_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Investiga problemas de ingeniería complejos utilizando métodos de investigación");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava2_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Construye una documento técnico  fruto de la investigación de fuentes confiables y la síntesis de la información");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava3_btnDescripAtri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Construye conclusiones validadas en el análisis y la interpretación de datos recolectados.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc1_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Identifica contextos para desarrollarse en la vida profesional.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc2_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Identifica las actividades y funciones del ingeniero en sistemas computacionales.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        inc3_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Describe la importancia del cambio tecnológico en la profesión.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid1_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Practica el aprendizaje autónomo.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid2_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Desarrolla habilidades para ejercer algunas funciones o actividades del ingeniero en sistemas Computacionales");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        mid3_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Analiza los cambios tecnológicos de la ingeniería y la relación con el trabajo que presenta");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava1_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Está preparado para el aprendizaje autónomo.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava2_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Realiza funciones y pone en práctica las habilidades  que un ingeniero en sistemas computacionales desempeña en el ejercicio profesional.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ava3_btnDescripAtri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(view);

                AlertDialog dialog = builder.create();

                TextView title = view.findViewById(R.id.title);
                title.setText("Descripción");
                ImageView image = view.findViewById(R.id.imageDialog);
                image.setVisibility(View.GONE);
                TextView message = view.findViewById(R.id.message);
                message.setText("Construye una argumentación para defender su propuesta con base al cambio tecnológico de la tecnología empleada.");

                Button button = view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        Intent intent = getIntent();
        String atributo1 = intent.getStringExtra("atributo1");
        String atributo2 = intent.getStringExtra("atributo2");
        String atributo3 = intent.getStringExtra("atributo3");
        String atributo4 = intent.getStringExtra("atributo4");
        String atributo5 = intent.getStringExtra("atributo5");
        if (atributo1 != null) {
            txtNombreAtributo.setText(atributo1);
            btnAtributoDescripcion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsignarAtributo.this);
                    LayoutInflater inflater = AsignarAtributo.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    ImageView image = dialogView.findViewById(R.id.imageDialog);
                    image.setVisibility(View.GONE);

                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Descripción");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Implementa aplicaciones computacionales para solucionar problemas complejos de ingeniería " +
                            "en contextos de (WK1-4,9) ciencias sociales, ciencias naturales, matemáticas, fundamentos de la " +
                            "ingeniería y vanguardia de la disciplina, integrando hardware y software, plataformas o dispositivos " +
                            "implicando conocimiento (WP1) profundo de ingeniería dentro de una organización considerando (WP2) " +
                            "cuestiones éticas, sostenibles, legales, políticas y sociales.");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });

        }
        if (atributo2 != null) {
            txtNombreAtributo.setText(atributo2);
            btnAtributoDescripcion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsignarAtributo.this);
                    LayoutInflater inflater = AsignarAtributo.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    ImageView image = dialogView.findViewById(R.id.imageDialog);
                    image.setVisibility(View.GONE);

                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Descripción");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Diseña, desarrolla y aplica modelos computacionales (WA3, WP3 ) innovadores para " +
                            "solucionar problemas complejos de ingeniería en contextos multidisciplinarios, mediante la selección " +
                            "y uso de herramientas matemáticas, de (WK6) tecnologías y de Ingeniería.");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }
        if (atributo3!= null) {
            txtNombreAtributo.setText(atributo3);
            btnAtributoDescripcion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsignarAtributo.this);
                    LayoutInflater inflater = AsignarAtributo.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    ImageView image = dialogView.findViewById(R.id.imageDialog);
                    image.setVisibility(View.GONE);

                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Descripción");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Coordina y participa en equipos multidisciplinarios, inclusivos, presenciales o " +
                            "remotos para la aplicación de soluciones innovadoras mediante comunicación oral y escrita efectiva " +
                            "en diferentes contextos, para la toma de decisiones económicas en la gestión de proyectos con una " +
                            "visión empresarial");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }
        if (atributo4 != null) {
            txtNombreAtributo.setText(atributo4);
            btnAtributoDescripcion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsignarAtributo.this);
                    LayoutInflater inflater = AsignarAtributo.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    ImageView image = dialogView.findViewById(R.id.imageDialog);
                    image.setVisibility(View.GONE);

                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Descripción");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Investiga problemas de ingeniería complejos utilizando métodos de investigación, " +
                            "incluyendo el conocimiento basado en la investigación, el diseño de experimentos, " +
                            "el análisis y la interpretación de los datos, y la síntesis de la información para " +
                            "proporcionar conclusiones válidas.");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }
        if (atributo5 != null) {
            txtNombreAtributo.setText(atributo5);
            btnAtributoDescripcion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsignarAtributo.this);
                    LayoutInflater inflater = AsignarAtributo.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                    builder.setView(dialogView);
                    ImageView image = dialogView.findViewById(R.id.imageDialog);
                    image.setVisibility(View.GONE);


                    AlertDialog dialog = builder.create();
                    TextView title = dialogView.findViewById(R.id.title);
                    title.setText("Descripción");
                    TextView message = dialogView.findViewById(R.id.message);
                    message.setText("Reconoce y se prepara para un aprendizaje independiente, enfocándose a su " +
                            "vida profesional con el objetivo de adaptarse y consciente del impacto de " +
                            "los cambios tecnológico en la profesión.");
                    Button button = dialogView.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }

        spinner.setSelection(-1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                switch (selected) {
                    case"X":
                        txtEmpty.setVisibility(View.VISIBLE);
                        if (atributo1 != null) {
                            inc1Atri1.setVisibility(View.GONE);
                            inc2Atri1.setVisibility(View.GONE);
                            inc3Atri1.setVisibility(View.GONE);
                            mid1Atri1.setVisibility(View.GONE);
                            mid2Atri1.setVisibility(View.GONE);
                            mid3Atri1.setVisibility(View.GONE);
                            ava1Atri1.setVisibility(View.GONE);
                            ava2Atri1.setVisibility(View.GONE);
                            ava3Atri1.setVisibility(View.GONE);
                        }
                        if (atributo2 != null) {
                            inc1Atri2.setVisibility(View.GONE);
                            inc2Atri2.setVisibility(View.GONE);
                            mid1Atri2.setVisibility(View.GONE);
                            mid2Atri2.setVisibility(View.GONE);
                            ava1Atri2.setVisibility(View.GONE);
                            ava2Atri2.setVisibility(View.GONE);
                        }
                        if (atributo3 != null) {
                            inc1Atri3.setVisibility(View.GONE);
                            inc2Atri3.setVisibility(View.GONE);
                            inc3Atri3.setVisibility(View.GONE);
                            mid1Atri3.setVisibility(View.GONE);
                            mid2Atri3.setVisibility(View.GONE);
                            mid3Atri3.setVisibility(View.GONE);
                            ava1Atri3.setVisibility(View.GONE);
                            ava2Atri3.setVisibility(View.GONE);
                            ava3Atri3.setVisibility(View.GONE);
                        }
                        if (atributo4 != null) {
                            inc1Atri4.setVisibility(View.GONE);
                            inc2Atri4.setVisibility(View.GONE);
                            inc3Atri4.setVisibility(View.GONE);
                            mid1Atri4.setVisibility(View.GONE);
                            mid2Atri4.setVisibility(View.GONE);
                            mid3Atri4.setVisibility(View.GONE);
                            ava1Atri4.setVisibility(View.GONE);
                            ava2Atri4.setVisibility(View.GONE);
                            ava3Atri4.setVisibility(View.GONE);
                        }
                        if (atributo5 != null) {
                            inc1Atri5.setVisibility(View.GONE);
                            inc2Atri5.setVisibility(View.GONE);
                            inc3Atri5.setVisibility(View.GONE);
                            mid1Atri5.setVisibility(View.GONE);
                            mid2Atri5.setVisibility(View.GONE);
                            mid3Atri5.setVisibility(View.GONE);
                            ava1Atri5.setVisibility(View.GONE);
                            ava2Atri5.setVisibility(View.GONE);
                            ava3Atri5.setVisibility(View.GONE);
                        }
                        break;
                    case "I":
                        txtEmpty.setVisibility(View.GONE);
                        if (atributo1 != null) {
                            inc1Atri1.setVisibility(View.VISIBLE);
                            inc2Atri1.setVisibility(View.VISIBLE);
                            inc3Atri1.setVisibility(View.VISIBLE);
                            mid1Atri1.setVisibility(View.GONE);
                            mid2Atri1.setVisibility(View.GONE);
                            mid3Atri1.setVisibility(View.GONE);
                            ava1Atri1.setVisibility(View.GONE);
                            ava2Atri1.setVisibility(View.GONE);
                            ava3Atri1.setVisibility(View.GONE);
                        }
                        if (atributo2 != null) {
                            inc1Atri2.setVisibility(View.VISIBLE);
                            inc2Atri2.setVisibility(View.VISIBLE);
                            mid1Atri2.setVisibility(View.GONE);
                            mid2Atri2.setVisibility(View.GONE);
                            ava1Atri2.setVisibility(View.GONE);
                            ava2Atri2.setVisibility(View.GONE);
                        }
                        if (atributo3 != null) {
                            inc1Atri3.setVisibility(View.VISIBLE);
                            inc2Atri3.setVisibility(View.VISIBLE);
                            inc3Atri3.setVisibility(View.VISIBLE);
                            mid1Atri3.setVisibility(View.GONE);
                            mid2Atri3.setVisibility(View.GONE);
                            mid3Atri3.setVisibility(View.GONE);
                            ava1Atri3.setVisibility(View.GONE);
                            ava2Atri3.setVisibility(View.GONE);
                            ava3Atri3.setVisibility(View.GONE);
                        }
                        if (atributo4 != null) {
                            inc1Atri4.setVisibility(View.VISIBLE);
                            inc2Atri4.setVisibility(View.VISIBLE);
                            inc3Atri4.setVisibility(View.VISIBLE);
                            mid1Atri4.setVisibility(View.GONE);
                            mid2Atri4.setVisibility(View.GONE);
                            mid3Atri4.setVisibility(View.GONE);
                            ava1Atri4.setVisibility(View.GONE);
                            ava2Atri4.setVisibility(View.GONE);
                            ava3Atri4.setVisibility(View.GONE);
                        }
                        if (atributo5 != null) {
                            inc1Atri5.setVisibility(View.VISIBLE);
                            inc2Atri5.setVisibility(View.VISIBLE);
                            inc3Atri5.setVisibility(View.VISIBLE);
                            mid1Atri5.setVisibility(View.GONE);
                            mid2Atri5.setVisibility(View.GONE);
                            mid3Atri5.setVisibility(View.GONE);
                            ava1Atri5.setVisibility(View.GONE);
                            ava2Atri5.setVisibility(View.GONE);
                            ava3Atri5.setVisibility(View.GONE);
                        }
                        break;
                    case "M":
                        txtEmpty.setVisibility(View.GONE);
                        if (atributo1 != null) {
                            inc1Atri1.setVisibility(View.GONE);
                            inc2Atri1.setVisibility(View.GONE);
                            inc3Atri1.setVisibility(View.GONE);
                            mid1Atri1.setVisibility(View.VISIBLE);
                            mid2Atri1.setVisibility(View.VISIBLE);
                            mid3Atri1.setVisibility(View.VISIBLE);
                            ava1Atri1.setVisibility(View.GONE);
                            ava2Atri1.setVisibility(View.GONE);
                            ava3Atri1.setVisibility(View.GONE);
                        }
                        if (atributo2 != null) {
                            inc1Atri2.setVisibility(View.GONE);
                            inc2Atri2.setVisibility(View.GONE);
                            mid1Atri2.setVisibility(View.VISIBLE);
                            mid2Atri2.setVisibility(View.VISIBLE);
                            ava1Atri2.setVisibility(View.GONE);
                            ava2Atri2.setVisibility(View.GONE);
                        }
                        if (atributo3 != null) {
                            inc1Atri3.setVisibility(View.GONE);
                            inc2Atri3.setVisibility(View.GONE);
                            inc3Atri3.setVisibility(View.GONE);
                            mid1Atri3.setVisibility(View.VISIBLE);
                            mid2Atri3.setVisibility(View.VISIBLE);
                            mid3Atri3.setVisibility(View.VISIBLE);
                            ava1Atri3.setVisibility(View.GONE);
                            ava2Atri3.setVisibility(View.GONE);
                            ava3Atri3.setVisibility(View.GONE);
                        }
                        if (atributo4 != null) {
                            inc1Atri4.setVisibility(View.GONE);
                            inc2Atri4.setVisibility(View.GONE);
                            inc3Atri4.setVisibility(View.GONE);
                            mid1Atri4.setVisibility(View.VISIBLE);
                            mid2Atri4.setVisibility(View.VISIBLE);
                            mid3Atri4.setVisibility(View.VISIBLE);
                            ava1Atri4.setVisibility(View.GONE);
                            ava2Atri4.setVisibility(View.GONE);
                            ava3Atri4.setVisibility(View.GONE);
                        }
                        if (atributo5 != null) {
                            inc1Atri5.setVisibility(View.GONE);
                            inc2Atri5.setVisibility(View.GONE);
                            inc3Atri5.setVisibility(View.GONE);
                            mid1Atri5.setVisibility(View.VISIBLE);
                            mid2Atri5.setVisibility(View.VISIBLE);
                            mid3Atri5.setVisibility(View.VISIBLE);
                            ava1Atri5.setVisibility(View.GONE);
                            ava2Atri5.setVisibility(View.GONE);
                            ava3Atri5.setVisibility(View.GONE);
                        }
                        break;
                    case "A":
                        txtEmpty.setVisibility(View.GONE);
                        if (atributo1 != null) {
                            inc1Atri1.setVisibility(View.GONE);
                            inc2Atri1.setVisibility(View.GONE);
                            inc3Atri1.setVisibility(View.GONE);
                            mid1Atri1.setVisibility(View.GONE);
                            mid2Atri1.setVisibility(View.GONE);
                            mid3Atri1.setVisibility(View.GONE);
                            ava1Atri1.setVisibility(View.VISIBLE);
                            ava2Atri1.setVisibility(View.VISIBLE);
                            ava3Atri1.setVisibility(View.VISIBLE);
                        }
                        if (atributo2 != null) {
                            inc1Atri2.setVisibility(View.GONE);
                            inc2Atri2.setVisibility(View.GONE);
                            mid1Atri2.setVisibility(View.GONE);
                            mid2Atri2.setVisibility(View.GONE);
                            ava1Atri2.setVisibility(View.VISIBLE);
                            ava2Atri2.setVisibility(View.VISIBLE);
                        }
                        if (atributo3 != null) {
                            inc1Atri3.setVisibility(View.GONE);
                            inc2Atri3.setVisibility(View.GONE);
                            inc3Atri3.setVisibility(View.GONE);
                            mid1Atri3.setVisibility(View.GONE);
                            mid2Atri3.setVisibility(View.GONE);
                            mid3Atri3.setVisibility(View.GONE);
                            ava1Atri3.setVisibility(View.VISIBLE);
                            ava2Atri3.setVisibility(View.VISIBLE);
                            ava3Atri3.setVisibility(View.VISIBLE);
                        }
                        if (atributo4 != null) {
                            inc1Atri4.setVisibility(View.GONE);
                            inc2Atri4.setVisibility(View.GONE);
                            inc3Atri4.setVisibility(View.GONE);
                            mid1Atri4.setVisibility(View.GONE);
                            mid2Atri4.setVisibility(View.GONE);
                            mid3Atri4.setVisibility(View.GONE);
                            ava1Atri4.setVisibility(View.VISIBLE);
                            ava2Atri4.setVisibility(View.VISIBLE);
                            ava3Atri4.setVisibility(View.VISIBLE);
                        }
                        if (atributo5 != null) {
                            inc1Atri5.setVisibility(View.GONE);
                            inc2Atri5.setVisibility(View.GONE);
                            inc3Atri5.setVisibility(View.GONE);
                            mid1Atri5.setVisibility(View.GONE);
                            mid2Atri5.setVisibility(View.GONE);
                            mid3Atri5.setVisibility(View.GONE);
                            ava1Atri5.setVisibility(View.VISIBLE);
                            ava2Atri5.setVisibility(View.VISIBLE);
                            ava3Atri5.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Aquí puedes manejar el caso en que no se selecciona nada en el Spinner
            }
        });



    }
}

