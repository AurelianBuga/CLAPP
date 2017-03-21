package com.example.aurelian.cleanerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Aurelian on 3/15/2017.
 */

public class Fragment3_SettingsScreen extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        if(container == null)
            return null;

        setHasOptionsMenu(true);

        //to avoid refreshing fragments
        setRetainInstance(true);



        return inflater.inflate(R.layout.fragment3_settings_screen, container , false);
    }
}
