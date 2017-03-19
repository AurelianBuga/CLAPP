package com.example.aurelian.cleanerapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import java.lang.reflect.Field;


public class MainScreen extends AppCompatActivity  {

    private CustomScroller customScroller;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_main_screen);

        pager = (ViewPager) findViewById(R.id.ViewPager);
        //to avoid refreshing fragments
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new PageAdapterMainScreen(getSupportFragmentManager()));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayShowHomeEnabled(false);
                actionBar.setDisplayShowTitleEnabled(false);
                LayoutInflater mInflater = LayoutInflater.from(MainScreen.this);

                View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);
                TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
                //mTitleTextView.setText("CLEANER APP");
                if(position == 0)
                    mTitleTextView.setText("CLEANER APP");
                else
                    if(position == 1)
                        mTitleTextView.setText("ALL TOOLS");
                else
                    if(position == 2)
                        mTitleTextView.setText("SETTINGS");

                ImageButton imageButton = (ImageButton) mCustomView
                        .findViewById(R.id.imageButton);
                imageButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainScreen.this, GameBoosterScreen.class);
                        //myIntent.putExtra("key", value); //Optional parameters
                        startActivity(myIntent);
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    }
                });

                actionBar.setCustomView(mCustomView);
                actionBar.setDisplayShowCustomEnabled(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        //Initializing the bottomNavigationView
        final BottomNavigationViewEx bottomNavigationView;
        bottomNavigationView = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation);

        //Binding for ViewPager -> swipe screen
        bottomNavigationView.setupWithViewPager(pager);

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

        setCustomScrollerToViewPager(new LinearOutSlowInInterpolator() , 400);

        /*final ImageButton junkCleanerButton = (ImageButton)findViewById(R.id.JunkCleaner);
        final ImageButton phoneBoosterButton = (ImageButton)findViewById(R.id.PhoneBooster);
        final ImageButton batterySaverButton = (ImageButton)findViewById(R.id.BatterySaver);
        final ImageButton antivirusButton = (ImageButton)findViewById(R.id.Antivirus);

        junkCleanerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(MainScreen.this, JunkCleanerScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainScreen.this.startActivity(myIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        phoneBoosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(MainScreen.this, PhoneBoosterScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainScreen.this.startActivity(myIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        batterySaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(MainScreen.this, BatterySaverScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainScreen.this.startActivity(myIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        antivirusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(MainScreen.this, AntivirusScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainScreen.this.startActivity(myIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });*/



        //draw memory arc
        /*ImageView memoryArc = (ImageView) findViewById(R.id.MemoryArc);
        double percente = 10.0;
        memoryArc.setImageBitmap(getArcBitmap(this , percente , 500 , 500 , 20 , 5 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE , 135.0 , 272.0));
        memoryArc.setAlpha((float)1.0);

        //draw storage arc
        ImageView storageArc = (ImageView) findViewById(R.id.StorageArc);
        percente = 80.0;
        storageArc.setImageBitmap(getArcBitmap(this , percente , 350 , 350 , 10 , 3 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , 220.0));
        storageArc.setAlpha((float)1.0);

        //Draw Cpu Temp Arc
        ImageView cpuTempArc = (ImageView) findViewById(R.id.CpuTempArc);
        percente = 80.0;
        cpuTempArc.setImageBitmap(getArcBitmap(this , percente , 350 , 350 , 10 , 3 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , -220.0));


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("CLEANER APP");

        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO : make action -> go to game booster activity
            }
        });

        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

        //for testing purposes
        /*setPercenteStorageArc(15);
        setPercenteMemoryArc(50);
        setCpuTempArc(34);
        setStorageReport(15.25 , 56.11);
        setMemoryReport(82.44 , 57.45);
        setCpuTempStatus("GOOD");*/


    }

    private Bitmap getArcBitmap(Context context, double percentage , int width , int height ,
                                    int stroke , int padding , int backgroundColor , int arcColor ,
                                     double startAngle , double maxAngle) {

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
        paint.setColor(backgroundColor);

        double endAngle = (maxAngle / 100.0 * percentage);
        canvas.drawArc(arc, (float)startAngle, (float)maxAngle, false, paint);
        //Then draw arc progress with actual value.
        paint.setColor(arcColor);
        canvas.drawArc(arc, (float)startAngle, (float)endAngle, false, paint);

        return  bitmap;
    }

    /*public void setPercenteStorageArc(int percente)
    {
        TextView percenteStorageArc = (TextView) findViewById(R.id.percenteStorageArc);
        percenteStorageArc.setText(String.valueOf(percente));
    }

    public void setPercenteMemoryArc(int percente)
    {
        TextView percenteMemoryArc = (TextView) findViewById(R.id.percenteMemoryArc);
        percenteMemoryArc.setText(String.valueOf(percente));
    }

    public void setCpuTempArc(int temp)
    {
        TextView cpuTempArc = (TextView) findViewById(R.id.cpuTempArc);
        cpuTempArc.setText(String.valueOf(temp));
    }

    public void setStorageReport(double firstParam , double secondParam)
    {
        TextView storageReport = (TextView) findViewById(R.id.storageReport);
        String fullReport = firstParam + "/" + secondParam + "GB";
        storageReport.setText(fullReport);
    }

    public void setMemoryReport(double firstParam , double secondParam)
    {
        TextView memoryReport = (TextView) findViewById(R.id.memoryReport);
        String fullReport = firstParam + "/" + secondParam + "GB";
        memoryReport.setText(fullReport);
    }

    public void setCpuTempStatus(String status)
    {
        TextView cpuTempStatus = (TextView) findViewById(R.id.cpuTempStatus);
        cpuTempStatus.setText(status);
    }*/

    private void setCustomScrollerToViewPager(Interpolator interpolator, int duration) {
        try {
            customScroller = new CustomScroller(this, interpolator, duration);
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(pager, customScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
