package com.example.fir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String fileName="example.txt";
    EditText et;
    EditText et1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editTextText);
        et1=findViewById(R.id.editTextText2);

    }
    public void save(View v){
        String id=et.getText().toString();
        String details=et1.getText().toString();
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream=openFileOutput(fileName,MODE_PRIVATE);
            fileOutputStream.write(id.getBytes());
            et.getText().clear();
            et1.getText().clear();
            Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}