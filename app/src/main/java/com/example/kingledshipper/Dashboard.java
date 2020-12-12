package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottom_116;
    ViewPager viewPager_dashboard_116;
    TabLayout tabLayout_dashboard_116;
    FragmentAdapterDashboard fragmentAdapterDashboard_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Startup();
        LoadViewPager();
        EventMenuBottom();
    }

    private void EventMenuBottom() {
        bottom_116.setSelectedItemId(R.id.dashboard);
        bottom_116.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        return true;
                    case R.id.congty:
                        startActivity(new Intent(getApplicationContext(),CacCongTy.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void LoadViewPager() {
        fragmentAdapterDashboard_116 = new FragmentAdapterDashboard(getSupportFragmentManager());
        viewPager_dashboard_116.setAdapter(fragmentAdapterDashboard_116);
        tabLayout_dashboard_116.setupWithViewPager(viewPager_dashboard_116);
    }

    private void Startup() {
        viewPager_dashboard_116 = (ViewPager)findViewById(R.id.viewpager_dashboard_116);
        tabLayout_dashboard_116 = (TabLayout)findViewById(R.id.tabs_dashboard_116);
        bottom_116 = (BottomNavigationView)findViewById(R.id.bottomnavigation_dashboard);
    }

}