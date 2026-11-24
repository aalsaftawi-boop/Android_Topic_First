package com.example.event_handling.activity_lifecycle;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;

public class ActivityCycle extends AppCompatActivity {
    EditText nameEt;
    Button showBt, hideBt;
    TextView nameTv;



    /*
 • مهمتها: هي أول دالة تُستدعى عند إنشاء النشاط (Activity) لأول مرة في الذاكرة.
• ماذا يحدث فيها بكودك:
	• تجهيز الواجهة بربط ملف الـ XML باستخدام setContentView.
	• تعريف العناصر (findViewById) مثل الأزرار وحقول النصوص.
	• تعيين مستمعي النقرات (OnClickListener) لتحديد ماذا يحدث عند الضغط على الأزرار.
/
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitylive_cycle);

        nameEt = findViewById(R.id.nameEt);
        showBt = findViewById(R.id.showBt);
        hideBt = findViewById(R.id.hideBt);
        nameTv = findViewById(R.id.nameTv);

        Log.d("liveCycle","this is on create from the log");
        Toast.makeText(ActivityCycle.this,"this is onCreate",
                Toast.LENGTH_SHORT).show();

        showBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                nameTv.setText(name);
                nameTv.setVisibility(View.VISIBLE);
            }
        });

        hideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                nameTv.setText(name);
                nameTv.setVisibility(View.INVISIBLE);
            }
        });

        nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                nameTv.setTextColor(Color.RED);
                nameTv.setTextColor(Color.parseColor("#0BD312"));
            }
        });

        hideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameTv.getVisibility() == View.VISIBLE){
                    nameTv.setVisibility(View.INVISIBLE);
                }
                else {
                    nameTv.setVisibility(View.VISIBLE);
                }
            }
        });




    }



    /*
    • مهمتها: تُستدعى عندما يصبح النشاط مرئيًا للمستخدم على الشاشة، ولكن لا يمكنه التفاعل معه بعد (يكون في الخلفية المرئية)./
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("liveCycle","this is onStart from the log");
    }

    /*
    مهمتها: تُستدعى عندما يصبح النشاط في الواجهة تمامًا وجاهزًا للتفاعل مع المستخدم (أي يمكن للمستخدم الضغط على الأزرار والكتابة)./
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("liveCycle","this is onResume from the log");
    }

    /*
    مهمتها: تُستدعى عندما يفقد النشاط التركيز جزئيًا، مثل ظهور نافذة منبثقة (Dialog) أو إشعار يغطي جزءًا من الشاشة. التطبيق هنا لا يزال مرئيًا جزئيًا ولكنه شبه متوقف./
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("liveCycle","this is onPause from the log");
    }


    /*
    مهمتها: تُستدعى عندما يصبح النشاط غير مرئي تمامًا للمستخدم (مثل الضغط على زر الشاشة الرئيسية Home، أو فتح نشاط آخر جديد بالكامل)./
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("liveCycle","this is onStop from the log");
    }

    /*
    مهمتها: الدالة الأخيرة في دورة الحياة، وتُستدعى قبل تدمير النشاط وحذفه من الذاكرة تمامًا (مثل إغلاق التطبيق نهائيًا بسحبه من قائمة التطبيقات الحديثة، أو عند استدعاء دالة finish())./
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("liveCycle","this is onDestroy from the log");
    }

    /*
    مهمتها: تُستدعى فقط عندما يعود المستخدم إلى النشاط بعد أن كان في حالة onStop (أي كان مخفيًا تمامًا وأعاد فتحه)./
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("liveCycle","this is onRestart from the log");
        nameTv.setVisibility(View.VISIBLE);
    }



    /*
    onSaveInstanceState(): تُستدعى لحفظ البيانات المؤقتة قبل أن يقوم النظام بتدمير النشاط مؤقتًا (مثل عند تدوير الشاشة من الطولي للعرضي). في كودك، قمت بحفظ النص الموجود داخل nameTv تحت مفتاح اسم "name"./
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = nameTv.getText().toString();
        outState.putString("name",name);
    }


    /*
    • onRestoreInstanceState(): تُستدعى بعد إعادة إنشاء النشاط لاسترجاع البيانات التي تم حفظها. في كودك، قمت بجلب النص المحفوظ وضبطه مجددًا في الـ nameTv لكي لا يضيع على المستخدم بعد تدوير الشاشة./
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("name","null");
        nameTv.setText(name);
    }
}