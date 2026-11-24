package com.example.event_handling.RecyclerViewPart2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.databinding.ItemTecherBinding;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    List<Teacher> teachers;
    Context context;
    studentListener listener;

    public TeacherAdapter(List<Teacher> teachers, Context context,studentListener listener) {
        this.teachers = teachers;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTecherBinding binding = ItemTecherBinding.inflate(LayoutInflater.from(context),parent,false);
        return new TeacherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        int i = position;
        Teacher teacher = teachers.get(position);
        holder.teacheridTv.setText(String.valueOf(teacher.getId()));
        holder.teacherNameTv.setText(teacher.getName());
        holder.teacherGbaTv.setText(String.valueOf(teacher.getGba()));
        holder.teacherfiledTv.setText(teacher.getField());

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDelete(i);
            }
        });

        // عند الضغط على ال item يتغير لونه
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setBackgroundColor(Color.CYAN);
            }
        });

        // عند الضفط على Edit icon
        holder.editIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEdit(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder {

        TextView teacherNameTv;
        TextView teacheridTv;
        TextView teacherGbaTv;
        TextView teacherfiledTv;
        ImageView deleteIv,editIv;

        public TeacherViewHolder(@NonNull ItemTecherBinding binding) {
            super(binding.getRoot());
            teacherNameTv = binding.nameTv;
            teacheridTv = binding.idTv;
            teacherGbaTv = binding.GbaTv;
            teacherfiledTv = binding.fieldTv;
            deleteIv = binding.deletIv;
            editIv = binding.editIv;
        }
    }

}
