package com.example.aurelian.cleanerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Aurelian on 3/15/2017.
 */

public class Fragment2_AllToolsScreen extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        if(container == null)
            return null;

        //to avoid refreshing fragments
        setRetainInstance(true);

        return inflater.inflate(R.layout.fragment2_all_tools_screen , container , false);
    }

}
