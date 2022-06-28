package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    Button login;
    EditText mailid,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        login=(Button) findViewById(R.id.adminloginbtn);
        mailid =findViewById(R.id.adminmailid);
        pass =findViewById(R.id.adminpass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }
    public void login(){
        String user=mailid.getText().toString().trim();
        String password=pass.getText().toString().trim();
        if(user.equals("admin@gmail.com")&& pass.equals("12345678"))
        {
            Toast.makeText(this, "Login sucessfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));

        }
        else{
            Toast.makeText(this, "Username and password is invalid", Toast.LENGTH_SHORT).show();
        }
    }
}