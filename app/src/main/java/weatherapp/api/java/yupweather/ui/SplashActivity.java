package weatherapp.api.java.yupweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import openweather.api.java.yupweather.databinding.ActivitySplashBinding;
import weatherapp.api.java.yupweather.utilities.SystemUi;
import weatherapp.api.java.yupweather.utilities.Animations;


public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    private ImageView imageViewSun, imageViewCloud;
    private SystemUi systemUi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        systemUi = new SystemUi();
        view.setSystemUiVisibility(systemUi.settingsSplashNavigation());

        components();

        Animations animations = new Animations();

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
        imageViewSun =  binding.imageViewSun;
        imageViewCloud = binding.imageViewCloud;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(systemUi.settingsSplashNavigation());
    }
}