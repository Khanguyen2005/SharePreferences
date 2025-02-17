package com.example.fragment1.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fragment1.MainActivity;
import com.example.fragment1.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editUser, editPass;
    private Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        addControl();

        // Xử lý sự kiện đăng nhập
        btnLogin.setOnClickListener(view -> {
            String username = editUser.getText().toString().trim();
            String password = editPass.getText().toString().trim();

            // Đọc dữ liệu từ SharedPreferences
            SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String savedUsername = sharedPref.getString("USERNAME_KEY", "");
            String savedPassword = sharedPref.getString("PASSWORD_KEY", "");

            // Kiểm tra thông tin đăng nhập
            if (username.equals(savedUsername) && password.equals(savedPassword)) {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();
            }
        });

        // Xử lý sự kiện chuyển đến RegisterActivity
        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void addControl() {
        editUser = findViewById(R.id.edtUserName);
        editPass = findViewById(R.id.edtPass);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
    }

    boolean checkUserName (String username) {
        if (username.isEmpty()) {
            editUser.setError("Vui lòng nhập");
            return false;
        }
        return true;
    }

    boolean checkPassword (String password) {
        if (password.isEmpty()) {
            editPass.setError("Vui lòng nhập");
            return false;
        }
        return true;
    }
}