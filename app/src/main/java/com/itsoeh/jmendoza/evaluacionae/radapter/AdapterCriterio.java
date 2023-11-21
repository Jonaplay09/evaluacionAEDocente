package com.itsoeh.jmendoza.evaluacionae.radapter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.itsoeh.jmendoza.evaluacionae.CambiarNombre;
import com.itsoeh.jmendoza.evaluacionae.EstudianteSelection;
import com.itsoeh.jmendoza.evaluacionae.R;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAtributo;
import com.itsoeh.jmendoza.evaluacionae.models.MCriterio;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;


import java.util.ArrayList;

public class AdapterCriterio extends RecyclerView.Adapter<AdapterCriterio.ViewHolderCriterio> {
    private ArrayList<MCriterio> lista;
    private TextView emptyView;
    public AdapterCriterio(ArrayList<MCriterio> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderCriterio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_criterios,parent,false);
        return new ViewHolderCriterio(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCriterio.ViewHolderCriterio holder, int position) {
        holder.setDatos(lista.get(position));
    }



    public void updateData(ArrayList<MCriterio> newList) {
        this.lista = newList;

        if (lista.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void filtro(ArrayList<MCriterio> filtro) {
        this.lista=filtro;
        notifyDataSetChanged();
    }

    public class ViewHolderCriterio extends RecyclerView.ViewHolder {
        private TextView txtCriterio, txtPuntos;
        private ImageView imvGenero;
        private CardView crvCont;
        private Button btnDescripcion;
        private Bitmap userm, userw;
        private ImageView imgVer, imgEditar;
        private LinearLayout itemClick;
        private MCriterio m;
        public ViewHolderCriterio(@NonNull View itemView) {
            super(itemView);
            emptyView = itemView.findViewById(R.id.tv_empty);
            txtCriterio=itemView.findViewById(R.id.itemcrit_txt_nombre);
            txtPuntos=itemView.findViewById(R.id.itemcrit_txt_puntos);
            btnDescripcion = itemView.findViewById(R.id.btn_itmcrit_seleccionar);
        }



        private void clicVer() {
            AlertDialog.Builder aviso=new AlertDialog.Builder(itemView.getContext());
            aviso.setTitle("Dato consultado")
                    .setMessage(this.m.toString())
                    .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }
        public void setDatos(MCriterio m) {
            this.m=m;
            if(m!=null){
                // txtAtributo.setText(m.get());
                //txtPuntos.setText(m.getClaveGrupo());
            }
        }
    }


}
