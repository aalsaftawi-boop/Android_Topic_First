package com.example.event_handling.AssignmentRecyceler;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_handling.alert_dialog.alertDialog;
import com.example.event_handling.databinding.IetmCarBinding;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyCarHolder> {
    Context context;
    ArrayList<Car> cars;


    public CarAdapter(Context context, ArrayList<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public MyCarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IetmCarBinding binding = IetmCarBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyCarHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCarHolder holder, int position) {
        Car c = cars.get(position);
        holder.nameTv.setText(c.getName());
        holder.modelTv.setText(c.getModel());
        holder.colorTv.setText(c.getColor());
        holder.image.setImageResource(c.getImage());



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();

                // التحقق من أن الموقع صالح وليس في حالة حذف مستمر
                if (position != RecyclerView.NO_POSITION) {

                    // 2. حذف العنصر من قائمة البيانات (استبدل itemList باسم القائمة لديك)
                    cars.remove(position);

                    // 3. إعلام الـ Adapter بتحديث القائمة وحذف العنصر مرئياً
                    notifyItemRemoved(position);
                }

                // 4. إرجاع true لإعلام النظام أن الحدث تم استهلاكه ولا داعي لتشغيل أحداث أخرى
                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                new AlertDialog.Builder(v.getContext()).setTitle("ARE YOU LOG ONOTHER SCRREN ?")
                        .setMessage("do uou goto another screen ? if yes click here")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Car car = cars.get(position);
                                Intent intent = new Intent(v.getContext(), DetielsActivity.class);
                                intent.putExtra("image",car);
                                v.getContext().startActivity(intent);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), "data is failed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("CANCELED", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), "CANCELED", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();



            }
        });


    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class MyCarHolder extends RecyclerView.ViewHolder{

        TextView nameTv,modelTv,colorTv;
        ImageView image;

        public MyCarHolder(@NonNull IetmCarBinding binding) {
            super(binding.getRoot());
            nameTv = binding.nameCarTv;
            modelTv = binding.modelCarTv;
            colorTv = binding.colorCarTv;
            image = binding.imageCar;
        }
    }


}
