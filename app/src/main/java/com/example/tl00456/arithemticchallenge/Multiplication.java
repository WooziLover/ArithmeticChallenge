package com.example.tl00456.arithemticchallenge;

public class Multiplication extends ArithmeticChallenge {
    int firstnum, secondnum;
    String operator;

    public Multiplication(int TOTAL_LEVELS, int TURNS_PER_LEVEL) {
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);
        firstnum = (int) (12 * Math.random());
        secondnum = (int) (12 * Math.random());
    }

    protected String createQuestion() {
        operator = "X";
        String question = firstnum + operator + secondnum;
        return question;
    }

    protected int[] createChoices() {
        int a, b, c;
        a = firstnum * secondnum ;
        b = a - (int)(2 * Math.random());
        c = a + (int)(2 * Math.random());
        int[] result = {a, b, c};
        int[] result_one = {b, c, a};
        int[] result_two = {c, a, b};
            int randomChoice = (int) (3 * Math.random());
            switch (randomChoice) {
                case 0: return result;
                case 1: return result_one;
                case 2: return result_two;
            }
            return createChoices();
        }
    }


