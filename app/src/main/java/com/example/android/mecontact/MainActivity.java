package com.example.android.mecontact;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.net.*;
import android.view.View;
import java.io.*;
import android.widget.*;

import com.wordpress.priyankvex.easyocrscannerdemo.EasyOcrScannerListener;

public class MainActivity extends AppCompatActivity implements EasyOcrScannerListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                System.out.println("Test");
                String filename = "file.jpg";
                File newFile = new File(filename);
                Uri outputFileUrl = Uri.fromFile(newFile);

                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //camera.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUrl);
                System.out.println(outputFileUrl);
                startActivityForResult(camera, 1);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK) {
                System.out.println("Result was okay.");
                System.out.println("DATA: " + data.toString());
                System.out.println("DATA: " + data.getAction());
                System.out.println("DATA: " + data.getDataString());
                Uri imageData = data.getData();
                System.out.println("URI: " + imageData);
            } else{
                System.out.println("Result is not ok.");
            }
        }
    }

    @Override
    public void onOcrScanStarted(String filePath) {

    }

    @Override
    public void onOcrScanFinished(Bitmap bitmap, String recognizedText) {

    }
}
