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

import com.itsoeh.jmendoza.evaluacionae.AsignarAtributo;
import com.itsoeh.jmendoza.evaluacionae.CambiarNombre;
import com.itsoeh.jmendoza.evaluacionae.EstudianteSelection;
import com.itsoeh.jmendoza.evaluacionae.R;
import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MAtributo;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;


import java.util.ArrayList;

public class AdapterAtributo extends RecyclerView.Adapter<AdapterAtributo.ViewHolderAtributo> {
    private ArrayList<MAtributo> lista;
    private TextView emptyView;
    public AdapterAtributo(ArrayList<MAtributo> lista, TextView emptyView) {
        this.lista = lista;
        this.emptyView = emptyView;
    }

    @NonNull
    @Override
    public ViewHolderAtributo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_atributo,parent,false);
        return new ViewHolderAtributo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAtributo.ViewHolderAtributo holder, int position) {
        holder.setDatos(lista.get(position));
        /*holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                holder.clicItem();
            }
        });

         */
    }



    public void updateData(ArrayList<MAtributo> newList) {
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

    public void filtro(ArrayList<MAtributo> filtro) {
        this.lista=filtro;
        notifyDataSetChanged();
    }

    public class ViewHolderAtributo extends RecyclerView.ViewHolder {
        private TextView txtAtributo, txtPuntos, txtDocente;
        private ImageView imvGenero;
        private CardView crvCont;
        private Bitmap userm, userw;
        private ImageView imgVer, imgEditar;
        private LinearLayout itemClick;
        private MAtributo m;
        public ViewHolderAtributo(@NonNull View itemView) {
            super(itemView);
            emptyView = itemView.findViewById(R.id.tv_empty);
            txtAtributo=itemView.findViewById(R.id.itematrib_txt_nombre);
            txtPuntos=itemView.findViewById(R.id.itematrib_txt_puntos);
            //itemClick= itemView.findViewById(R.id.itemasig_item_click);


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
            Intent intent = new Intent(context, AsignarAtributo.class);
            // Agrega los datos al Intent
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

        public void setDatos(MAtributo m) {
            this.m=m;
            if(m!=null){
               // txtAtributo.setText(m.get());
                //txtPuntos.setText(m.getClaveGrupo());
            }
        }
    }


}
