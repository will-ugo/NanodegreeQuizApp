package com.example.android.nanodegreequizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Summary extends AppCompatActivity {

    ImageView loginDisplayPicture;
    public static final int IMAGE_GALLERY_REQUEST = 20;
    String summaryDisplayName;
    int summaryDisplayScore;
    TextView summaryNameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summaryNameID = findViewById(R.id.summary_name_id);
        loginDisplayPicture = findViewById(R.id.login_display_picture);
        TextView summarySentenceText = findViewById(R.id.summary_sentence_text);
        TextView summaryScore = findViewById(R.id.summary_score);
        TextView summarySlashHundred = findViewById(R.id.summary_slash_hundred);
        Button displayPicButton = findViewById(R.id.display_pic_button);
        Button emailButtonPic = findViewById(R.id.email_pic_button);

        Typeface summaryNameIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface summarySentenceTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface summaryScoreFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface summarySlashHundredFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface displayPicButtonFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface emailButtonPicFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");

        summaryNameID.setTypeface(summaryNameIDFont);
        summarySentenceText.setTypeface(summarySentenceTextFont);
        summaryScore.setTypeface(summaryScoreFont);
        summarySlashHundred.setTypeface(summarySlashHundredFont);
        displayPicButton.setTypeface(displayPicButtonFont);
        emailButtonPic.setTypeface(emailButtonPicFont);

        displayPicButton.setText(R.string.display_pic_button_text);
        summaryNameID.setText(R.string.login_name_id_text);
        summarySentenceText.setText(R.string.summary_score_text);
        summarySlashHundred.setText(R.string.slash_hundred_text);
        emailButtonPic.setText(R.string.email_button_mail_text);

        summaryDisplayName = getIntent().getStringExtra("displayNameFive");
        summaryDisplayScore = getIntent().getIntExtra("newScore", 0);

        summaryNameID.setText(summaryDisplayName);
        summaryScore.setText(String.valueOf(summaryDisplayScore));

        emailButtonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailBody = "Name: " + summaryDisplayName + "\nNarration: You score is " + summaryDisplayScore + " out of 100." +
                        "\nThank You!";

                Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
                mailIntent.setData(Uri.parse("mailto:"));
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nanodegree Quiz App Score for " + summaryDisplayName);
                mailIntent.putExtra(Intent.EXTRA_TEXT, mailBody);
                if (mailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mailIntent);
                }
            }
        });

        displayPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();

                Uri data = Uri.parse(pictureDirectoryPath);

                photoPickerIntent.setDataAndType(data, "image/*");

                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_GALLERY_REQUEST) {
                Uri imageUri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    loginDisplayPicture.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, R.string.toast_string, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
