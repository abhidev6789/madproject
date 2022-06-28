package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userlogin extends AppCompatActivity {

    EditText mEmail,mPssword;
    Button mloginbtn;
    TextView mregisteruserbtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);


        mEmail =findViewById(R.id.usermail);

        mPssword =findViewById(R.id.userpass);
        mregisteruserbtn=findViewById(R.id.registernowbtn);
        mloginbtn =findViewById(R.id.loginbtn);
        fAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressBar);

        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= mEmail.getText().toString();
                String pass =mPssword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    mPssword.setError("Password is required");
                    return;
                }

                if(pass.length()<8){
                    mPssword.setError("Password must be having 8 characters in minimum");
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user

                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(userlogin.this, "login sucessful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        } else{
                            Toast.makeText(userlogin.this, "ERROR!!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        mregisteruserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),userregister.class));

            }
        });

    }
}