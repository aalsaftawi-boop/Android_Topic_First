package com.example.event_handling.menus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;
import com.example.event_handling.databinding.ActivityMenuBinding;

public class menuActivity extends AppCompatActivity {
    // 1. تعريف "العقد" (Launcher) لاستقبال البيانات العائدة من شاشتي الطالب والمعلم
    ActivityResultLauncher<Intent>launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // إذا رجعنا من شاشة الطالب (101) والبيانات موجودة
                  if (result.getResultCode() == 101 && result.getData()!=null){
                      Intent intent = result.getData();
                      String name = intent.getStringExtra("name");
                      String id = intent.getStringExtra("id");
                      binding.dataTv.append("STUDENT  : "+name+"\t"+id+"\n");
                  }
                  // إذا رجعنا من شاشة المعلم (102) والبيانات موجودة
                  else if (result.getResultCode() == 102 && result.getData()!=null) {
                      Intent intent = result.getData();
                      String name = intent.getStringExtra("name");
                      String id = intent.getStringExtra("id");
                      binding.dataTv.append("TEACHER  : "+name+"\t"+id+"\n");
                  }
                }

            });


    ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ربط قائمة الضغط المطول (Context Menu) بنص عرض البيانات (dataTv)
        registerForContextMenu(binding.dataTv);


    }

    // إنشاء القائمة العلوية (الثلاث نقاط) وتركيب ملف الـ XML الخاص بها
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.firs_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // التحكم في الأزرار الموجودة داخل القائمة العلوية عند الضغط عليها
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // إذا ضغط على خيار الطالب: افتح شاشة الطالب وانتظر بياناتها
        if (item.getItemId() == R.id.studentId){
            launcher.launch(new Intent(getBaseContext(), studentActivity.class));
            return true;
            // إذا ضغط على خيار المعلم: افتح شاشة المعلم وانتظر بياناتها
        } else if (item.getItemId() == R.id.teacherId) {
            launcher.launch(new Intent(getBaseContext(), teacherActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // إنشاء قائمة الضغط المطول وتركيب ملف الـ XML الخاص بالألوان
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    // التحكم في خيارات قائمة الضغط المطول (تغيير لون النص)
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.blou_id){
            binding.dataTv.setTextColor(Color.BLUE);
        } else if (item.getItemId() == R.id.red_id) {
            binding.dataTv.setTextColor(Color.RED);
        }else if (item.getItemId() == R.id.green_id) {
            binding.dataTv.setTextColor(Color.GREEN);
        }
        return super.onContextItemSelected(item);
    }
}
