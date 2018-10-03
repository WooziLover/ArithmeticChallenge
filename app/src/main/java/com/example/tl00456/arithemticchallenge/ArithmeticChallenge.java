package com.example.tl00456.arithemticchallenge;

// import statements here

public abstract class ArithmeticChallenge {
    // fields initialized here

    public long mStartTime;
    int mChoice[] = new int[3];
    String mQuestionText;


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
        mChoice = choices;
        mStartTime = System.currentTimeMillis();
    }

    protected String getChoice(int index) {
        return Integer.toString(mChoice[index]);
        }


    protected void setQuestionText(String question) {
         mQuestionText = question;
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


    private void shuffleChoices(int[] mChoice) {
        int[] older = new int[3];
       for(int i = 0; i < 2; i++) {
            older[i] = mChoice[i];
        }
        int randomorder = (int)(7 * Math.random());

        switch (randomorder){
            case 0: mChoice[0] = older[1];
                    mChoice[1] = older[2];
                    mChoice[2] = older[0];
            break;
            case 1: mChoice[0] = older[2];
                    mChoice[1] = older[0];
                    mChoice[2] = older[1];
            break;
            case 2: mChoice[1] = older[2];
                    mChoice[2] = older[0];
                    mChoice[0] = older[1];
            break;
            case 3: mChoice[1] = older[0];
                    mChoice[2] = older[1];
                    mChoice[0] = older[2];
            break;
            case 4: mChoice[2] = older[0];
                    mChoice[0] = older[1];
                    mChoice[1] = older[2];
            break;
            case 5: mChoice[2] = older[1];
                    mChoice[0] = older[2];
                    mChoice[1] = older[0];
            break;
            case 6: mChoice[0] = older[0];
                    mChoice[1] = older[1];
                    mChoice[2] = older[2];
            break;
        }

    }
}

