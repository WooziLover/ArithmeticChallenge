package com.example.tl00456.arithemticchallenge;

// import statements here

public abstract class ArithmeticChallenge {
    // fields initialized here

    public long mStartTime;
    int mChoice[] = new int[3];
    String mQuestionText;
    int mScoreText = 0;
    int mProgressBar, mHighScoreText;
    int mAnswer = mChoice[0];


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

    protected void setScore(boolean isCorrect) {
        long mEndTime = System.currentTimeMillis();
        if (isCorrect) {
            int time = (int) (mStartTime - mEndTime) / 1000;
            mScoreText += 1;
        }else{
            mScoreText -= 1;
        }
    }

    protected int getScore() {
        return mScoreText;
    }

    protected void setProgress() {
        mProgressBar++;

    }

    protected int getProgress() {
        return mProgressBar;
    }

    protected void setHighScore(int highScore){
        mHighScoreText = highScore;
    }

    protected int getHighScore(){
        return mHighScoreText;
    }
    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice) {
        if (mChoice[choice] == mAnswer) {
            return true;
            }
        return false;
    }


        private void shuffleChoices (int[] mChoice){
            int[] older = new int[3];
            for (int i = 0; i < 2; i++) {
                older[i] = mChoice[i];
            }
            int randomorder = (int) (6 * Math.random());

            switch (randomorder) {
                case 0:
                    mChoice[0] = older[1];
                    mChoice[1] = older[2];
                    mChoice[2] = older[0];
                    break;
                case 1:
                    mChoice[0] = older[2];
                    mChoice[1] = older[0];
                    mChoice[2] = older[1];
                    break;
                case 2:
                    mChoice[1] = older[2];
                    mChoice[2] = older[0];
                    mChoice[0] = older[1];
                    break;
                case 3:
                    mChoice[1] = older[0];
                    mChoice[2] = older[1];
                    mChoice[0] = older[2];
                    break;
                case 4:
                    mChoice[2] = older[0];
                    mChoice[0] = older[1];
                    mChoice[1] = older[2];
                    break;
                case 5:
                    mChoice[2] = older[1];
                    mChoice[0] = older[2];
                    mChoice[1] = older[0];
                    break;

            }

        }
    }


