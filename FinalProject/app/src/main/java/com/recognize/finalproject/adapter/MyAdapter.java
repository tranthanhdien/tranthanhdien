package com.recognize.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recognize.finalproject.R;
import com.recognize.finalproject.model.Model;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    int selectedStartPosition = -1;
    Context context;
    ArrayList<Model> models;

    public MyAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(models.get(position).getImg());
        holder.txtTitle.setText(models.get(position).getTitle());
        holder.txtDescription.setText(models.get(position).getDescription());
        if (!models.get(position).isChecked()) {

        } else {

        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
