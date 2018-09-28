package com.example.tl00456.arithemticchallenge;

// import statements here

public abstract class ArithmeticChallenge {
    // fields initialized here
    String question;
    int[] createChoices;

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

    protected int getChoice(int index) {
        //something that connects method together
        return index;
    }

    protected void setQuestionText(String question) {

        this.question = createQuestion();
    }

    protected String getQuestionText() {
        return question;
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
      //if()
    }


}

