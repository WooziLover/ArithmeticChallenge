package com.example.tl00456.arithemticchallenge;

// import statements here

public abstract class ArithmeticChallenge {
    // fields initialized here

    public long mStartTime;
    private int mChoice[];
    private String mQuestionText;


    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL) {
        // to be implemented
    }

    /******************************************************
     * Abstract Classes
     ******************************************************/

    protected abstract String createQuestion();

    protected abstract int[] createChoices();

    /******************************************************
     * Getters and Setters
     ******************************************************/

    protected void setChoices(int[] choices) {
        // set unshuffled choices here
        shuffleChoices(choices);
        mStartTime = System.currentTimeMillis();
    }

    protected String getChoice(int index) {
        return Integer.toString(mChoice[index]);
        }


    protected void setQuestionText(String question) {
         mQuestionText = createQuestion();
    }

    protected String getQuestionText() {
        return mQuestionText;
    }


    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice) {
        // to be implemented
        return true;
    }


    private void shuffleChoices(int[] choices) {
        int[] older = new int[3];
        for(int i = 0; i < 3; i++) {
            older[i] = choices[i];
        }
        int randomorder = (int)(3 * Math.random());

        switch (randomorder){
            case 0: choices[0] = choices[1];
                    choices[1] = choices[2];
                    choices[2] = choices[0];
            break;
            case 1:
            break;
            case 2:
            break;
        }

    }
}

