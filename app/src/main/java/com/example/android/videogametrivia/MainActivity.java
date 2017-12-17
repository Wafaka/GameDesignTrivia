package com.example.android.videogametrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /********************************************************************************************
     * This method gets user input including:
     * the correct & wrong answers for seven questions answered by the user
     *
     * This project consists of 7 questions:
     * 1 question (Question 1) as an EditText which is converted to string
     * 5 questions with 5 RadioButtons which are passed as boolean
     * 1 question (Question 3) with 3 correct & 1 wrong CheckBoxes which are passed as boolean
     ********************************************************************************************/
    public void getScore(View view) {

        //gets the user's answer for the first question as a string & removes all whitespaces
        EditText q1Answer = findViewById(R.id.q1_answer);
        String q1AnswerEntered = q1Answer.getText().toString();
        q1AnswerEntered = q1AnswerEntered.replaceAll("\\s", "");

        //gets if the user selected the correct answer for question 2
        RadioButton q2CorrectAnswer = findViewById(R.id.q2_correct_answer);
        boolean hasQ2Right = q2CorrectAnswer.isChecked();

        //gets if the user selected the first correct answer for question 3
        CheckBox q3CorrectAnswer1 = findViewById(R.id.q3_correct_answer1);
        boolean hasQ3A1Right = q3CorrectAnswer1.isChecked();

        //gets if the user selected the wrong answer for question 3
        CheckBox q3WrongAnswer = findViewById(R.id.q3_wrong_answer);
        boolean hasQ3Wrong = q3WrongAnswer.isChecked();

        //gets if the user selected the second correct answer for question 3
        CheckBox q3CorrectAnswer2 = findViewById(R.id.q3_correct_answer2);
        boolean hasQ3A2Right = q3CorrectAnswer2.isChecked();

        //gets if the user selected the third correct answer for question 3
        CheckBox q3CorrectAnswer3 = findViewById(R.id.q3_correct_answer3);
        boolean hasQ3A3Right = q3CorrectAnswer3.isChecked();

        //gets if the user selected the correct answer for question 4
        RadioButton q4CorrectAnswer = findViewById(R.id.q4_correct_answer);
        boolean hasQ4Right = q4CorrectAnswer.isChecked();

        //gets if the user selected the correct answer for question 5
        RadioButton q5CorrectAnswer = findViewById(R.id.q5_correct_answer);
        boolean hasQ5Right = q5CorrectAnswer.isChecked();

        //gets if the user selected the correct answer for question 6
        RadioButton q6CorrectAnswer = findViewById(R.id.q6_correct_answer);
        boolean hasQ6Right = q6CorrectAnswer.isChecked();

        //gets if the user selected the correct answer for question 7
        RadioButton q7CorrectAnswer = findViewById(R.id.q7_correct_answer);
        boolean hasQ7Right = q7CorrectAnswer.isChecked();

        //calculates user score
        int score = calculateScore(q1AnswerEntered, hasQ2Right, hasQ3A1Right, hasQ3Wrong, hasQ3A2Right,
                hasQ3A3Right, hasQ4Right, hasQ5Right, hasQ6Right, hasQ7Right);

        //displays score result on the screen
        displayScore(score);
    }

    /**********************************************************************************************
     * This method displays the quiz score as a toast message
     * The conditional statement displays different message according to the user's score
     * @param score    the total score of the user out of 7
     *********************************************************************************************/
    public void displayScore(int score) {

        String toastMessage;

        if (score == 7) {
            //displays "congrats" message when the user gets a perfect score
            toastMessage = "Congrats," + "\nYou got a perfect score!";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

        } else if (score > 3 && score < 7) {
            //displays "good job" message when the user scores more than 3 points
            toastMessage = "Good job," + "\nYou scored: " + score + " out of 7";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

        } else if (score < 7) {
            //displays "try again" message when the user scores less than 3
            toastMessage = "Try again," + "\nYou scored: " + score + " out of 7";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
        }

    }

    /*********************************************************************************************
     * This method calculates the user's score based on the selected answers
     * score is calculated as:
     * +1 for typing the correct answer
     * +1 for selecting correct RadioButton or CheckBox
     *
     * @param q1Answer whether correct answer of question 1 is entered
     * @param q2RightAnswer   whether or not correct answer of Question 2 is selected
     * @param q3A1RightAnswer whether or not first correct answer of Question 3 is selected
     * @param q3WrongAnswer   whether or not wrong answer of Question 3 is selected
     * @param q3A2RightAnswer whether or not second correct answer of Question 3 is selected
     * @param q3A3RightAnswer whether or not third correct answer of Question 3 is selected
     * @param q4RightAnswer   whether or not correct answer of Question 4 is selected
     * @param q5RightAnswer   whether or not correct answer of Question 5 is selected
     * @param q6RightAnswer   whether or not correct answer of Question 6 is selected
     * @param q7RightAnswer   whether or not correct answer of Question 7 is selected
     * @return the final score
     *********************************************************************************************/
    private int calculateScore(String q1Answer, boolean q2RightAnswer, boolean q3A1RightAnswer,
                               boolean q3WrongAnswer, boolean q3A2RightAnswer, boolean q3A3RightAnswer,
                               boolean q4RightAnswer, boolean q5RightAnswer, boolean q6RightAnswer,
                               boolean q7RightAnswer) {

        //initialize final score
        int finalScore = 0;

        //add a point if correct answer for question 1 is entered
        if (q1Answer.equals("Avatar") || q1Answer.equals("avatar") || q1Answer.equals("AVATAR")) {
            finalScore += 1;
        }

        //add a point if correct answer for question 2 is selected
        if (q2RightAnswer) {
            finalScore += 1;
        }

        //add a point if 1st correct answer for question 3 is selected
        if (q3A1RightAnswer && q3A2RightAnswer && q3A3RightAnswer && !q3WrongAnswer) {
            finalScore += 1;
        }

        //add a point if correct answer for question 4 is selected
        if (q4RightAnswer) {
            finalScore += 1;
        }

        //add a point if correct answer for question 5 is selected
        if (q5RightAnswer) {
            finalScore += 1;
        }

        //add a point if correct answer for question 6 is selected
        if (q6RightAnswer) {
            finalScore += 1;
        }

        //add a point if correct answer for question 7 is selected
        if (q7RightAnswer) {
            finalScore += 1;
        }

        return finalScore;
    }

}
