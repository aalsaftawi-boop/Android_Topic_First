package com.example.event_handling.SqliteQuiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.databinding.ItemListStudentBinding;

import java.util.ArrayList;

public class StudentQuizAdapter extends RecyclerView.Adapter<StudentQuizAdapter.StudentViewHolder> {

    ArrayList<Student> students;
    Context context;
    // تم تغيير نوع الـ Listener ليتوافق مع الـ Activity الحالية
    StudentListListener studentListener;

    // Constructor واحد يستقبل الـ Listener لمنع الـ NullPointerException
    public StudentQuizAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
        // ربط الـ context بالـ listener لأن الـ Activity تعمل implements له
        if (context instanceof StudentListListener) {
            this.studentListener = (StudentListListener) context;
        }
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListStudentBinding binding = ItemListStudentBinding.inflate(LayoutInflater.from(context), parent, false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int index = position;
        Student student = students.get(index);

        holder.studentId.setText(String.valueOf(student.getId()));
        // تم تصحيح الخطأ هنا لعرض الاسم بدلاً من الرقم لتفادي الـ Crash
        holder.studentName.setText(student.getName());
        holder.studentGba.setText(String.valueOf(student.getGba()));
        holder.studentField.setText(student.getField());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentListener != null) {
                    studentListener.onItemClick(student.getId());
                }
            }
        });

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentListener != null) {
                    // تم التعديل لتمرير بارامتر واحد كما هو معرف في الـ Activity الخاصة بك
                    studentListener.onDelete(student.getId());
                }
            }
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentListener != null) {
                    studentListener.onEdit(student.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentId, studentName, studentGba, studentField;
        ImageView deleteImage, editImage;

        public StudentViewHolder(@NonNull ItemListStudentBinding binding) {
            super(binding.getRoot());
            studentId = binding.idTv;
            studentName = binding.nameTv;
            studentGba = binding.GbaTv;
            studentField = binding.fieldTv;
            deleteImage = binding.deletIv;
            editImage = binding.editIv;
        }
    }
}