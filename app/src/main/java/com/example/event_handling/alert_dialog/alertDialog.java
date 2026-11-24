package com.example.event_handling.alert_dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.databinding.ActivityAlertDialogBinding;

public class alertDialog extends AppCompatActivity {

    ActivityAlertDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlertDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



            binding.alerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(alertDialog.this);
                dialog.setTitle("ALERT DIALOG EXAMBLE");
                dialog.setMessage("this is an examble of alert dialog in androi");


                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alertDialog.this, "procces succesfuly", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alertDialog.this, "procces failed", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNeutralButton("CANCELED", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alertDialog.this, "procces canceled", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(alertDialog.this).setTitle("ARE YOU LOG ONOTHER SCRREN ?")
                .setMessage("why do uou goto another screen ?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alertDialog.this, "data is failed", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("CANCELED", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alertDialog.this, "CANCELED", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}