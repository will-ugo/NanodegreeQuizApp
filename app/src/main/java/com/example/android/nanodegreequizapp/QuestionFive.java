package com.example.android.nanodegreequizapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFive extends AppCompatActivity {

    TextView scoreCountText;
    EditText answerText;
    Button continueButtonID;
    TextView yourAnswerID;
    int displayedScore;
    String displayNameFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        TextView roundNumberText = findViewById(R.id.round_number_text);
        TextView slashText = findViewById(R.id.slash_text);
        TextView hundredText = findViewById(R.id.hundred_text);
        TextView questionFiveID = findViewById(R.id.question_five_id);
        TextView questionID = findViewById(R.id.question_id);
        scoreCountText = findViewById(R.id.score_count_text);
        answerText = findViewById(R.id.edittext_answer);
        continueButtonID = findViewById(R.id.continue_button_id);
        yourAnswerID = findViewById(R.id.your_answer_id);

        Typeface roundNumberFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface slashTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface hundredTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionFiveIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface scoreCountTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface continueButtonFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface yourAnswerIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");

        roundNumberText.setTypeface(roundNumberFont);
        slashText.setTypeface(slashTextFont);
        hundredText.setTypeface(hundredTextFont);
        questionFiveID.setTypeface(questionFiveIDFont);
        questionID.setTypeface(questionIDFont);
        answerText.setTypeface(answerTextFont);
        scoreCountText.setTypeface(scoreCountTextFont);
        continueButtonID.setTypeface(continueButtonFont);
        yourAnswerID.setTypeface(yourAnswerIDFont);

        roundNumberText.setText(R.string.round_five_number_text);
        slashText.setText(R.string.slash);
        hundredText.setText(R.string.hundredText);
        questionFiveID.setText(R.string.question_five_id);
        questionID.setText(R.string.question_id_four);
        yourAnswerID.setText(R.string.your_answer_id);
        continueButtonID.setText(R.string.continue_button_id);


        displayedScore = getIntent().getIntExtra("newScore", 0);
        scoreCountText.setText(String.valueOf(displayedScore));

        displayNameFive = getIntent().getStringExtra("displayNameFour");



        continueButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputAnswer = answerText.getText().toString();
                String Answer = "William Shakespeare";
                if (Answer.equals(inputAnswer)) {
                    displayedScore += 20;
                }

                int QFiveUpdatedScore = displayedScore;
                Intent myIntent = new Intent(QuestionFive.this, Summary.class);
                myIntent.putExtra("newScore", QFiveUpdatedScore);
                myIntent.putExtra("displayNameFive", displayNameFive);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        View customToastRoot = inflater.inflate(R.layout.my_toast, null);
        Toast customToast = new Toast(context);
        customToast.setView(customToastRoot);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }
}
