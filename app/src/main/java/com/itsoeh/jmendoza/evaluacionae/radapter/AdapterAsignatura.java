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
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;


import java.util.ArrayList;

public class AdapterAsignatura extends RecyclerView.Adapter<AdapterAsignatura.ViewHolderAsignatura> {
    private ArrayList<MAsignatura> lista;
    private TextView emptyView;
    public AdapterAsignatura(ArrayList<MAsignatura> lista, TextView emptyView) {
        this.lista = lista;
        this.emptyView = emptyView;
    }

    @NonNull
    @Override
    public ViewHolderAsignatura onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_asignatura,parent,false);
        return new ViewHolderAsignatura(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAsignatura.ViewHolderAsignatura holder, int position) {
        holder.setDatos(lista.get(position));
        holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                holder.clicItem();
            }
        });
    }



    public void updateData(ArrayList<MAsignatura> newList) {
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

    public void filtro(ArrayList<MAsignatura> filtro) {
        this.lista=filtro;
        notifyDataSetChanged();
    }

    public class ViewHolderAsignatura extends RecyclerView.ViewHolder {
        private TextView txtAsignatura, txtCreditos, txtDocente;
        private ImageView imvGenero;
        private CardView crvCont;
        private Bitmap userm, userw;
        private ImageView imgVer, imgEditar;
        private LinearLayout itemClick;
        private MAsignatura m;
        public ViewHolderAsignatura(@NonNull View itemView) {
            super(itemView);
            imgVer=itemView.findViewById(R.id.itemasig_img_asig);
            emptyView = itemView.findViewById(R.id.tv_empty);
            txtAsignatura=itemView.findViewById(R.id.itemasig_txt_nombre);
            txtCreditos=itemView.findViewById(R.id.itemasig_txt_clavegru);
            itemClick= itemView.findViewById(R.id.itemasig_item_click);
            itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clicItem();
                }
            });

            /* imgVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicVer();
                }
            });

             */

        }

      //  private void clicItem() {
        //    Context context = itemView.getContext();
          //  Intent intent = new Intent(context, EstudianteSelection.class);
            //context.startActivity(intent);
        //}
        private void clicItem() {
            Context context = itemView.getContext();
            Intent intent = new Intent(context, EstudianteSelection.class);
            // Agrega los datos al Intent
            intent.putExtra("asignatura", m.getAsignatura());
            intent.putExtra("claveAsignatura", m.getClaveAsignatura());
            intent.putExtra("claveGrupo", m.getClaveGrupo());
            intent.putExtra("codigoAsignatura", m.getCodigoAsignatura());
            context.startActivity(intent);
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

        public void setDatos(MAsignatura m) {
            this.m=m;
            if(m!=null){
                txtAsignatura.setText(m.getAsignatura());
                txtCreditos.setText(m.getClaveGrupo());
            }
        }
    }


}
