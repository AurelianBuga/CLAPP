package com.example.aurelian.cleanerapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

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

        ImageView memoryArc = (ImageView) findViewById(R.id.MemoryArc);
        double percente = 100.0;
        memoryArc.setImageBitmap(getMemoryArcBtm(this , percente));

    }

    private Bitmap getMemoryArcBtm(Context context, double percentage) {

        int width = 400;
        int height = 400;
        int stroke = 30;
        int padding = 5;
        float density = context.getResources().getDisplayMetrics().density;

        //Paint for arc stroke.
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG | Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(stroke);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);

        final RectF arc = new RectF();
        arc.set((stroke/2) + padding, (stroke/2) + padding, width-padding-(stroke/2), height-padding-(stroke/2));

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //First draw full arc as background.
        paint.setColor(Color.argb(75, 255, 255, 255));

        double endAngle = (272.0 / 100.0 * percentage);
        canvas.drawArc(arc, 135, 272, false, paint);
        //Then draw arc progress with actual value.
        paint.setColor(Color.WHITE);
        canvas.drawArc(arc, 135, (float)endAngle, false, paint);

        return  bitmap;
    }
}
