package com.example.event_handling.RecyclerViewPart3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.databinding.ItemMrketBinding;

import java.util.List;

public class marketAdapter extends RecyclerView.Adapter<marketAdapter.marketviewHolder> {

    List<Market>markets;
    Context context;
    marketInterface Interface;

    public marketAdapter(List<Market> markets, Context context,marketInterface marketInterface) {
        this.markets = markets;
        this.context = context;
        this.Interface = marketInterface;
    }

    @NonNull
    @Override
    public marketviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMrketBinding binding = ItemMrketBinding.inflate(LayoutInflater.from(context),parent,false);
        return new marketviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull marketviewHolder holder, int position) {
        int i = position;
        Market market = markets.get(i);
        holder.marketName.setText(market.getName());
        holder.marketId.setText(String.valueOf(market.getId()));
        holder.marketDetailes.setText(market.getDetails());
        holder.marketHistory.setText(String.valueOf(market.getHistory()));

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Interface.onDelete(i);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setBackgroundColor(Color.CYAN);
            }
        });


        holder.editIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interface.onEdit(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return markets.size();
    }

    class marketviewHolder extends RecyclerView.ViewHolder {
        TextView marketName;
        TextView marketId;
        TextView marketHistory;
        TextView marketDetailes;
        ImageView editIv,deleteIv;
        public marketviewHolder(ItemMrketBinding binding) {
            super(binding.getRoot());
            marketName = binding.marketName;
            marketId = binding.marketId;
            marketHistory = binding.marketHistory;
            marketDetailes = binding.marketDetailes;
            editIv = binding.editIv;
            deleteIv = binding.deleteIv;
        }
    }
}
