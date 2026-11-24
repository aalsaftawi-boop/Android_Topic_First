package com.example.event_handling.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_handling.R;

public class implicitIntent extends AppCompatActivity {

    Button callBt, wepsiteBt, watssap_Bt, addimageBt;
    ImageView imageData;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        Bitmap bt = (Bitmap)intent.getExtras().get("data");
                        imageData.setImageBitmap(bt);
                    }
                }
            });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        callBt = findViewById(R.id.callBt);
        wepsiteBt = findViewById(R.id.wepsiteBt);
        watssap_Bt = findViewById(R.id.watsSap_Bt);
        addimageBt = findViewById(R.id.addImage_Bt);
        imageData = findViewById(R.id.imageData);




        callBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "0593219165";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        wepsiteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://developer.android.com/develop/devices/assistant/get-started";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });

        watssap_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link_watsapp = "https://wa.me/1XXXXXXXXXX";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link_watsapp));
                startActivity(intent);
            }
        });

        addimageBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);
            }
        });





    }
}