package com.pollarusia2018.pollaupb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pollarusia2018.pollaupb.R;
import com.pollarusia2018.pollaupb.models.Country;
import com.pollarusia2018.pollaupb.models.Partido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 12/4/2017.
 */

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.ViewHolder> {

    private ArrayList<Partido> datos;
    private Context context;

    public PartidosAdapter(Context context) {
        datos = new ArrayList<Partido>();
        this.context = context;
    }

    @Override
    public PartidosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partido, parent, false);
        return new PartidosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PartidosAdapter.ViewHolder holder, int position) {
        Partido p = datos.get(position);
        holder.equipo1TextView.setText(p.getEquipo1().getName());
        Glide.with(context).load(p.getEquipo1().getFlagURL()).into(holder.bandera1ImageView);

        holder.equipo2TextView.setText(p.getEquipo2().getName());
        Glide.with(context).load(p.getEquipo2().getFlagURL()).into(holder.bandera2ImageView);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void colocarDatos(ArrayList<Partido> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }

    public void addPartido(Partido p) {
        datos.add(p);
        notifyDataSetChanged();
    }

    public void clear() {
        datos.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bandera1ImageView;
        ImageView bandera2ImageView;
        TextView equipo1TextView;
        TextView equipo2TextView;

        public ViewHolder(View itemView) {
            super(itemView);

            equipo1TextView = itemView.findViewById(R.id.equipo1TextView);
            equipo2TextView = itemView.findViewById(R.id.equipo2TextView);
            bandera1ImageView = itemView.findViewById(R.id.bandera1ImageView);
            bandera2ImageView = itemView.findViewById(R.id.bandera2ImageView);
        }
    }


}
