package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.health.HealthFragment;
import com.example.myapplication.share.ShareFragment;
import com.example.myapplication.star1.Star1Fragment;
import com.example.myapplication.star2.Star2Fragment;
import com.example.myapplication.star3.Star3Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_star1) {
                    selectedFragment = new Star1Fragment();
                } else if (itemId == R.id.navigation_star2) {
                    selectedFragment = new Star2Fragment();
                } else if (itemId == R.id.navigation_star3) {
                    selectedFragment = new Star3Fragment();
                } else if (itemId == R.id.navigation_share) {
                    selectedFragment = new ShareFragment();
                } else if (itemId == R.id.navigation_health) {
                    selectedFragment = new HealthFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return true;
            }
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Star1Fragment()).commit();
        }
    }
}// commit text
