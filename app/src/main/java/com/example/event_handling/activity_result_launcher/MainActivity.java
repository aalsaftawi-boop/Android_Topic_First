package com.example.event_handling.activity_result_launcher;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     private Button show_Bt;
     ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        binding.showBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name =binding.nameEt.getText().toString();
               int age = (Integer.parseInt(binding.birthYearEt.getText().toString()));
               int age2 = 2026 - age;

               String maleOrfemale = "";
               if (binding.genderRg.getCheckedRadioButtonId() == R.id.maleRb){
                   maleOrfemale = "MALE";
               }
               else{
                   maleOrfemale = "FEMALE";
               }

               String status = "single";
               if (binding.marriedCb.isChecked()){
                   status = "MARRIED";
               }
               String ceties = (String)binding.citeisSpinner.getSelectedItem();
               String data = name+"\n"+age2+"\n"+maleOrfemale+"\n"+status+"\n"+ceties;
               binding.showInfoTv.setText(data);
               binding.showInfoTv.setTextColor(Color.parseColor("#000000"));
            }
        });





    }
}