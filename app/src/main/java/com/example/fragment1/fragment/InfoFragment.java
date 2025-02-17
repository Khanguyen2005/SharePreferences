package com.example.fragment1.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment1.R;

public class InfoFragment extends Fragment {

    private TextView txtUserName, txtEmail;  // Dùng biến class để quản lý View

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout cho Fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Ánh xạ các TextView
        txtUserName = view.findViewById(R.id.txtUserName);
        txtEmail = view.findViewById(R.id.txtEmail);

        // Đọc dữ liệu từ SharedPreferences (từ file "MyPrefs")
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPref.getString("USERNAME_KEY", "Chưa có dữ liệu");
        String email = sharedPref.getString("EMAIL_KEY", "Chưa có dữ liệu");

        // Gán dữ liệu vào TextView, đảm bảo đúng format giống ảnh mẫu
        txtUserName.setText("User name: " + username);
        txtEmail.setText("Email: " + email);

        // Ghi log để kiểm tra dữ liệu
        Log.d("SharedPreferences", "USERNAME_KEY: " + username);
        Log.d("SharedPreferences", "EMAIL_KEY: " + email);
    }
}
