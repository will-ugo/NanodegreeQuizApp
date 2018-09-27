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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFour extends AppCompatActivity {

    CheckBox answer_one;
    CheckBox answer_two;
    CheckBox answer_three;
    CheckBox answer_four;
    TextView scoreCountText;
    String displayNameFour;
    Button continueButton;
    int displayedScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        TextView roundNumberText = findViewById(R.id.round_number_text);
        TextView slashText = findViewById(R.id.slash_text);
        TextView hundredText = findViewById(R.id.hundred_text);
        TextView questionFourID = findViewById(R.id.question_four_id);
        TextView questionID = findViewById(R.id.question_id);
        scoreCountText = findViewById(R.id.score_count_text);
        answer_one = findViewById(R.id.answer_one);
        answer_two = findViewById(R.id.answer_two);
        answer_three = findViewById(R.id.answer_three);
        answer_four = findViewById(R.id.answer_four);
        continueButton = findViewById(R.id.continue_button_id);

        Typeface roundNumberFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface slashTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface hundredTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionFourIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerOneFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerTwoFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerThreeFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerFourFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface scoreCountTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface continueButtonFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");

        roundNumberText.setTypeface(roundNumberFont);
        slashText.setTypeface(slashTextFont);
        hundredText.setTypeface(hundredTextFont);
        questionFourID.setTypeface(questionFourIDFont);
        questionID.setTypeface(questionIDFont);
        answer_one.setTypeface(answerOneFont);
        answer_two.setTypeface(answerTwoFont);
        answer_three.setTypeface(answerThreeFont);
        answer_four.setTypeface(answerFourFont);
        scoreCountText.setTypeface(scoreCountTextFont);
        continueButton.setTypeface(continueButtonFont);

        roundNumberText.setText(R.string.round_four_number_text);
        slashText.setText(R.string.slash);
        hundredText.setText(R.string.hundredText);
        questionFourID.setText(R.string.question_four_id);
        questionID.setText(R.string.question_id_four);
        answer_one.setText(R.string.question_four_answer_one);
        answer_two.setText(R.string.question_four_answer_two);
        answer_three.setText(R.string.question_four_answer_three);
        answer_four.setText(R.string.question_four_answer_four);
        continueButton.setText(R.string.continue_button_id);

        displayedScore = getIntent().getIntExtra("newScore", 0);
        scoreCountText.setText(String.valueOf(displayedScore));

        displayNameFour = getIntent().getStringExtra("displayNameThree");



        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (answer_one.isChecked() && answer_four.isChecked()) {
                    displayedScore += 20;
                }

                int QFourUpdatedScore = displayedScore;
                Intent myIntent = new Intent(QuestionFour.this, QuestionFive.class);
                myIntent.putExtra("newScore", QFourUpdatedScore);
                myIntent.putExtra("displayNameFour", displayNameFour);
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

