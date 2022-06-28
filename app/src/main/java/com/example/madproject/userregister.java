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

public class userregister extends AppCompatActivity {
        EditText mFullName,mEmail,mPssword,mPhone;
        Button mRegisterbtn;
        TextView mloginbtn;
        FirebaseAuth fAuth;
        ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);

        mFullName =findViewById(R.id.fullname);
        mEmail =findViewById(R.id.usermail);
        mPhone  = findViewById(R.id.pno);
        mPssword =findViewById(R.id.userpass);
        mRegisterbtn=findViewById(R.id.registerbtn);
        mloginbtn =findViewById(R.id.loginnowbtn);
        fAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            finish();
        }


        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
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
                //register user in firebase

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(userregister.this, "USER CREATED", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }
                        else{

                            Toast.makeText(userregister.this, "ERROR!!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });
        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),userlogin.class));

            }
        });
    }
}