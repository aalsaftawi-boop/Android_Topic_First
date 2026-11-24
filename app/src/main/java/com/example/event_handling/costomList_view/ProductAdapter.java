package com.example.event_handling.costomList_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.event_handling.databinding.ItemProductBinding;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product> products;
    Context context;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product p = products.get(position);
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(context)
                ,parent,false);

        binding.productidTv.setText(String.valueOf(p.getId()));
        binding.productnameTv.setText(String.valueOf(p.getName()));
        binding.productpriceTv.setText(String.valueOf(p.getPrice()));
        binding.productquantityTv.setText(String.valueOf(p.getQuantity()));
        return binding.getRoot();
    }
}
