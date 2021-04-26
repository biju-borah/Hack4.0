package com.example.hack4_0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Molel_hospital> mlist;
    Context context;

    public  MyAdapter(Context context,ArrayList<Molel_hospital> mlist)
    {
        this.mlist = mlist;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return  new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Molel_hospital molel_hospital = mlist.get(position);
        holder.name.setText(molel_hospital.getName());
        holder.beds.setText(molel_hospital.getBed());
        holder.distance.setText(molel_hospital.getDistance());
        holder.address.setText(molel_hospital.getAddress());
    }

    @Override
    public int getItemCount(){
        return  mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,beds,distance,address;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.hospital_name);
            beds = itemView.findViewById(R.id.beds_no);
            distance = itemView.findViewById(R.id.distance);
            address = itemView.findViewById(R.id.Location);
        }
    }
}
