package com.recognize.finalproject.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recognize.finalproject.R;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageView;
    TextView txtTitle, txtDescription;
    CheckBox checkbox;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        // ánh xạ bên row qua
        this.imageView = itemView.findViewById(R.id.imgViewHistory);
        this.txtTitle = itemView.findViewById(R.id.txtTitle);
        this.txtDescription = itemView.findViewById(R.id.txtDescription);
        checkbox = itemView.findViewById(R.id.checkbox);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent()
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
