package com.example.tl00456.arithemticchallenge;

/*************************************************
 * Description: For the createQuestion method I wanted to create the two numbers that were random but in the range of 1-12.
 * I wanted the Math.random() to go to 12 and start at 1 is because that is the 12 by 12 table that every kid
 * had to learn in elementary school. I wanted to then add another variable (question) to cleanly put the three
 * methods (firstnum, secondnum, and operator) together.
 * Here are the reasons for createChoices. For a, I wanted to make it the correct answer and that's
 * why I based the answers of b and c off a. Why I chose 3 for what b and c would be is because I didn't
 * want the answer to be too big but not too small. I experimented and found 3 to be a good number. I chose to
 * do a if statement because to me, it made sense to make a if statement. If these numbers are equal to each
 * other, then do this specific action to fix it (multiply or divide by 2). I chose 2 because I didn't want
 * the number again to be too small or big. The reason for why I created so many arrays and did a switch(randomChoice)
 * was because usually games don't have the correct answer in the same spot (button) the whole time. Otherwise the
 * player would choose the middle button (for example) every time and wouldn't learn. I immediately thought of
 * the switch(randomChoice) because the computer will randomly choose a answer (one of the answer orders).
 * That was my thinking process and why I decided to program it this way.
 *
 * Author: Tristyn Lai
 * Date: 9/24/18 8:39 pm
 ************************************************/
public class Multiplication extends ArithmeticChallenge {
    int firstnum, secondnum;
    public Multiplication(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);

    }

    protected String createQuestion() {
        firstnum = (int) (12 * Math.random() + 1);
        secondnum = (int) (12 * Math.random()) + 1;
        String operator = " X ";
        String question = firstnum + operator + secondnum;
        return question;
    }

    protected int[] createChoices() {
       /*int a, b, c;
       a = firstnum * secondnum;
       do{
           b = a * (int)(3 * Math.random() + 1);
       }
       while()*/
        int a, b, c;
        a = firstnum * secondnum;
        b = a * (int) (3 * Math.random() + 1);
        c = a * (int) (3 * Math.random() + 1);
        if ((a == b) || (a == c) || (b == a) || (b == c) || (c == a) || (c == b))
            b = a * 2;
            c = a / 2;

        int[] result = {a, b, c};
        return result;
    }
}

