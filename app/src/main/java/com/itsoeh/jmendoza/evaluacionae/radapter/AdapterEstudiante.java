package com.itsoeh.jmendoza.evaluacionae.radapter;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.itsoeh.jmendoza.evaluacionae.AtributosEgreso;
import com.itsoeh.jmendoza.evaluacionae.EstudianteSelection;
import com.itsoeh.jmendoza.evaluacionae.R;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.Api;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.VolleySingleton;
import com.itsoeh.jmendoza.evaluacionae.models.MEstudiante;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterEstudiante extends RecyclerView.Adapter<AdapterEstudiante.ViewHolderEstudiante> {
    private ArrayList<MEstudiante> lista;

    public AdapterEstudiante(ArrayList<MEstudiante> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderEstudiante onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alumnos, parent, false);
        return new ViewHolderEstudiante(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEstudiante holder, int position) {
        holder.setDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderEstudiante extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private Button btnSelect;
        private MEstudiante m;

        public ViewHolderEstudiante(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.item_alumno_nombre);
            btnSelect = itemView.findViewById(R.id.btn_itmEst_seleccionar);
            btnSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    EstudianteSelection estudianteSelection = new EstudianteSelection();
                    estudianteSelection.brincarConDatos(m.getIdEstudiante(), context);
                }
            });

        }

        public void setDatos(MEstudiante m) {
            this.m = m;
            txtNombre.setText(m.getNombre()+" "+m.getApellido());
        }
    }
}
