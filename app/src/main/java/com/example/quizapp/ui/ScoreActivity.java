package com.example.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import static com.example.quizapp.utils.CommonUtils.totalScore;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quizapp.R;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatTextView tv_score,tv_status;
    AppCompatButton btn_retake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tv_score = findViewById(R.id.tv_score);
        tv_status = findViewById(R.id.tv_status);
        btn_retake = findViewById(R.id.btn_retake);

        btn_retake.setOnClickListener(this);
        Log.d("ScoreActivity<<<",""+totalScore);


        if(totalScore<=4){
            tv_score.setText("Your Score is "+totalScore);
            tv_status.setText("Please try again!");
            btn_retake.setVisibility(View.VISIBLE);

        }
        else if(totalScore<=6){
            tv_score.setText("Your Score is "+totalScore);
            tv_status.setText("Good Job!");
        }
         else if(totalScore<=8){
            tv_score.setText("Your Score is "+totalScore);
            tv_status.setText("Excellent work!");
        }
         else if(totalScore<=10){
            tv_score.setText("Your Score is "+totalScore);
            tv_status.setText("You are genius!");
        }

    }

    @Override
    public void onClick(View v) {
    startActivity(new Intent(this,MainQuizActivty.class));
    finish();
    totalScore=0;

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        totalScore=0;

    }
}
