package com.example.event_handling.SharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityMyFormBinding;

public class MyActivityForm extends AppCompatActivity {

    ActivityMyFormBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor edit;
    boolean isSubmit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        // تتعامل مع ملف على مستوى ال ctivity
//        getPreferences(MODE_PRIVATE);
//
//        // تتعامل مع ملف على مستوى ال application
//        PreferenceManager.getDefaultSharedPreferences(this);



        sharedPreferences = getSharedPreferences("myData",MODE_PRIVATE);

        //Class Edit : نحتاجه كوسيط واذا نريد ان نعدل على ملف ال shared pereferences ويأخذ قيمته
        edit = sharedPreferences.edit();


        // القراءة من ال shared preferences
        if (!sharedPreferences.getString("name","nullData").equals("nullData"))
            binding.nameEt.setText(sharedPreferences.getString("name","nullData"));

        if (!sharedPreferences.getString("email","nullData").equals("nullData"))
           binding.emailEt.setText(sharedPreferences.getString("email","nullData"));

        if (!sharedPreferences.getString("year","nullData").equals("nullData"))
           binding.yearEt.setText(sharedPreferences.getString("year","nullData"));

        if (!sharedPreferences.getString("city","nullData").equals("nullData"))
           binding.cityEt.setText(sharedPreferences.getString("city","nullData"));

        if (!sharedPreferences.getString("title","nullData").equals("nullData"))
           binding.titleEt.setText(sharedPreferences.getString("title","nullData"));

        if (!sharedPreferences.getString("service","nullData").equals("nullData"))
          binding.servicesEt.setText(sharedPreferences.getString("service","nullData"));





        // عند الضغط على زر ال submit لا اريد ان اعمل save للبينات
        binding.submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSubmit = true;
                edit.clear().apply();
            }
        });





    }

    @Override
    protected void onStop() {
        super.onStop();

        if (!isSubmit){
            edit.putString("name",binding.nameEt.getText().toString());
            edit.putString("email",binding.emailEt.getText().toString());
            edit.putString("year",binding.yearEt.getText().toString());
            edit.putString("city",binding.cityEt.getText().toString());
            edit.putString("title",binding.titleEt.getText().toString());
            edit.putString("service",binding.servicesEt.getText().toString());
        }

        // يأخذ البيانات ثم يضيفها على ال shared preferences
        edit.apply();



    }
}