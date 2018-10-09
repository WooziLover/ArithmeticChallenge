package com.example.tl00456.arithemticchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;
import android.widget.RadioButton;

/***********************************************************************
 * Description: This is the controller of the main activity to react
 *              user activities.
 *
 * @author Tristyn Lai
 * @version September 12, 2018 2:00
 ***********************************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenForUserInput();
    }

    private void listenForUserInput(){
        // sets asset ids for use in setOnClickListener
        final RadioButton[] operation = {
                findViewById(R.id.radioButton_Addition),
                findViewById(R.id.radioButton_Subtraction),
                findViewById(R.id.radioButton_Multiplication),
                findViewById(R.id.radioButton_Division)};
        final Button instructionButton = findViewById(R.id.button_Instructions);
        final Button exitButton = findViewById(R.id.button_Exit);

        // sets operation strings for use in intent put
        final String operationName[] = {"addition", "subtraction", "multiplication", "division"};


        // listens for clicks to pass intent
        for(int i = 0; i < operation.length; i++) {
            final int operationNum = i; //declared final to pass into inner class
            operation[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("Operation", operationName[operationNum]);
                    startActivity(intent);
                }
            });
        }

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
