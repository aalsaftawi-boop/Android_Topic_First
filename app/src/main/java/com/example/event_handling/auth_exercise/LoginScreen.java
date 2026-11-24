package com.example.event_handling.auth_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {

    String receviedemail,receviedpassword;
    ActivityLoginScreenBinding binding;

    // 1. تعريف وتجهيز الـ launcher لمراقبة الشاشة التي ستعود ببيانات
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                // 2. هذه الدالة تعمل تلقائياً فور إغلاق شاشة الـ reset والعودة لهذه الشاشة
                public void onActivityResult(ActivityResult result) {
                    // 3. الفحص والأمان: التأكد من أن الشاشة العائدة أرسلت بيانات بالفعل (!= null)
                    // والتأكد من أن رمز العودة (ResultCode) يساوي 101 (وهو الرقم التأكيدي الذي حددته في الشاشة الثانية)
                    if (result.getData()!=null && result.getResultCode() == 101){
                        // 4. استخراج كلمة المرور الجديدة المرسلة تحت اسم "newPassword"
                        // وحفظها داخل المتغير الأساسي للشاشة (receviedpassword)
                        receviedpassword = result.getData().getStringExtra("newPassword");
                        binding.passwordEt.setText(receviedpassword);
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }


         receviedemail = getIntent().getStringExtra("email");
         receviedpassword = getIntent().getStringExtra("password");

         binding.loginBt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // 2. سحب النص المكتوب داخل حقل الإيميل وحقل الباسورد في هذه الشاشة
                 String email = binding.emailEt.getText().toString();
                 String password = binding.passwordEt.getText().toString();

                 // 3. الفحص (الشرط الأول): إذا كان الإيميل والباسورد المكتوبان يطابقان تماماً البيانات المستلمة (receviedemail و receviedpassword)
                 if (email.equals(receviedemail) && password.equals(receviedpassword)){
                     // إظهار رسالة نجاح تخبره بأن البيانات صحيحة وتم تسجيل الدخول بنجاح
                     Toast.makeText(LoginScreen.this, "THE DATA IS SUCCESFULY", Toast.LENGTH_SHORT).show();
                 }
                 // الشرط الثاني: إذا كان الإيميل المكتوب خطأ "أو" الباسورد المكتوب خطأ (لا يطابقان البيانات المستلمة)
                 else if (!email.equals(receviedemail) || !password.equals(receviedpassword)) {
                     // إظهار تنبيه للمستخدم (مكتوب فيه FILL THE DATA ولكن برمجياً يعني أن البيانات المدخلة غير متطابقة)
                     Toast.makeText(LoginScreen.this, "FILL THE DATA", Toast.LENGTH_SHORT).show();
                 }
                 // احتمال احتياطي أخير في حال عدم تحقق الشروط السابقة
                 else {
                     Toast.makeText(LoginScreen.this, "THE DATA IS EMPTY", Toast.LENGTH_SHORT).show();
                 }
             }
         });


         binding.resetpasswordTv.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // 2. سحب الإيميل المكتوب حالياً في الحقل لحفظه وتمريره
                 String email = binding.emailEt.getText().toString();
                 // 3. إنشاء Intent للانتقال إلى شاشة إعادة التعيين (resetScreen)
                 Intent intent = new Intent(getBaseContext(), resetScreen.class);
                 // 4. وضع الإيميل المكتوب في حقيبة البيانات لكي يظهر تلقائياً في الشاشة القادمة دون إعادة كتابته
                 intent.putExtra("email",email);
                 // 5. تشغيل الشاشة الجديدة باستخدام الـ launcher (تُستخدم لفتح شاشة وانتظار نتيجة عائدة منها، مثل الباسورد الجديد)
                 launcher.launch(intent);
             }
         });










    }
}