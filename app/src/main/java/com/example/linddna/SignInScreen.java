package com.example.linddna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignInScreen extends AppCompatActivity {

    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);




            tvRegister = (TextView) findViewById(R.id.tvRegisterScreen);

            tvRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity2();

                }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, RegistryScreen.class);
        startActivity(intent);
    }
}
