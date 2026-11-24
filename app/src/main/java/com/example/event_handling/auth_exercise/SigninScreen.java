package com.example.event_handling.auth_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivitySigninScreenBinding;

public class SigninScreen extends AppCompatActivity {

    ActivitySigninScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }


        binding.signInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. سحب النص المكتوب داخل حقل الإيميل وحقل كلمة المرور وتحويلهما لنصوص (Strings)
                String email = binding.emailEt.getText().toString();
                String password = binding.passwordEt.getText().toString();
                // 3. الفحص (الشرط الأول): إذا كان الإيميل غير فارغ وكلمة المرور أيضاً غير فارغة
                if (!email.equals("") && !password.equals("")){

                    // إظهار رسائل توضيحية سريعة أسفل الشاشة بنجاح العملية
                    Toast.makeText(SigninScreen.this, "THE DATA IS SUCCESFULY", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SigninScreen.this, "THE DATA IS COMPLETED", Toast.LENGTH_SHORT).show();

                    // 4. إنشاء الـ Intent للانتقال من هذه الشاشة الحالية إلى شاشة تسجيل الدخول (LoginScreen)
                    Intent intent = new Intent(getBaseContext(), LoginScreen.class);

                    // 5. وضع الإيميل والباسورد داخل "حقيبة البيانات" المُسافرة للشاشة القادمة
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);

                    // 6. تشغيل الأمر وفتح الشاشة الجديدة فوراً
                    startActivity(intent);

                    // الشرط الثاني: إذا كان الإيميل فارغاً "أو" الباسورد فارغاً
                } else if (email.equals("") || password.equals("")) {
                    // إظهار تنبيه للمستخدم بضرورة ملء البيانات

                    Toast.makeText(SigninScreen.this, "FILL THE DATA", Toast.LENGTH_SHORT).show();
                }

                // احتمال احتياطي أخير (لن يصل إليه الكود عملياً لأن الشرط الثاني يغطي كافة الحالات الفارغة)
                else {
                    Toast.makeText(SigninScreen.this, "FILL THE DATA", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}