package com.pollarusia2018.pollaupb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pollarusia2018.pollaupb.R;
import com.pollarusia2018.pollaupb.models.Contacto;
import com.pollarusia2018.pollaupb.models.OnContactClickListener;

import java.util.ArrayList;

/**
 * Created by Adrian on 12/8/2017.
 */

public class InvitarAdapter extends RecyclerView.Adapter<InvitarAdapter.ViewHolder> {
    private ArrayList<Contacto> datos;
    private Context context;

    private OnContactClickListener onContactClickListener;

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
        final Contacto c = datos.get(position);
        holder.nombreTextView.setText(c.getNombre());
        holder.numeroTextView.setText(c.getNumero());
        holder.contactoLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onContactClickListener!=null){
                    onContactClickListener.onContactClick(c);
                }
            }
        });
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

    public void setOnContactClickListener(OnContactClickListener onContactClickListener) {
        this.onContactClickListener = onContactClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout contactoLinearLayout;
        TextView nombreTextView;
        TextView numeroTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            contactoLinearLayout = itemView.findViewById(R.id.contactoLinearLayout);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            numeroTextView = itemView.findViewById(R.id.numeroTextView);
        }
    }
}
