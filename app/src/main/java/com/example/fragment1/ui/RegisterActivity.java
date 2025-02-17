package com.example.fragment1.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment1.R;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserNameRe, edEmail;
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
        btnRegister = findViewById(R.id.btRegister);

        writeSharePre();


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

            }
        });

    }

    private void writeSharePre() {
        // Lấy dữ liệu từ EditText
        String username = edUserNameRe.getText().toString();
        String email = edEmail.getText().toString();

        // Lưu vào SharedPreferences với tên cụ thể
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("USERNAME_KEY", username);
        editor.putString("EMAIL_KEY", email);
        editor.apply(); // Hoặc editor.commit();
    }
}