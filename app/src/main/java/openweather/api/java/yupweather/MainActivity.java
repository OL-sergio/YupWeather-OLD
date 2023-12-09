package openweather.api.java.yupweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;


import com.ogaclejapan.smarttablayout.SmartTabLayout;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import openweather.api.java.yupweather.ultility.AndroidNavigation;

public class MainActivity extends AppCompatActivity {

    private AndroidNavigation androidNavigation;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidNavigation = new AndroidNavigation();

        view = getWindow().getDecorView();
        view.setSystemUiVisibility(androidNavigation.settingsMainNavigation());

        Toolbar toolbarMain  =  findViewById(R.id.toolbar);
        toolbarMain.setTitle("WhatApp");
        setSupportActionBar(toolbarMain);


    }

}