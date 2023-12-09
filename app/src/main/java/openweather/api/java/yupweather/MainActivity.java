package openweather.api.java.yupweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuItem_gpsLocation :
                Log.d("Data: ","gps");
                return true;

            case R.id.menuItem_searchLocation:
                Log.d("Data: ","search");
                return true;

            default:
            return super.onOptionsItemSelected(item);
        }
    }
}