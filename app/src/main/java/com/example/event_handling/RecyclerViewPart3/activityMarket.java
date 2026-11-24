package com.example.event_handling.RecyclerViewPart3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityMarketBinding;

import java.util.ArrayList;

public class activityMarket extends AppCompatActivity implements marketInterface{


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null && result.getResultCode() == 101){
                        String name = result.getData().getStringExtra("newName");
                        int index = result.getData().getIntExtra("position",-1);
                        markets.get(index).setName(name);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

    ActivityMarketBinding binding;
    marketAdapter adapter;
    ArrayList<Market>markets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMarketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        markets = new ArrayList<>();
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));
        markets.add(new Market("AHMED",1,2026,"GAZA"));

        adapter = new marketAdapter(markets,this,this);

        binding.marketRecycler.setAdapter(adapter);
        binding.marketRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                markets.add(new Market(binding.nameEt.getText().toString(),3,2026,"RAFAH"));
                adapter.notifyItemChanged(markets.size()-1);
            }
        });


    }

    @Override
    public void onDelete(int pos) {
        markets.remove(pos);
        adapter.notifyItemRemoved(pos);
    }

    @Override
    public void onEdit(int pos) {
       Intent intent = new Intent(this, editActivity.class);
       intent.putExtra("marketName",markets.get(pos).getName());
       intent.putExtra("position",pos);
       launcher.launch(intent);
    }
}