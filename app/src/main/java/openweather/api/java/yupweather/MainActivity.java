package openweather.api.java.yupweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import openweather.api.java.yupweather.ultility.AndroidNavigation;
import openweather.api.java.yupweather.ultility.CustomAlertDialog;
import openweather.api.java.yupweather.ultility.GPSTracker;

public class MainActivity extends AppCompatActivity {

    private AndroidNavigation androidNavigation;
    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidNavigation = new AndroidNavigation();

        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(androidNavigation.settingsMainNavigation());

        Toolbar toolbarMain  =  findViewById(R.id.toolbar);
        toolbarMain.setTitle("WhatApp");
        setSupportActionBar(toolbarMain);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getLocation() {
        gpsTracker = new GPSTracker(MainActivity.this);
        if (gpsTracker.statLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();

            Log.d("location lat", String.valueOf(latitude));
            Log.d("location long", String.valueOf(longitude));

            gpsTracker.stopUsingGPS();

        } else {

            CustomAlertDialog.setGpsSettings(this, "GPS settings", "GPS is not enabled. Do you want to go to settings menu?");

           //CustomAlertDialog.setNetworkSettings(this, "Network settings", "Network is not enabled. Do you want to go to settings menu?");

        }
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

                getLocation();

                return true;

            case R.id.menuItem_searchLocation:

                Log.d("Data: ","search");
                return true;

            default:
            return super.onOptionsItemSelected(item);
        }
    }
}