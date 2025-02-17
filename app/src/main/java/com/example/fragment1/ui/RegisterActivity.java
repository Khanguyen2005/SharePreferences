package com.example.fragment1.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment1.R;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserNameRe, edEmail, edPasswordRe;
    ImageButton imbBack;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        imbBack = findViewById(R.id.imbBack); // Ánh xạ
        edUserNameRe = findViewById(R.id.edUserNameRe);
        edEmail = findViewById(R.id.edEmail);
        edPasswordRe = findViewById(R.id.edPasswordRe);
        btnRegister = findViewById(R.id.btRegister);


        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed(); // Hoặc finish(); để quay lại activity trước đó
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeSharePre();
            }
        });

    }

    private void writeSharePre() {
        String username = edUserNameRe.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String password = edPasswordRe.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("USERNAME_KEY", username);
        editor.putString("EMAIL_KEY", email);
        editor.putString("PASSWORD_KEY", password);
        editor.apply();

        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
        finish();
    }
}