package com.example.fragment1;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment1.fragment.HomeFragment;
import com.example.fragment1.fragment.InfoFragment;
import com.example.fragment1.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottommenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottommenu = findViewById(R.id.navMenu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("main");
        actionBar.setDisplayHomeAsUpEnabled(true); // Luôn hiển thị nút back

        //load fragment
        bottommenu.setOnItemSelectedListener(getListener());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return true;
    }

    public void loadFragment(Fragment fmNew) {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
    @NonNull
    private  NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mnHome){
                    loadFragment(new HomeFragment());
                }
                else if(item.getItemId() == R.id.mnInfo){
                    loadFragment(new InfoFragment());
                }
                else if(item.getItemId() == R.id.mnSetting){
                    loadFragment(new SettingFragment());
                }
                return true;
            }
        };
    }



}