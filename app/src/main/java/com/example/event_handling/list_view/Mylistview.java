package com.example.event_handling.list_view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivityMylistviewBinding;

import java.util.ArrayList;

public class Mylistview extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> product;
    ArrayAdapter<String> adapter;
    ActivityMylistviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMylistviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //هذه الدالة تعمل على اخفاء ال ACTIONPAR
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        // تهيئة المصفوفة لتبدأ فارغة
        product = new ArrayList<>();

        // إضافة أسماء المنتجات (تكرار المنتجات هنا لكي تصبح القائمة طويلة وتدعم التمرير لأسفل)
        product.add("MILK");
        product.add("KOLLA");
        product.add("JOSE");
        product.add("MEAT");
        product.add("MILK");
        product.add("KOLLA");
        product.add("JOSE");
        product.add("MEAT");
        product.add("MILK");
        product.add("KOLLA");
        product.add("JOSE");
        product.add("MEAT");


        // إنشاء المحول (Adapter)، وتحديد شكل التصميم لكل عنصر في القائمة (استخدم هنا تصميم جاهز من أندرويد اسمه simple_list_item_1)، وتمرير قائمة المنتجات له
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, product);

        // ربط هذا المحول بالـ ListView الموجودة في الواجهة والتي تحمل المعرف (productLv) ليتم عرض المنتجات بداخلها فوراً
        binding.productLv.setAdapter(adapter);


//        binding.addProductBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = binding.productName.getText().toString();
//                product.add(name);
//                adapter.notifyDataSetChanged();
//            }
//        });



        //عند الضغط على اي عنصر في الlist ينقلو على واجهة بها تفاصيل
//        binding.productLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String productName = product.get(position);
//               new AlertDialog.Builder(Mylistview.this)
//                       .setTitle("ARE YOU SURE TO GOTO PROPATATIES ?")
//                       .setMessage("YOU MUST DELETE THE ITEM IF CLICKED HER")
//                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                              Intent intent = new Intent(getBaseContext(), ProductDetiales.class);
//                              intent.putExtra("product",b);
//                               startActivity(new Intent(getBaseContext(),
//                                       ProductDetiales.class).putExtra("product",productName));
//                           }
//                       })
//                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                               Toast.makeText(Mylistview.this, "NOT DELETED", Toast.LENGTH_SHORT).show();
//                           }
//                       })
//                       .show()
//                       .setCancelable(true);
//            }
//        });





//        binding.productLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int p = position;
//                new AlertDialog.Builder(Mylistview.this)
//                       .setTitle("ARE YOU SURE TO DELETE THIS ITEM ?")
//                       .setMessage("YOU MUST DELETE THE ITEM IF CLICKED HER")
//                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                               product.remove(p);
//                               adapter.notifyDataSetChanged();
//                           }
//                       })
//                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                               Toast.makeText(Mylistview.this, "NOT DELETED", Toast.LENGTH_SHORT).show();
//                           }
//                       })
//                       .show()
//                       .setCancelable(true);
//            }
//        });


        // الأداة التي تربط الدالة التي شرحناها سابقاً بالـ ListView. بدون هذا السطر، لن يشعر التطبيق بنقرات المستخدم على عناصر القائمة نهائياً.
        binding.productLv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 1. حفظ رقم موقع (ترتيب) العنصر المضغوط في متغير اسمه p (مثلاً: العنصر الأول رقم 0)
                int p = position;
                new AlertDialog.Builder(Mylistview.this)
                       .setTitle("ARE YOU SURE TO DELETE THIS ITEM ?")
                       .setMessage("YOU MUST DELETE THE ITEM IF CLICKED HER")
                        // 3. برمجة زر التأكيد "YES" (عند الضغط عليه يتم الحذف الفعلي)
                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               product.remove(p);// (الحذف الفعلي) يحذف العنصر من المصفوفة بناءً على رقمه p
                               adapter.notifyDataSetChanged();// (التحديث) يخبر القائمة بأن البيانات تغيرت لكي تخفي العنصر فوراً من الشاشة
                               Toast.makeText(Mylistview.this, "Item Delete", Toast.LENGTH_SHORT).show();// إظهار رسالة "تم الحذف"
                           }
                       })
                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(Mylistview.this, "NOT DELETED", Toast.LENGTH_SHORT).show();
                           }
                       })
                       .show()
                       .setCancelable(true);
    }









//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String p = product.get(position);    // 1. جلب اسم المنتج الذي ضغط عليه المستخدم من القائمة بناءً على موقعه (position) وتخزينه في المتغير p
//
//        // 2. البدء في بناء وتجهيز النافذة التنبيهية (AlertDialog) في الشاشة الحالية
//        new AlertDialog.Builder(Mylistview.this)
//                       .setTitle("ARE YOU SURE TO DELETE THIS ITEM ?")
//                       .setMessage("ARE YOU INTENT TO PRODUCT ACTIVITY")
//                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                               /*
//                               // أمر لفتح شاشة جديدة والانتقال إليها مع إرسال بيانات (اسم المنتج) معها
//                               // 1. إنشاء "Intent" (وسيلة الانتقال) وتحديد نقطة الانطلاق والوجهة
//                               // 2. وضع اسم المنتج في حقيبة البيانات لإرساله للشاشة القادمة
//                               "product" هو اسم المفتاح (الرمز)، و p هو اسم المنتج الفعلي (مثل MILK)/
//                                */
//                               startActivity(new Intent(getBaseContext(), ProductDetiales.class).putExtra("product",p));
//                           }
//                       })
//                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialog, int which) {
//                               Toast.makeText(Mylistview.this, "NOT DELETED", Toast.LENGTH_SHORT).show();
//                           }
//                       })
//                       .show()
//
//                // 6. جعل النافذة قابلة للإلغاء إذا ضغط المستخدم في أي مكان فارغ خارج النافذة
//                .setCancelable(true);
//    }
}

