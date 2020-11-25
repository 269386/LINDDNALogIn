package com.example.linddna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistryScreen extends AppCompatActivity {

    private TextView tvSignInScreen;
    private Button btnRegister;
    private EditText RegName, RegPassword,RegRepPassword,RegEmail;
    FirebaseAuth fAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_screen);

        tvSignInScreen = (TextView) findViewById(R.id.tvSignInScreen);
        btnRegister = (Button)  findViewById(R.id.btnRegister);
        RegName = (EditText) findViewById(R.id.RegName);
        RegPassword = (EditText) findViewById(R.id.RegPassword);
        RegEmail = (EditText) findViewById(R.id.RegEmail);
        RegRepPassword = (EditText) findViewById(R.id.RegRepPassword);
        fAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = RegEmail.getText().toString();
                String pwd = RegPassword.getText().toString();

                if (email.isEmpty()) {
                    RegEmail.setError("Please enter the email");
                    RegEmail.requestFocus();
                }
                if (pwd.isEmpty()) {
                    RegPassword.setError("Please enter the password");
                    RegPassword.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(RegistryScreen.this, "Please Enter Your Credentials", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    fAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegistryScreen.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegistryScreen.this, "Sign Up unsuccessful, please try again", Toast.LENGTH_LONG).show();

                            } else {
                                startActivity(new Intent(RegistryScreen.this, MainActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegistryScreen.this,"Error occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistryScreen.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(RegistryScreen.this, "Sign Up successful!", Toast.LENGTH_LONG).show();
            }
        });

        tvSignInScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity3()
    {
        Intent intent = new Intent(this, SignInScreen.class);
        startActivity(intent);
    }
    }