package com.pollarusia2018.pollaupb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by andresvasquez on 11/24/17.
 */

public class AmigoAdapter extends RecyclerView.Adapter<AmigoViewHolder>{

    private Context context;
    private List<Amigo> lstAmigos;

    public AmigoAdapter(Context context, List<Amigo> lstAmigos) {
        this.context = context;
        this.lstAmigos = lstAmigos;
    }

    @Override
    public AmigoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_amigo,null);
        return new AmigoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AmigoViewHolder holder, int position) {
        final Amigo amigo = lstAmigos.get(position);
        holder.profilePictureImageView.setImageResource(amigo.getProfilePicture());
        holder.nameTextView.setText(amigo.getName());
    }

    @Override
    public int getItemCount() {
        return lstAmigos.size();
    }
}
