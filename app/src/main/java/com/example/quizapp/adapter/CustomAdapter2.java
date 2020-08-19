package com.example.quizapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.quizapp.R;
import com.example.quizapp.model.ListModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    OnLastNextCliCkListener2 listener;
    ArrayList<ListModel> list;


    public CustomAdapter2(OnLastNextCliCkListener2 listener, ArrayList<ListModel> list){
        this.list = list;
        this.listener = listener;
    }

    public void setBackGroundColorOfViews(int position) {
        for(int i=0;i<list.size();i++){
            if(i!=position){
                list.get(i).setBackgroundColor(false);
            }
        }

        list.get(position).setBackgroundColor(true);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater  layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        if(list.get(position).getBackgroundColor()){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ECE6DF"));
        } else {
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }


        holder.tv_ques.setText(list.get(position).getQuestion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLastClick2(holder.tv_ques.getText().toString(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tv_ques;
        LinearLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ques =  itemView.findViewById(R.id.tv_ques);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
    public  interface  OnLastNextCliCkListener2{
        void onLastClick2(String s, int position);
    }
}
