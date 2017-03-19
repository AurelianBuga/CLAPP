package com.example.aurelian.cleanerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BatterySaverScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_saver_screen);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_back, R.anim.slide_out_back);
    }
}
