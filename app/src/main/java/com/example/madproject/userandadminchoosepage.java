package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class userandadminchoosepage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userandadminchoosepage);

        Button button1=findViewById(R.id.adminbtn);
        Button button2=findViewById(R.id.userbtn);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adminbtn:;
                Intent intent= new Intent(this,adminlogin.class);
                startActivity(intent);
                break;
            case R.id.userbtn:;
                Intent ad= new Intent(this,userlogin.class);
                startActivity(ad);
                break;
        }

    }
}