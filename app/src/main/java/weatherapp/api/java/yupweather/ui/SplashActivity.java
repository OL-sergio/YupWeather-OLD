package weatherapp.api.java.yupweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;


import openweather.api.java.yupweather.R;
import weatherapp.api.java.yupweather.utilities.SystemUi;
import weatherapp.api.java.yupweather.utilities.Animations;


public class SplashActivity extends AppCompatActivity {

    private ImageView imageViewSun, imageViewCloud;
    private Animations animations;
    private SystemUi systemUi;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        systemUi = new SystemUi();
        view = getWindow().getDecorView();
        view.setSystemUiVisibility(systemUi.settingsSplashNavigation());



        components();

        animations = new Animations();

        AnimationSet multipleSunAnimationSet = new AnimationSet(true);
        multipleSunAnimationSet.addAnimation(animations.getAnimFade());
        multipleSunAnimationSet.addAnimation(animations.getRotateAnim());
        imageViewSun.startAnimation(multipleSunAnimationSet);

        AnimationSet multipleCloudAnimationSet = new AnimationSet(true);
        multipleCloudAnimationSet.addAnimation(animations.getAnimFade());
        multipleCloudAnimationSet.addAnimation(animations.getMovementAnimation());
        imageViewCloud.startAnimation(multipleCloudAnimationSet);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }

    private void components() {
        imageViewSun =  findViewById(R.id.imageView_sun);
        imageViewCloud = findViewById(R.id.imageView_cloud);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(systemUi.settingsSplashNavigation());
    }
}