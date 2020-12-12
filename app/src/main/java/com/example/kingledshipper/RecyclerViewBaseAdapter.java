package com.example.kingledshipper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.ViewHolder> {

    private List<RecyclerViewBeans> list_116;
    private LayoutInflater inflater_116;
    private ItemClickListener itemClickListener_116;


    public RecyclerViewBaseAdapter(Activity context_116, List<RecyclerViewBeans> lists_116) {
        this.inflater_116 = LayoutInflater.from(context_116);
        this.list_116 = lists_116;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_116 = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_recycler_view,parent,false);
        return new ViewHolder(view_116);
    }
    @Override
    // binds the data to the view and textview in each row
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewBeans recyclerViewBean_116 = list_116.get(position);
        holder.myView_116.setImageResource(recyclerViewBean_116.getImage());
        holder.myTextView_116.setText(recyclerViewBean_116.getTensanpham());
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return list_116.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myView_116;
        TextView myTextView_116;
        ViewHolder(View itemView) {
            super(itemView);
            myView_116 =(ImageView)itemView.findViewById(R.id.image_recycler);
            myTextView_116 = (TextView)itemView.findViewById(R.id.tv_recyclerview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener_116 != null) itemClickListener_116.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return null;
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener_116 = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
