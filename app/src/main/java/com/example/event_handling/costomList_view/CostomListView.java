package com.example.event_handling.costomList_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityCostomListViewBinding;

import java.util.ArrayList;

public class CostomListView extends AppCompatActivity {

    ActivityCostomListViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCostomListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }


        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(123,"MILK",22,20));
        products.add(new Product(123,"MILK",22,20));
        products.add(new Product(123,"MILK",22,20));
        products.add(new Product(123,"MILK",22,20));



        ProductAdapter adapter = new ProductAdapter(products,this);

        binding.productLv.setAdapter(adapter);
















    }
}