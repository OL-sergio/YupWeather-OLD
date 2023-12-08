package openweather.api.java.yupweather;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

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

    }

}