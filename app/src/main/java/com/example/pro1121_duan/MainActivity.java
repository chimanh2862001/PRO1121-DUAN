package com.example.pro1121_duan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_Nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentTimKiemActivity()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()){
                case R.id.nav_timkiem:
                    fragment = new FragmentTimKiemActivity();
                    break;
                case R.id.nav_oghep:
                    fragment = new FragmentOGhepActivity();
                    break;
                case R.id.nav_profile:
                    fragment = new FragmentProfileActivity();
                    break;
                case R.id.nav_save:
                    fragment = new FragmentLuuActivity();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
            return true;
        }
    };
}