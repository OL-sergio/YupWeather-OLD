package weatherapp.api.java.yupweather.ui;

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


import openweather.api.java.yupweather.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weatherapp.api.java.yupweather.database.SharedPreferenceLocation;
import weatherapp.api.java.yupweather.database.api.APIClient;
import weatherapp.api.java.yupweather.database.api.DataService;
import weatherapp.api.java.yupweather.model.WeatherDay;
import weatherapp.api.java.yupweather.utilities.Constants;
import weatherapp.api.java.yupweather.utilities.SystemUi;
import weatherapp.api.java.yupweather.utilities.CustomAlertDialog;
import weatherapp.api.java.yupweather.utilities.GPSTracker;

public class MainActivity extends AppCompatActivity {

    private SystemUi systemUi;
    private GPSTracker gpsTracker;

    private DataService dataService;
    private Call<WeatherDay> dayCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        systemUi = new SystemUi();

        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(systemUi.settingsMainNavigation());

        Toolbar toolbarMain  =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbarMain);

        try {

            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, Constants.requestCode);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        String latitude = SharedPreferenceLocation.getLatitudeLocation(getApplicationContext());
        String longitude = SharedPreferenceLocation.getLongitudeLocation(getApplicationContext());

        dataService = APIClient.getInstance().create(DataService.class);
        dayCall = dataService.getDayWeather(latitude,longitude, Constants.API_KEY);

        dayCall.enqueue(new Callback<WeatherDay>() {
            @Override
            public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                Log.d("retrofitResponse: ", String.valueOf(response.code()));
                Log.d("retrofitResponse: ", response.message());
                
                
            }

            @Override
            public void onFailure(Call<WeatherDay> call, Throwable t) {
                Log.d("retrofitResponseFailure: ", t.getMessage());
            }
        });


        getAPIConnection();
        
    }

    private void getAPIConnection() {



    }

    private void getLocation() {
        gpsTracker = new GPSTracker(MainActivity.this);
        if (gpsTracker.statLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();

            Log.d("location lat", String.valueOf(latitude));
            Log.d("location long", String.valueOf(longitude));

            gpsTracker.stopUsingGPS();

            SharedPreferenceLocation.setLocation(
                    getApplicationContext(),
                    String.valueOf(longitude),
                    String.valueOf(latitude)
            );

            String shareLatitude = SharedPreferenceLocation.getLatitudeLocation(getApplicationContext());
            Log.d("shareLatitude", shareLatitude);

            String shareLongitude = SharedPreferenceLocation.getLongitudeLocation(getApplicationContext());
            Log.d("shareLongitude", shareLongitude);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(systemUi.settingsSplashNavigation());
    }
}