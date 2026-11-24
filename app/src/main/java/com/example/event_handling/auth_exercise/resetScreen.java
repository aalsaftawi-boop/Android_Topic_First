package com.example.event_handling.auth_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivityResetScreenBinding;

public class resetScreen extends AppCompatActivity {

    String email, new_passwordEt;
    String receviedemail;
    ActivityResetScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // جلب الإيميل المرسل من الشاشة السابقة وتخزينه في المتغير receviedemail
         receviedemail = getIntent().getStringExtra("email");


        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }



        binding.resetpasswordBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. سحب النص المكتوب داخل حقل الإيميل وحقل كلمة المرور الجديدة
                String email = binding.emailEt.getText().toString();
                String password = binding.newPasswordEt.getText().toString();
                // 3. الفحص (الشرط الأول): إذا كان الإيميل المكتوب مطابقاً تماماً للإيميل المستلم (receviedemail) وكلمة المرور الجديدة ليست فارغة
                if (email.equals(receviedemail) && !password.equals("")){
                    // إظهار رسالة نجاح للمركز
                    Toast.makeText(resetScreen.this, "THE DATA IS SUCCEFULY", Toast.LENGTH_SHORT).show();
                    // 4. إنشاء Intent فارغ لاستخدامه كحقيبة بيانات لإرجاع الباسورد الجديد
                    Intent intent = new Intent();
                    // 5. وضع كلمة المرور الجديدة داخل الحقيبة تحت اسم "newPassword"
                    intent.putExtra("newPassword",password);
                    // 6. تحديد رمز العودة بنجاح (101) وتمرير حقيبة البيانات معه إلى الـ Launcher المنتظر في الشاشة السابقة
                    setResult(101,intent);
                    // 7. إغلاق هذه الشاشة الحالية فوراً والعودة تلقائياً لشاشة الـ Login
                    finish();
                }
                // الشرط الثاني: إذا كان الإيميل المكتوب غير مطابق للإيميل المستلم
                else if (!email.equals(receviedemail)) {
                    // تنبيه المستخدم بالتأكد من صحة إيميله
                    Toast.makeText(resetScreen.this, "CHECK FOR EMAIL", Toast.LENGTH_SHORT).show();
                }
                // الشرط الثالث: إذا كان الإيميل غير فارغ ولكن كلمة المرور فارغة
                else if (!email.equals("") || password.equals("")) {
                    Toast.makeText(resetScreen.this, "FILL THE DATA", Toast.LENGTH_SHORT).show();
                }
                else {
                    // احتمال احتياطي أخير في حال كانت كافة الحقول فارغة تماماً
                    Toast.makeText(resetScreen.this, "THE DATA IS EMPTY", Toast.LENGTH_SHORT).show();
                }


            }
        });








    }
}