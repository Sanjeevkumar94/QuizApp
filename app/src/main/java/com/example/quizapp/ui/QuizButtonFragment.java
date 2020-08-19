package com.example.quizapp.ui;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.model.CricketModel;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import static android.content.Context.MODE_PRIVATE;
import static com.example.quizapp.utils.CommonUtils.TOTALSCORE;
import static com.example.quizapp.utils.CommonUtils.sharedPrefName;
import static com.example.quizapp.utils.CommonUtils.totalScore;


public class QuizButtonFragment extends Fragment implements View.OnClickListener {
    CricketModel cricketModel;
    AppCompatTextView tvQues1;
    AppCompatButton btnAnswer1;
    AppCompatButton btnAnswer2;
    AppCompatButton btnAnswer3;
    AppCompatButton btnAnswer4;

    CricketModel cricketModel2;
    AppCompatTextView tvQues2;
    AppCompatButton btnAnswer2_1;
    AppCompatButton btnAnswer2_2;
    AppCompatButton btnAnswer2_3;
    AppCompatButton btnAnswer2_4;

    String userAnswerSelected1 = "";
    String userAnswerSelected2 = "";

    AppCompatButton btnNext;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;

    onNextClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_button, container, false);

        //find views
        tvQues1 = view.findViewById(R.id.tv_ques_1);
        btnAnswer1 = view.findViewById(R.id.btn_answer_1);
        btnAnswer2 = view.findViewById(R.id.btn_answer_2);
        btnAnswer3 = view.findViewById(R.id.btn_answer_3);
        btnAnswer4 = view.findViewById(R.id.btn_answer_4);

        tvQues2 = view.findViewById(R.id.tv_ques_2);
        btnAnswer2_1 = view.findViewById(R.id.btn_answer_2_1);
        btnAnswer2_2 = view.findViewById(R.id.btn_answer_2_2);
        btnAnswer2_3 = view.findViewById(R.id.btn_answer_2_3);
        btnAnswer2_4 = view.findViewById(R.id.btn_answer_2_4);

        btnNext = view.findViewById(R.id.btn_next);

        //set Listeners
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);

        btnAnswer2_1.setOnClickListener(this);
        btnAnswer2_2.setOnClickListener(this);
        btnAnswer2_3.setOnClickListener(this);
        btnAnswer2_4.setOnClickListener(this);

        btnNext.setOnClickListener(this);

        //get data
        getBundleData();
        getBundleData2();

        //set data to views
        tvQues1.setText(cricketModel.getQuestion());
        btnAnswer1.setText(cricketModel.getAnswers().get(0));
        btnAnswer2.setText(cricketModel.getAnswers().get(1));
        btnAnswer3.setText(cricketModel.getAnswers().get(2));
        btnAnswer4.setText(cricketModel.getAnswers().get(3));

        tvQues2.setText(cricketModel2.getQuestion());
        btnAnswer2_1.setText(cricketModel2.getAnswers().get(0));
        btnAnswer2_2.setText(cricketModel2.getAnswers().get(1));
        btnAnswer2_3.setText(cricketModel2.getAnswers().get(2));
        btnAnswer2_4.setText(cricketModel2.getAnswers().get(3));


        sharedPreferences =  getActivity().getSharedPreferences(sharedPrefName,
                MODE_PRIVATE);
        myEdit = sharedPreferences.edit();

        return view;
    }

    private void getBundleData() {
        Bundle bundle = getArguments();
        cricketModel = (CricketModel) bundle.getSerializable("data");
        //  Toast.makeText(getActivity(), cricketModel.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
    }

    private void getBundleData2() {
        Bundle bundle = getArguments();
        cricketModel2 = (CricketModel) bundle.getSerializable("data2");
//        Toast.makeText(getActivity(), cricketModel2.getQuestion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_answer_1:

                userAnswerSelected1 = btnAnswer1.getText().toString();

//                Toast.makeText(getActivity(), userAnswerSelected1, Toast.LENGTH_SHORT).show();

                btnAnswer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer1.setTextColor(Color.parseColor("#ffffff"));

                btnAnswer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2.setTextColor(Color.parseColor("#000000"));

                btnAnswer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer3.setTextColor(Color.parseColor("#000000"));

                btnAnswer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer4.setTextColor(Color.parseColor("#000000"));

                break;


            case R.id.btn_answer_2:

                userAnswerSelected1 = btnAnswer2.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected1, Toast.LENGTH_SHORT).show();

                btnAnswer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer2.setTextColor(Color.parseColor("#ffffff"));


                btnAnswer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer1.setTextColor(Color.parseColor("#000000"));

                btnAnswer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer3.setTextColor(Color.parseColor("#000000"));

                btnAnswer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer4.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_answer_3:
                userAnswerSelected1 = btnAnswer3.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected1, Toast.LENGTH_SHORT).show();

                btnAnswer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer3.setTextColor(Color.parseColor("#ffffff"));

                btnAnswer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer1.setTextColor(Color.parseColor("#000000"));

                btnAnswer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2.setTextColor(Color.parseColor("#000000"));

                btnAnswer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer4.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_answer_4:
                userAnswerSelected1 = btnAnswer4.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected1, Toast.LENGTH_SHORT).show();

                btnAnswer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer4.setTextColor(Color.parseColor("#ffffff"));


                btnAnswer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer1.setTextColor(Color.parseColor("#000000"));

                btnAnswer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2.setTextColor(Color.parseColor("#000000"));

                btnAnswer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer3.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_answer_2_1:

                userAnswerSelected2 = btnAnswer2_1.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected2, Toast.LENGTH_SHORT).show();


                btnAnswer2_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer2_1.setTextColor(Color.parseColor("#ffffff"));

                btnAnswer2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_2.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_3.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_4.setTextColor(Color.parseColor("#000000"));

                break;


            case R.id.btn_answer_2_2:

                userAnswerSelected2 = btnAnswer2_2.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected2, Toast.LENGTH_SHORT).show();

                btnAnswer2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer2_2.setTextColor(Color.parseColor("#ffffff"));


                btnAnswer2_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_1.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_3.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_4.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_answer_2_3:
                userAnswerSelected2 = btnAnswer2_3.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected2, Toast.LENGTH_SHORT).show();

                btnAnswer2_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer2_3.setTextColor(Color.parseColor("#ffffff"));

                btnAnswer2_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_1.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_2.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_4.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_answer_2_4:
                userAnswerSelected2 = btnAnswer2_4.getText().toString();
//                Toast.makeText(getActivity(), userAnswerSelected2, Toast.LENGTH_SHORT).show();

                btnAnswer2_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_login));
                btnAnswer2_4.setTextColor(Color.parseColor("#ffffff"));


                btnAnswer2_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_1.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_2.setTextColor(Color.parseColor("#000000"));

                btnAnswer2_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_btn_ques));
                btnAnswer2_3.setTextColor(Color.parseColor("#000000"));
                break;

            case R.id.btn_next:
                if(!TextUtils.isEmpty(userAnswerSelected2) &&  !TextUtils.isEmpty(userAnswerSelected1)){

                    if(userAnswerSelected1.equals(cricketModel.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
                    if(userAnswerSelected2.equals(cricketModel2.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
                    listener.onNextClick();

                    Log.d("QuizButtonFragment<<<<",""+totalScore);

                } else{
                    Toast.makeText(getActivity(),"Please give both answers",Toast.LENGTH_SHORT).show();

                }




        }
    }

    public void setNextClickListener(onNextClickListener listener){
        this.listener = listener;

    }


    interface onNextClickListener{
          void onNextClick();
    }

}


                //myEdit.putString(TOTALSCORE,userAnswerSelected1);
