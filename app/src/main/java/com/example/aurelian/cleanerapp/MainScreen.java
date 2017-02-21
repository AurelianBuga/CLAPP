package com.example.aurelian.cleanerapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static android.R.attr.tint;


public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_main_screen);

        //Initializing the bottomNavigationView
        final BottomNavigationViewEx bottomNavigationView;
        bottomNavigationView = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation);

        //Disable animation of bottomNavigationView
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                //TODO : implement action -> change screen and color
                                break;
                            case R.id.action_all_tools:
                                //TODO : implement action -> change screen and color
                                break;
                            case R.id.action_settings:
                                //TODO : implement action -> change screen and color
                                break;
                        }
                        return true;
                    }
                });

        /*Binding for ViewPager -> swipe screen
        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        bind.vp.setAdapter(adapter);

        // binding with ViewPager
        bind.bnve.setupWithViewPager(bind.vp);*/

    }
}
