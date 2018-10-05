package com.example.tl00456.arithemticchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class GameActivity extends AppCompatActivity {
    private Button[] mChoice = new Button[3];
    private Button mMenu;
    private TextView mQuestionText, mScoreText, mHighScoreText;
    private ProgressBar mProgressBar;
    private ArithmeticChallenge game;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setViewObjects();
    }

    /************************************************************************
     *  Chooses type of game and then links screen objects to
     *  this class' fields.  Declares current high score.
     ************************************************************************/
    private void setViewObjects(){
        // Get data from Main Activity ************************************************
        Intent intent = getIntent();
        String operation = intent.getStringExtra("Operation");

        // Use data to set game object to current game ********************************
        if(operation.equals("addition"))
            game = new Addition(1,10); // you may change parameters
        if(operation.equals("subtraction"))
            game = new Subtraction(1,10); // you may change parameters
        if(operation.equals("multiplication"))
            game = new Multiplication(1,10); // you may change parameters
        if(operation.equals("division"))
            game = new Division(1,10); // you may change parameters

        // Assign screen objects to fields ********************************************
        mQuestionText = findViewById(R.id.textView_question);
        mProgressBar = findViewById(R.id.progressBar2);
        mScoreText = findViewById(R.id.textView_your_score);
        mHighScoreText = findViewById(R.id.textView_high_score);
        mChoice[0] = findViewById(R.id.button_option1);
        mChoice[1] = findViewById(R.id.button_option2);
        mChoice[2] = findViewById(R.id.button_option3);
        mMenu = findViewById(R.id.button_back_to_menu);
        retrieveHighScore(operation);
        listenForClicks(true);
    }

    /************************************************************************
     *  Displays question on view and listens for answer
     ************************************************************************/
    private void listenForClicks(boolean newQuestion){
        if(newQuestion)
            game.setQuestionText(game.createQuestion());
        mQuestionText.setText(game.getQuestionText());
        game.setChoices(game.createChoices());


        // ****** sets choices to view ************************************************
        for(int index = 0; index < 3; index++){
            final int innerIndex = index;
            mChoice[index].setText(game.getChoice(index));
            // ****** listens for user input ******************************************
            mChoice[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    setScoreTextAndProgressBar(game.isCorrect(innerIndex));
                }
            });
        }
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                System.exit(0);
            }
        });
    }

    /************************************************************************
     *  Grades answer and updates score and progress.
     ************************************************************************/
    private void setScoreTextAndProgressBar(boolean isCorrect){
        int messageResID = (isCorrect) ? R.string.correct_toast : R.string.incorrect_toast;
        Toast correct = Toast.makeText(GameActivity.this,messageResID,Toast.LENGTH_SHORT);
        correct.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 320);
        correct.show();
        game.setScore(isCorrect);
        String scoreText = "Score: " + Integer.toString(game.getScore());
        mScoreText.setText(scoreText);
        updateHighScore();
        game.setProgress();
        mProgressBar.setProgress(game.getProgress());
        if(game.getProgress() >= 100) //Maximum progress is 100
            endGame();
        else
            listenForClicks(isCorrect);
    }

    /************************************************************************
     * Ends game or starts next round.
     ************************************************************************/
    private void endGame(){
        mQuestionText.setText(R.string.win_text);
        for(int index = 0; index < 3; index++)
            mChoice[index].setText("");
        mMenu.setText(R.string.next_button);
    }

    protected void retrieveHighScore(String operation) {
        // to be implemented

    }

    protected void updateHighScore() {
        // to be implemented

    }
}


