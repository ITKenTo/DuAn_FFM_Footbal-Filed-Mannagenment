package com.example.ffm_footbal_field_managenment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ffm_footbal_field_managenment.R;
import com.example.ffm_footbal_field_managenment.Fragment.AccountAdminFragment;
import com.example.ffm_footbal_field_managenment.Fragment.SupportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.system_accent1_300)));

        BottomNavigationView nav_botton= findViewById(R.id.botonadmin);
        getSupportFragmentManager().beginTransaction().replace(R.id.framgeradmin,new AccountAdminFragment()).commit();


        nav_botton.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btt_account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framgeradmin,new AccountAdminFragment()).commit();
                        return true;
                    case R.id.btt_support_admin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framgeradmin,new SupportFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}