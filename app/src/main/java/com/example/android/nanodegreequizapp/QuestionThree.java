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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {

    RadioButton answer_one;
    RadioButton answer_two;
    RadioButton answer_three;
    RadioButton answer_four;
    TextView scoreCountText;
    int displayedScore;
    String displayNameThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        TextView roundNumberText = findViewById(R.id.round_number_text);
        TextView slashText = findViewById(R.id.slash_text);
        TextView hundredText = findViewById(R.id.hundred_text);
        TextView questionThreeID = findViewById(R.id.question_three_id);
        TextView questionID = findViewById(R.id.question_id);
        scoreCountText = findViewById(R.id.score_count_text);
        answer_one = findViewById(R.id.answer_one);
        answer_two = findViewById(R.id.answer_two);
        answer_three = findViewById(R.id.answer_three);
        answer_four = findViewById(R.id.answer_four);

        Typeface roundNumberFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface slashTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface hundredTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionThreeIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface questionIDFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerOneFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerTwoFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerThreeFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface answerFourFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");
        Typeface scoreCountTextFont = Typeface.createFromAsset(this.getAssets(), "fonts/SF New Republic.ttf");

        roundNumberText.setTypeface(roundNumberFont);
        slashText.setTypeface(slashTextFont);
        hundredText.setTypeface(hundredTextFont);
        questionThreeID.setTypeface(questionThreeIDFont);
        questionID.setTypeface(questionIDFont);
        answer_one.setTypeface(answerOneFont);
        answer_two.setTypeface(answerTwoFont);
        answer_three.setTypeface(answerThreeFont);
        answer_four.setTypeface(answerFourFont);
        scoreCountText.setTypeface(scoreCountTextFont);

        roundNumberText.setText(R.string.round_three_number_text);
        slashText.setText(R.string.slash);
        hundredText.setText(R.string.hundredText);
        questionThreeID.setText(R.string.question_three_id);
        questionID.setText(R.string.question_id_three);
        answer_one.setText(R.string.question_three_answer_one);
        answer_two.setText(R.string.question_three_answer_two);
        answer_three.setText(R.string.question_three_answer_three);
        answer_four.setText(R.string.question_three_answer_four);

        displayedScore = getIntent().getIntExtra("newScore", 0);
        scoreCountText.setText(String.valueOf(displayedScore));

        displayNameThree = getIntent().getStringExtra("displayNameTwo");

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer_one.setBackgroundResource(R.color.fail_color);
                answer_one.setTextColor(getResources().getColor(R.color.white));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        answer_one.setBackgroundResource(R.color.white);
                        answer_one.setTextColor(getResources().getColor(R.color.text_color));
                    }
                }, 1000);

                int QThreeNormalScoreOne = displayedScore;
                Intent myIntent = new Intent(QuestionThree.this, QuestionFour.class);
                myIntent.putExtra("newScore", QThreeNormalScoreOne);
                myIntent.putExtra("displayNameThree", displayNameThree);
                startActivity(myIntent);
            }
        });

        answer_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer_two.setBackgroundResource(R.color.fail_color);
                answer_two.setTextColor(getResources().getColor(R.color.white));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        answer_two.setBackgroundResource(R.color.white);
                        answer_two.setTextColor(getResources().getColor(R.color.text_color));
                    }
                }, 1000);

                int QThreeUpdatedScore = displayedScore;
                Intent myIntent = new Intent(QuestionThree.this, QuestionFour.class);
                myIntent.putExtra("newScore", QThreeUpdatedScore);
                myIntent.putExtra("displayNameThree", displayNameThree);
                startActivity(myIntent);
            }
        });

        answer_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer_three.setBackgroundResource(R.color.pass_color);
                answer_three.setTextColor(getResources().getColor(R.color.white));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        answer_three.setBackgroundResource(R.color.white);
                        answer_three.setTextColor(getResources().getColor(R.color.text_color));
                    }
                }, 1000);

                int QThreeNormalScoreThree = displayedScore + 20;
                Intent myIntent = new Intent(QuestionThree.this, QuestionFour.class);
                myIntent.putExtra("newScore", QThreeNormalScoreThree);
                myIntent.putExtra("displayNameThree", displayNameThree);
                startActivity(myIntent);
            }
        });

        answer_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer_four.setBackgroundResource(R.color.fail_color);
                answer_four.setTextColor(getResources().getColor(R.color.white));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        answer_four.setBackgroundResource(R.color.white);
                        answer_four.setTextColor(getResources().getColor(R.color.text_color));
                    }
                }, 1000);

                int QThreeNormalScore = displayedScore;
                Intent myIntent = new Intent(QuestionThree.this, QuestionFour.class);
                myIntent.putExtra("newScore", QThreeNormalScore);
                myIntent.putExtra("displayNameThree", displayNameThree);
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
