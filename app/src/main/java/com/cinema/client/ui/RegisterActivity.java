package com.cinema.client.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cinema.client.R;
import com.cinema.client.data.DataBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText ETname;
    private EditText ETemail;
    private EditText ETpassword;
    private EditText ETpassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        ETname = (EditText) findViewById(R.id.reg_fullname);
        ETemail = (EditText) findViewById(R.id.reg_email);
        ETpassword = (EditText) findViewById(R.id.reg_password);
        ETpassword2 = (EditText) findViewById(R.id.reg_password_again);


        findViewById(R.id.btnRegister2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnRegister2)
        {
            if(ETpassword.getText().toString().equals(ETpassword2.getText().toString())&& !(ETemail.getText().toString().isEmpty())) {
                registration(ETemail.getText().toString(), ETpassword.getText().toString());
            }
            else if(!(ETpassword.getText().toString().equals(ETpassword2.getText().toString()))){
                Toast.makeText(RegisterActivity.this, "Пароли разные", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(RegisterActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void registration (final String email , final String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    new DataBase().createUser(ETemail.getText().toString(), ETname.getText().toString());
                    Toast.makeText(RegisterActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    mAuth.signInWithEmailAndPassword(email, password);
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
                else
                    Toast.makeText(RegisterActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
