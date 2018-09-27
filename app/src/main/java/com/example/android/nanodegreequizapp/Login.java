package com.example.android.nanodegreequizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Login extends AppCompatActivity {

    EditText loginEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView loginNameID = findViewById(R.id.login_name_id);
        Button startButton = findViewById(R.id.start_button);
        loginEditText = findViewById(R.id.login_edittext);
        Typeface loginNameIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface loginEditTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface startButtonFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        loginNameID.setTypeface(loginNameIDFont);
        loginEditText.setTypeface(loginEditTextFont);
        startButton.setTypeface(startButtonFont);

        loginNameID.setText(R.string.login_name_id_text);
        startButton.setText(R.string.start_button_text);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayName = loginEditText.getText().toString();
                Intent myIntent = new Intent(Login.this, QuestionOne.class);
                myIntent.putExtra("displayName", displayName);
                startActivity(myIntent);
            }
        });
    }

}
