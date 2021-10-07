package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MusicActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager mViewPager;
    private int id_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

       navigationView = findViewById(R.id.nav_bottom);
       mViewPager = findViewById(R.id.viewPager);
        setViewPager();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_user:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_title:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_Browser:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_ForYou:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.nav_Radio:
                        mViewPager.setCurrentItem(4);
                        break;

                }
                return true;
            }
        });
    }
    private  void setViewPager(){
        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewAdapter);
    }

}