package com.samyotech.machinetest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.machinetest.R;
import com.samyotech.machinetest.model.Homemodel;

import java.util.List;

public class Homeadaper extends RecyclerView.Adapter<Homeadaper.ViewHolder>  {
    Context context;
    List<Homemodel.RecentlyAddedProperty> homemodelList;

    public Homeadaper(List<Homemodel.RecentlyAddedProperty> homemodelList) {
        this.context = context;
        this.homemodelList = homemodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeitem,parent,false);
        return new Homeadaper.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Homemodel.RecentlyAddedProperty data = homemodelList.get(position);
        String title = data.getTitle();
        String description = data.getDescription();
        String anount = data.getAmount();
        String type = data.getType();
        Log.d("ammount","----------"+anount);

        holder.textview_home.setText(title);
        holder.textview_decription.setText(description);
        holder.tv_price.setText(anount);
        holder.tv_guest.setText(type);

    }

    @Override
    public int getItemCount() {
        return homemodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview_home,textview_decription,tv_price,tv_guest;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textview_home = itemView.findViewById(R.id.textview_home);
            textview_decription = itemView.findViewById(R.id.textview_decription);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_guest = itemView.findViewById(R.id.tv_guest);

        }
    }
}
