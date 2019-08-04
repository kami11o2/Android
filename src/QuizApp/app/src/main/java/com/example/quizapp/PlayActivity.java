package com.example.quizapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.quizapp.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    Button btnA,btnB,btnC,btnD,btnCorrect;
    TextView txtQuestion;
    Question[] mQuestion;
    ProgressBar pbTime;
    Answer[] mAnswerBank;
    int mIndex=0;
    int answerId;
    CountDownTimer cdt;
    TextView txtScore;
    int mScore=0;
    SharedPreferences sharedPreferences;
    TextView txtHighScore;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        mapping();
        createQuestionBank();
        createAnswerBank();
        Timer();
        setQuestion();
        txtHighScore.setText(sharedPreferences.getString("HighScore", "0"));

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp;
                temp = mAnswerBank[mIndex].getAnswer1();
                if (temp == answerId)
                {
                    updateQuestion();
                }
                else
                {
                    loseMessage();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp;
                temp = mAnswerBank[mIndex].getAnswer2();
                if (temp == answerId)
                {
                    updateQuestion();
                }
                else
                {
                    loseMessage();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp;
                temp = mAnswerBank[mIndex].getAnswer3();
                if (temp == answerId)
                {
                    updateQuestion();
                }
                else
                {
                    loseMessage();
                }
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp;
                temp = mAnswerBank[mIndex].getAnswer4();
                if (temp == answerId)
                {
                    updateQuestion();
                }
                else
                {
                    loseMessage();
                }
            }
        });
    }

    private void updateQuestion()
    {
        if (mIndex == 14)
        {
            winMessage();
        }
        else
        {
            mScore += (1000 * (1030-pbTime.getProgress()))/1000;
            txtScore.setText(String.valueOf(mScore));
            cdt.cancel();
            pbTime.setProgress(30);
            Timer();
            mIndex += 1;
            setQuestion();
            checkHighScore();
        }
    }

    private void checkHighScore()
    {
        String highScore;
        highScore = sharedPreferences.getString("HighScore", "0");

        if (Integer.parseInt(txtScore.getText().toString())>Integer.parseInt(highScore))
        {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("HighScore", ""+txtScore.getText().toString());
            edit.apply();
        }
    }

    private void loseMessage()
    {
        cdt.cancel();
        AlertDialog.Builder MessageLose = new AlertDialog.Builder(PlayActivity.this);
        MessageLose.setMessage("You lose! Play again");
        MessageLose.setTitle("Notice");
        MessageLose.setCancelable(true);

        MessageLose.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent a = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(a);
            }
        });
        MessageLose.setCancelable(false);
        AlertDialog alert11 = MessageLose.create();
        alert11.show();
        checkHighScore();
    }

    private void winMessage()
    {
        cdt.cancel();
        AlertDialog.Builder MessageWin = new AlertDialog.Builder(PlayActivity.this);
        MessageWin.setMessage("Congratulation! You are the winner.");
        MessageWin.setTitle("Notice");
        MessageWin.setCancelable(true);

        MessageWin.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent win = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(win);

            }
        });
        MessageWin.setCancelable(false);
        AlertDialog alert11 = MessageWin.create();
        alert11.show();
        checkHighScore();
    }

    private void setQuestion()
    {
        answerId = mQuestion[mIndex].getmAnswer();
        txtQuestion.setText(mQuestion[mIndex].getmQuestion());
        btnA.setText(mAnswerBank[mIndex].getAnswer1());
        btnB.setText(mAnswerBank[mIndex].getAnswer2());
        btnC.setText(mAnswerBank[mIndex].getAnswer3());
        btnD.setText(mAnswerBank[mIndex].getAnswer4());
    }

    private void mapping(){
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        pbTime = (ProgressBar) findViewById(R.id.pbTime);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtHighScore = (TextView) findViewById(R.id.txtHighScore);
    }

    private void createQuestionBank()
    {
        mQuestion = new Question[]{
                new Question(R.string.question_1,R.string.true_answer_1_2),
                new Question(R.string.question_2,R.string.true_answer_2_4),
                new Question(R.string.question_3,R.string.true_answer_3_3),
                new Question(R.string.question_4,R.string.true_answer_4_2),
                new Question(R.string.question_5,R.string.true_answer_5_3),
                new Question(R.string.question_6,R.string.true_answer_6_4),
                new Question(R.string.question_7,R.string.true_answer_7_1),
                new Question(R.string.question_8,R.string.true_answer_8_1),
                new Question(R.string.question_9,R.string.true_answer_9_2),
                new Question(R.string.question_10,R.string.true_answer_10_3),
                new Question(R.string.question_11,R.string.true_answer_11_1),
                new Question(R.string.question_12,R.string.true_answer_12_3),
                new Question(R.string.question_13,R.string.true_answer_13_3),
                new Question(R.string.question_14,R.string.true_answer_14_4),
                new Question(R.string.question_15,R.string.true_answer_15_1)
        };
    }

    private void createAnswerBank()
    {
        mAnswerBank = new Answer[]{
                new Answer(R.string.answer_1_1, R.string.true_answer_1_2, R.string.answer_1_3, R.string.answer_1_4),
                new Answer(R.string.answer_2_1, R.string.answer_2_2, R.string.answer_2_3, R.string.true_answer_2_4),
                new Answer(R.string.answer_3_1, R.string.answer_3_2, R.string.true_answer_3_3, R.string.answer_3_4),
                new Answer(R.string.answer_4_1, R.string.true_answer_4_2, R.string.answer_4_3, R.string.answer_4_4),
                new Answer(R.string.answer_5_1, R.string.answer_5_2, R.string.true_answer_5_3, R.string.answer_5_4),
                new Answer(R.string.answer_6_1, R.string.true_answer_6_4, R.string.answer_6_3, R.string.answer_6_2),
                new Answer(R.string.true_answer_7_1, R.string.answer_7_2, R.string.answer_7_3, R.string.answer_7_4),
                new Answer(R.string.true_answer_8_1, R.string.answer_8_2, R.string.answer_8_3, R.string.answer_8_4),
                new Answer(R.string.answer_9_1, R.string.true_answer_9_2, R.string.answer_9_3, R.string.answer_9_4),
                new Answer(R.string.answer_10_1, R.string.answer_10_2, R.string.true_answer_10_3, R.string.answer_10_4),
                new Answer(R.string.true_answer_11_1, R.string.answer_11_2, R.string.answer_11_3, R.string.answer_11_4),
                new Answer(R.string.answer_12_1, R.string.answer_12_2, R.string.true_answer_12_3, R.string.answer_12_4),
                new Answer(R.string.answer_13_1, R.string.answer_13_2, R.string.true_answer_13_3, R.string.answer_13_4),
                new Answer(R.string.answer_14_1, R.string.answer_14_2, R.string.answer_14_3, R.string.true_answer_14_4),
                new Answer(R.string.true_answer_15_1, R.string.answer_15_2, R.string.answer_15_3, R.string.answer_15_4),
        };
    }

    private void Timer(){
        cdt = new CountDownTimer(20000,100) {
            @Override
            public void onTick(long l) {
                int k = pbTime.getProgress();
                pbTime.setProgress(k+5);
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder MessageLose = new AlertDialog.Builder(PlayActivity.this);
                MessageLose.setMessage("You lose! Play again");
                MessageLose.setTitle("Time out!");
                MessageLose.setCancelable(true);

                MessageLose.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(PlayActivity.this, MainActivity.class);
                        startActivity(a);

                    }
                });
                MessageLose.setCancelable(false);
                AlertDialog alert11 = MessageLose.create();
                alert11.show();
                checkHighScore();
            }
        }.start();
    }

}
