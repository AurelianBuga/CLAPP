package com.example.aurelian.cleanerapp;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.constraint.ConstraintLayout;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.aurelian.cleanerapp.R.id.cpuTempArc;

/**
 * Created by Aurelian on 3/15/2017.
 */

//locul 5 dus
//locul 5 intors

public class Fragment1_HomeScreen extends Fragment {
    private View view;
    private double memoryPercente;
    private double storagePercente;
    private double cpuTempPercente;

    private long usedStorage;
    private long totalStorage;

    private ImageView memoryArc;
    private ImageView storageArc;
    private ImageView cpuTempArc;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        if(container == null)
            return null;

        //to avoid refreshing fragments
        setRetainInstance(true);

        view = inflater.inflate(R.layout.fragment1_home_screen , container , false);

        final ImageButton junkCleanerButton = (ImageButton)view.findViewById(R.id.JunkCleaner);
        final ImageButton phoneBoosterButton = (ImageButton)view.findViewById(R.id.PhoneBooster);
        final ImageButton batterySaverButton = (ImageButton)view.findViewById(R.id.BatterySaver);
        final ImageButton antivirusButton = (ImageButton)view.findViewById(R.id.Antivirus);

        junkCleanerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(getActivity(), JunkCleanerScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                Bundle bundle = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.slide_in, R.anim.slide_out).toBundle();
                getActivity().startActivity(myIntent );
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        phoneBoosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(getActivity(), PhoneBoosterScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                getActivity().startActivity(myIntent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        batterySaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(getActivity(), BatterySaverScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                getActivity().startActivity(myIntent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        antivirusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(MainScreen.this, R.anim.main_screen_anim_onclick));
                Intent myIntent = new Intent(getActivity(), AntivirusScreen.class);
                //myIntent.putExtra("key", value); //Optional parameters
                getActivity().startActivity(myIntent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        SetMemoryPercente(50.0);
        SetStoragePercente(50.0);
        SetCpuTempPercente(50.0);

        //draw memory arc
        memoryArc = (ImageView) view.findViewById(R.id.MemoryArc);
        memoryArc.setImageBitmap(getArcBitmap(getActivity() , ((memoryPercente - 20.0) > 0.0)? (memoryPercente - 20.0) : 0 , 500 , 500 , 20 , 5 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE , 135.0 , 272.0));
        memoryArc.setAlpha((float)1.0);

        //draw storage arc
        storageArc = (ImageView) view.findViewById(R.id.StorageArc);
        storageArc.setImageBitmap(getArcBitmap(getActivity() , ((storagePercente - 20.0) > 0.0)? (storagePercente - 20.0) : 0 , 350 , 350 , 10 , 3 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , 220.0));
        storageArc.setAlpha((float)1.0);

        //Draw Cpu Temp Arc
        cpuTempArc = (ImageView) view.findViewById(R.id.CpuTempArc);
        cpuTempArc.setImageBitmap(getArcBitmap(getActivity() , ((cpuTempPercente - 20.0) > 0.0)? (cpuTempPercente - 20.0) : 0 , 350 , 350 , 10 , 3 ,
                Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , -220.0));

        usedStorage = StorageManager.phone_storage_used();
        totalStorage = StorageManager.phone_storage_total();

        /*ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());

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
        actionBar.setDisplayShowCustomEnabled(true);*/

        //for testing purposes
        /*setPercenteStorageArc(15);
        setPercenteMemoryArc(50);
        setCpuTempArc(34);
        setStorageReport(15.25 , 56.11);
        setMemoryReport(82.44 , 57.45);
        setCpuTempStatus("GOOD");*/

        return view;
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

    public void setPercenteStorageArc(int percente)
    {
        TextView percenteStorageArc = (TextView) view.findViewById(R.id.percenteStorageArc);
        percenteStorageArc.setText(String.valueOf(percente));
    }

    public void setPercenteMemoryArc(int percente)
    {
        TextView percenteMemoryArc = (TextView) view.findViewById(R.id.percenteMemoryArc);
        percenteMemoryArc.setText(String.valueOf(percente));
    }

    public void setCpuTempArc(int temp)
    {
        TextView cpuTempArc = (TextView) view.findViewById(R.id.cpuTempArc);
        cpuTempArc.setText(String.valueOf(temp));
    }

    public void setStorageReport(double firstParam , double secondParam)
    {
        TextView storageReport = (TextView) view.findViewById(R.id.storageReport);
        String fullReport = firstParam + "/" + secondParam + "GB";
        storageReport.setText(fullReport);
    }

    public void setMemoryReport(double firstParam , double secondParam)
    {
        TextView memoryReport = (TextView) view.findViewById(R.id.memoryReport);
        String fullReport = firstParam + "/" + secondParam + "GB";
        memoryReport.setText(fullReport);
    }

    public void setCpuTempStatus(String status)
    {
        TextView cpuTempStatus = (TextView) view.findViewById(R.id.cpuTempStatus);
        cpuTempStatus.setText(status);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            private double tmpPercenteMem = ((memoryPercente - 10.0) > 0.0)? (memoryPercente - 10.0) : 0;
            private double tmpPercenteStorage = ((storagePercente - 10.0) > 0.0)? (storagePercente - 10.0) : 0 ;
            private double tmpPercenteCpuTemp = ((cpuTempPercente - 10.0) > 0.0)? (cpuTempPercente - 10.0) : 0 ;
            private int drawingCaseMem = 0;
            private int drawingCaseStorage = 0;
            private int drawingCaseCpuTemp = 0;

            public void run() {

                switch (drawingCaseMem){
                    case 0:
                    {
                        if(tmpPercenteMem < memoryPercente + 5)
                        {
                            memoryArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteMem , 500 , 500 , 20 , 5 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE , 135.0 , 272.0));
                            setPercenteMemoryArc((int)tmpPercenteMem);
                            tmpPercenteMem += 1.0;
                        }
                        else
                            drawingCaseMem = 1;

                        break;
                    }

                    case 1:
                    {
                        if(tmpPercenteMem >= memoryPercente)
                        {
                            memoryArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteMem , 500 , 500 , 20 , 5 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE , 135.0 , 272.0));
                            setPercenteMemoryArc((int)tmpPercenteMem);
                            tmpPercenteMem -= 1.0;
                        }
                        else
                            drawingCaseMem = 2;

                        break;
                    }

                    case 2:
                    {
                        break;
                    }

                }

                switch (drawingCaseStorage)
                {
                    case 0:
                    {
                        if(tmpPercenteStorage < storagePercente + 5)
                        {
                            storageArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteStorage , 350 , 350 , 10 , 3 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , 220.0));
                            setPercenteStorageArc((int)tmpPercenteStorage);
                            tmpPercenteStorage += 1.0;
                        }
                        else
                            drawingCaseStorage = 1;

                        break;
                    }
                    case 1:
                    {
                        if(tmpPercenteStorage >= storagePercente )
                        {
                            storageArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteStorage , 350 , 350 , 10 , 3 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , 220.0));
                            setPercenteStorageArc((int)tmpPercenteStorage);
                            tmpPercenteStorage -= 1.0;
                        }
                        else
                            drawingCaseStorage = 2;

                        break;
                    }
                    case 2:
                    {
                        break;
                    }
                }

                switch (drawingCaseCpuTemp)
                {
                    case 0:
                    {
                        if(tmpPercenteCpuTemp < cpuTempPercente + 5)
                        {
                            cpuTempArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteCpuTemp , 350 , 350 , 10 , 3 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , -220.0));
                            setCpuTempArc((int)tmpPercenteCpuTemp);
                            tmpPercenteCpuTemp += 1.0;
                        }
                        else
                            drawingCaseCpuTemp = 1;

                        break;
                    }
                    case 1:
                    {
                        if(tmpPercenteCpuTemp >= cpuTempPercente)
                        {
                            cpuTempArc.setImageBitmap(getArcBitmap(getActivity() , tmpPercenteCpuTemp , 350 , 350 , 10 , 3 ,
                                    Color.argb(255, 100, 211, 219) , Color.WHITE  , 90.0 , -220.0));
                            setCpuTempArc((int)tmpPercenteCpuTemp);
                            tmpPercenteCpuTemp -= 1.0;
                        }
                        else
                            drawingCaseCpuTemp = 2;

                        break;
                    }

                    case 2:
                    {
                        break;
                    }
                }

                handler.postDelayed(this, 1);
            }
        };

        handler.postDelayed(r, 0);
    }

    public void SetMemoryPercente(double memoryPercente)
    {
        this.memoryPercente = memoryPercente;
    }

    public void SetStoragePercente(double storagePercente)
    {
        this.storagePercente = storagePercente;
    }
    public void SetCpuTempPercente(double cpuTempPercente)
    {
        this.cpuTempPercente = cpuTempPercente;
    }
}
