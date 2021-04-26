package com.example.hack4_0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {

    ArrayList<Model> mlist;
    Context context;

    public  MyAdapter2(Context context,ArrayList<Model> mlist)
    {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return  new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Model model = mlist.get(position);
        holder.name.setText(model.getName());
        holder.time.setText(model.getTime());
        holder.contact.setText(model.getContact());
        holder.date.setText(model.getDate());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView name,time,contact,date;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.flag_name);
            time = itemView.findViewById(R.id.time_dispatch);
            contact = itemView.findViewById(R.id.contact_no);
            date = itemView.findViewById(R.id.date);
        }
    }
}
