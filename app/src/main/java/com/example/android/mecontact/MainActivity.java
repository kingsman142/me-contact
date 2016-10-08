package com.example.android.mecontact;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.net.*;
import android.view.View;
import java.io.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String filename = "file.jpg";
                File newFile = new File(filename);
                Uri outputFileUrl = Uri.fromFile(newFile);

                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                camera.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUrl);

                startActivityForResult(camera, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            Uri imageData = data.getData();

        }
    }
}
