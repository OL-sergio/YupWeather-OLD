package openweather.api.java.yupweather;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {

    ImageView imageViewSun, imageViewCloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageViewSun =  findViewById(R.id.imageView_sun);
        imageViewCloud = findViewById(R.id.imageView_cloud);

        RotateAnimation animIconRotation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animIconRotation.setDuration(15000);
        animIconRotation.setInterpolator(new LinearInterpolator());

        Animation animIconFade = new AlphaAnimation(0.0f, 1.0f);
        animIconFade.setDuration(3000);
        animIconFade.setStartOffset(500);


        AnimationSet multipleIconAnimationSet = new AnimationSet(true);
        multipleIconAnimationSet.addAnimation(animIconFade);
        multipleIconAnimationSet.addAnimation(animIconRotation);
        imageViewSun.startAnimation(multipleIconAnimationSet);
        imageViewCloud.startAnimation(animIconFade);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        },5000);

    }
}