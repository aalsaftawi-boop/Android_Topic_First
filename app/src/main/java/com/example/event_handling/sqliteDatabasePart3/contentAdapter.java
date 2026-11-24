package com.example.event_handling.sqliteDatabasePart3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.databinding.ItemContent2Binding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.contentViewHolder> {


    ArrayList<Content> contents;

    public contentAdapter(ArrayList<Content> contents) {
        this.contents = contents;
    }

    @NonNull
    @Override
    public contentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContent2Binding binding = ItemContent2Binding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new contentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull contentViewHolder holder, int position) {
        Content content = contents.get(position);
        holder.nameTv.setText(content.getName());
        holder.emailTv.setText(content.getEmail());
        holder.phoneTv.setText(content.getPhone());
        holder.yearTv.setText(String.valueOf(content.getYearOfBirth()));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    class contentViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv;
        TextView emailTv;
        TextView phoneTv;
        TextView yearTv;
        public contentViewHolder(ItemContent2Binding binding) {
            super(binding.getRoot());

            nameTv = binding.nameTv;
            emailTv = binding.emailTv;
            phoneTv = binding.phoneTv;
            yearTv = binding.yearTv;







        }
    }


}
