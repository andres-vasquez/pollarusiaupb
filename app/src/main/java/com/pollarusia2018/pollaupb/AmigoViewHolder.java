package com.pollarusia2018.pollaupb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by andresvasquez on 11/24/17.
 */

public class AmigoViewHolder extends RecyclerView.ViewHolder{

    ImageView profilePictureImageView;
    TextView nameTextView;


    public AmigoViewHolder(View itemView) {
        super(itemView);
        profilePictureImageView = itemView.findViewById(R.id.profilePictureImageView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
    }
}
