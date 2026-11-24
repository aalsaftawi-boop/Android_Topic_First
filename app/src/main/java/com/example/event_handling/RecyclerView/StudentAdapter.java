package com.example.event_handling.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.event_handling.databinding.ItemStudent2Binding;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    // مصفوفة البيانات التي سيتم عرضها في القائمة
    private ArrayList<Student> students;

    // 1. الكونستركتور (Constructor): نمرر له فقط قائمة الطلاب
    public StudentAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    // 2. دالة إنشاء الواجهة لكل سطر (ViewHolder)
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // نستخدم parent.getContext() بشكل مباشر لضمان عدم الحصول على قيمة null
        ItemStudent2Binding binding = ItemStudent2Binding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new StudentViewHolder(binding);
    }

    // 3. دالة ربط البيانات وعرضها داخل التصميم (Binding Data)
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);

        // إسناد القيم النصية والرقمية (بعد تحويل الأرقام إلى نصوص)
        holder.studentNameTv.setText(student.getName());
        holder.getStudentIdTv.setText(String.valueOf(student.getId()));
        holder.getStudentFieldTv.setText(student.getField());
        holder.getStudentGbaTv.setText(String.valueOf(student.getGba()));
    }

    // 4. دالة معرفة عدد العناصر الإجمالي في القائمة
    @Override
    public int getItemCount() {
        return students.size();
    }

    // 5. كلاس الـ ViewHolder المسؤول عن تعريف المكونات المرئية (Views)
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameTv;
        TextView getStudentIdTv;
        TextView getStudentGbaTv;
        TextView getStudentFieldTv;

        public StudentViewHolder(@NonNull ItemStudent2Binding binding) {
            super(binding.getRoot());
            // ربط المتغيرات بملف الـ XML عن طريق الـ binding
            studentNameTv = binding.nameTv;
            getStudentIdTv = binding.idTv;
            getStudentGbaTv = binding.GbaTv;
            getStudentFieldTv = binding.fieldTv;
        }
    }
}
