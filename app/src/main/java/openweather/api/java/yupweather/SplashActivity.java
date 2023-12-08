package openweather.api.java.yupweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import openweather.api.java.yupweather.ultility.AndroidNavigation;
import openweather.api.java.yupweather.ultility.Animations;


public class SplashActivity extends AppCompatActivity {

    private ImageView imageViewSun, imageViewCloud;
    private Animations animations;
    private AndroidNavigation androidNavigation;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        androidNavigation = new AndroidNavigation();
        view = getWindow().getDecorView();
        view.setSystemUiVisibility(androidNavigation.settingsSplashNavigation());

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
}