package com.example.bottombarfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HolderData> {

    List<Item> listData;
    LayoutInflater inflater;

    private ItemClickListener itemClickListener;


    public MyAdapter(Context context, List<Item> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);

    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new HolderData(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.HolderData holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listData.get(position).getImg()) // Use the resource ID
                .error(R.drawable.profile)
                .placeholder(R.drawable.profile)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;


        ItemClickListener itemClickListener;

        public HolderData(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;


            img = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
