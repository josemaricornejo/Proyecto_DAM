package com.example.fooderful.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooderful.R;
import com.example.fooderful.utils.Alimento;

import java.util.ArrayList;

public class AdapterAlimentos extends RecyclerView.Adapter<AdapterAlimentos.ViewHolderAlimentos> {

    ArrayList<Alimento> listaAlimentos;

    public AdapterAlimentos(ArrayList<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    @NonNull
    @Override
    public ViewHolderAlimentos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolderAlimentos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlimentos holder, int position) {
        holder.imagen.setImageResource(listaAlimentos.get(position).getImagenId());
        holder.nombre.setText(listaAlimentos.get(position).getNombre());
        holder.cantidad.setText(listaAlimentos.get(position).getCantidad());
        holder.dias.setText(listaAlimentos.get(position).getDias());

    }

    @Override
    public int getItemCount() {
        return listaAlimentos.size();
    }

    public class ViewHolderAlimentos extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre, cantidad, dias;

        public ViewHolderAlimentos(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.idImagen);
            nombre = itemView.findViewById(R.id.nombre_alimento);
            cantidad = itemView.findViewById(R.id.cantidad_alimento);
            dias = itemView.findViewById(R.id.caduca_alimento);
        }

    }
}
