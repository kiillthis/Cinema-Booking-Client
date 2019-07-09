package com.cinema.client.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.client.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText ETemail;
    private EditText ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in

                } else {
                    // User is signed out

                }

            }
        };

        ETemail = (EditText) findViewById(R.id.takeLogin);
        ETpassword = (EditText) findViewById(R.id.takePassword);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin)
        {
            signin(ETemail.getText().toString(),ETpassword.getText().toString());
        }else if (view.getId() == R.id.btnRegister)
        {
            Intent intent = new Intent(EmailActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

    }

    public void signin(String email , String password)
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(EmailActivity.this, "Aвторизация успешна", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EmailActivity.this, HomeActivity.class));
                }else
                    Toast.makeText(EmailActivity.this, "Aвторизация провалена", Toast.LENGTH_SHORT).show();

            }
        });
    }

}