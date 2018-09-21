package com.example.tl00456.arithemticchallenge;

public class Multiplication extends ArithmeticChallenge {
    int firstnum, secondnum;
    String operator;

    public Multiplication(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);
        firstnum = (int)(12 * Math.random());
        secondnum = (int)(12 * Math.random());
    }

    protected String createQuestion(){
        operator = "X";
        System.out.println(firstnum + operator + secondnum);
        return createQuestion();
    }

    protected int[] createChoices(){
        int choice = (int)(3 * Math.random());
        switch(choice){
            case 0: firstnum *= secondnum;
            break;
            case 1: firstnum += secondnum;
            break;
            case 2: firstnum -= secondnum;
            break;
        }
        return createChoices();
    }
}

