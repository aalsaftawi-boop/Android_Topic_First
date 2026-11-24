package com.example.event_handling.RecycelerViewWithDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.databinding.ItemStudent2Binding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentVeiwHolder2> {


    ArrayList<Student> students;
    StudentListener listener;

    public StudentAdapter(ArrayList<Student> students, StudentListener listener) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentVeiwHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudent2Binding binding = ItemStudent2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StudentVeiwHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentVeiwHolder2 holder, int position) {
         int pos = position;
         Student s = students.get(pos);

        holder.idTv.setText(String.valueOf(s.getId())); // 👈 تم التعديل هنا
        holder.nameTv.setText(s.getName());
        holder.GbaTv.setText(String.valueOf(s.getGba()));
        holder.fieldTv.setText(s.getField());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(pos);
            }
        });

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDelete(s.getId(),pos);
            }
        });

        holder.editIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEdit(s.getId(),pos);
            }
        });





    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentVeiwHolder2 extends RecyclerView.ViewHolder{

        TextView nameTv, idTv, GbaTv, fieldTv;
        ImageView deleteIv, editIv;
        public StudentVeiwHolder2(@NonNull ItemStudent2Binding binding) {
            super(binding.getRoot());
            nameTv = binding.nameTv;
            idTv = binding.idTv;
            GbaTv = binding.GbaTv;
            deleteIv = binding.deletIv;
            editIv = binding.editIv;
            fieldTv = binding.fieldTv;
        }
    }


}
