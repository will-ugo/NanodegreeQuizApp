package com.example.android.nanodegreequizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {

    public static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        ImageView splash_image = findViewById(R.id.splash_image);
        TextView alcNanodegreeText = findViewById(R.id.alc_nanodegree);
        Typeface alcNanodegreeFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        alcNanodegreeText.setTypeface(alcNanodegreeFont);
        splash_image.setImageResource(R.drawable.android);
        alcNanodegreeText.setText(R.string.alc_splash_screen_text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashScreen.this, Login.class);
                startActivity(splashIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
