package com.example.tl00456.arithemticchallenge;

// duplicate this for addition, subtraction, and division

public class Division extends ArithmeticChallenge {
    // add fields here
    int[] empty = new int[3];

    public Division(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);
    }

    protected String createQuestion(){
        // to be implemented
        return "";
    }

    protected int[] createChoices(){
// to be implemented
       return empty;
    }
}

