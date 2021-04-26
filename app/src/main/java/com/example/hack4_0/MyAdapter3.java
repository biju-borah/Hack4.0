package com.example.hack4_0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder3> {

    ArrayList<Model_plasma> mlist;
    Context context;

    public  MyAdapter3(Context context,ArrayList<Model_plasma> mlist)
    {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
        return  new MyViewHolder3(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int position) {
        Model_plasma model = mlist.get(position);
        holder.name.setText(model.getName());
        holder.bood.setText(model.getBlood());
        holder.contact.setText(model.getContact());
        holder.address.setText(model.getAddress());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder{

        TextView name,contact,bood,address;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.d_name);
            bood = itemView.findViewById(R.id.blood);
            contact = itemView.findViewById(R.id.d_contact_no);
            address = itemView.findViewById(R.id.d_address);
        }
    }
}