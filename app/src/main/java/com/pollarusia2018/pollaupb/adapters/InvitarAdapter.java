package com.pollarusia2018.pollaupb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pollarusia2018.pollaupb.R;
import com.pollarusia2018.pollaupb.models.Contacto;

import java.util.ArrayList;

/**
 * Created by Adrian on 12/8/2017.
 */

public class InvitarAdapter extends RecyclerView.Adapter<InvitarAdapter.ViewHolder> {
    private ArrayList<Contacto> datos;
    private Context context;

    public InvitarAdapter(Context context) {
        datos = new ArrayList<Contacto>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invitar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contacto c = datos.get(position);
        holder.nombreTextView.setText(c.getNombre());
        holder.numeroTextView.setText(c.getNumero());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void colocarDatos(ArrayList<Contacto> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }

    public void addContact(Contacto c) {
        datos.add(c);
        notifyDataSetChanged();
    }

    public void clear() {
        datos.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreTextView;
        TextView numeroTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            numeroTextView = itemView.findViewById(R.id.numeroTextView);
        }
    }
}
