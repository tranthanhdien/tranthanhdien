package com.recognize.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.recognize.finalproject.R;
import com.recognize.finalproject.model.Model;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<
        RecyclerAdapter.RecyclerViewHolder> {

    private int selectedStarPosition = -1;
    private List<Model> models;
    private Context c;
    private AdapterView.OnItemClickListener onItemClickListener;

    public RecyclerAdapter(Context context, List<Model> models) {
        this.c = context;
        this.models = models;
    }

    /**
     * OnCreateViewHolder - here is where we inflate our model layout
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(c).inflate(R.layout.row, viewGroup, false);
        return new RecyclerViewHolder(v, this);
    }

    /**
     * OnBindViewHolder - Here's where we bind our data
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, final int position) {
        Model model = models.get(position);
        try {
            viewHolder.bindData(model, position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    /**
     * Let's receive our onItemClickListener and assign it to our local one.
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(AdapterView.OnItemClickListener
                                               onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * When user clicks our itemView, we still invoke the onItemClick
     *
     * @param holder
     */
    public void onItemHolderClick(RecyclerViewHolder holder) {
        if (onItemClickListener != null)
            onItemClickListener.onItemClick(null, holder.itemView,
                    holder.getAdapterPosition(), holder.getItemId());
    }

    /**
     * Let's come create our ViewHolder class.
     */
    class RecyclerViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        private RecyclerAdapter mAdapter;
        private ImageView imageView;
        private TextView txtTitle, txtDescription;
        private CheckBox checkbox;

        public RecyclerViewHolder(View itemView, final RecyclerAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            checkbox = itemView.findViewById(R.id.checkbox);
            imageView = itemView.findViewById(R.id.imgViewHistory);
            itemView.setOnClickListener(this);
            checkbox.setOnClickListener(this);
        }

        public void bindData(Model model, int position) {
            checkbox.setChecked(position == selectedStarPosition);
            txtTitle.setText(model.getTitle());
            txtDescription.setText(model.getDescription());
            imageView.setImageResource(model.getImg());
        }

        /**
         * Let's override our OnClick method.
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            selectedStarPosition = getAdapterPosition();
            notifyItemRangeChanged(0, models.size());
            mAdapter.onItemHolderClick(RecyclerViewHolder.this);
        }
    }
}