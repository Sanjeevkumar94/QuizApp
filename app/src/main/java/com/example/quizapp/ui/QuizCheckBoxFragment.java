package com.example.quizapp.ui;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.model.CricketModel;

import static com.example.quizapp.utils.CommonUtils.totalScore;

public class QuizCheckBoxFragment extends Fragment implements View.OnClickListener {
    AppCompatCheckBox checkbox_1_1, checkbox_1_2, checkbox_1_3, checkbox_1_4, checkbox_2_1, checkbox_2_2, checkbox_2_3, checkbox_2_4;
    CricketModel cricketModel;
    CricketModel cricketModel2;
    AppCompatTextView tv_ques_2, tv_ques_1;
    String userAnswerSelected1 = "";
    String userAnswerSelected2 = "";
    AppCompatButton btn_next;
    onNextClickCheckboxListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_quiz_check_box, container, false);

        //find Views

        tv_ques_1 = view.findViewById(R.id.tv_ques_1);
        tv_ques_2 = view.findViewById(R.id.tv_ques_2);

        checkbox_1_1 = view.findViewById(R.id.checkbox_1_1);
        checkbox_1_2 = view.findViewById(R.id.checkbox_1_2);
        checkbox_1_3 = view.findViewById(R.id.checkbox_1_3);
        checkbox_1_4 = view.findViewById(R.id.checkbox_1_4);
        checkbox_2_1 = view.findViewById(R.id.checkbox_2_1);
        checkbox_2_2 = view.findViewById(R.id.checkbox_2_2);
        checkbox_2_3 = view.findViewById(R.id.checkbox_2_3);
        checkbox_2_4 = view.findViewById(R.id.checkbox_2_4);
        btn_next = view.findViewById(R.id.btn_next);

        getBundleData();
        getBundleData2();

        //set Listeners
        btn_next.setOnClickListener(this);

        //set data
        tv_ques_1.setText(cricketModel.getQuestion());
        checkbox_1_1.setText(cricketModel.getAnswers().get(0));
        checkbox_1_2.setText(cricketModel.getAnswers().get(1));
        checkbox_1_3.setText(cricketModel.getAnswers().get(2));
        checkbox_1_4.setText(cricketModel.getAnswers().get(3));

        tv_ques_2.setText(cricketModel2.getQuestion());
        checkbox_2_1.setText(cricketModel2.getAnswers().get(0));
        checkbox_2_2.setText(cricketModel2.getAnswers().get(1));
        checkbox_2_3.setText(cricketModel2.getAnswers().get(2));
        checkbox_2_4.setText(cricketModel2.getAnswers().get(3));

        setView();


        return view;
    }

    private void setView() {

        checkbox_1_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected1 = checkbox_1_1.getText().toString();
                    checkbox_1_2.setChecked(false);
                    checkbox_1_3.setChecked(false);
                    checkbox_1_4.setChecked(false);
                }
            }
        });
        checkbox_1_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected1 = checkbox_1_2.getText().toString();

                    checkbox_1_1.setChecked(false);
                    checkbox_1_3.setChecked(false);
                    checkbox_1_4.setChecked(false);
                }
            }
        });
        checkbox_1_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected1 = checkbox_1_3.getText().toString();

                    checkbox_1_1.setChecked(false);
                    checkbox_1_2.setChecked(false);
                    checkbox_1_4.setChecked(false);
                }
            }
        });

        checkbox_1_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected1 = checkbox_1_4.getText().toString();

                    checkbox_1_1.setChecked(false);
                    checkbox_1_2.setChecked(false);
                    checkbox_1_3.setChecked(false);
                }
            }
        });

        checkbox_2_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected2 = checkbox_2_1.getText().toString();

                    checkbox_2_2.setChecked(false);
                    checkbox_2_3.setChecked(false);
                    checkbox_2_4.setChecked(false);
                }
            }
        });
        checkbox_2_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected2 = checkbox_2_2.getText().toString();

                    checkbox_2_1.setChecked(false);
                    checkbox_2_3.setChecked(false);
                    checkbox_2_4.setChecked(false);
                }
            }
        });
        checkbox_2_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected2 = checkbox_2_3.getText().toString();
                    checkbox_2_1.setChecked(false);
                    checkbox_2_2.setChecked(false);
                    checkbox_2_4.setChecked(false);
                }
            }
        });

        checkbox_2_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userAnswerSelected2 = checkbox_2_4.getText().toString();
                    checkbox_2_1.setChecked(false);
                    checkbox_2_2.setChecked(false);
                    checkbox_2_3.setChecked(false);
                }
            }
        });
    }

    private void getBundleData() {
        Bundle bundle = getArguments();
        cricketModel = (CricketModel) bundle.getSerializable("data");
        //Toast.makeText(getActivity(), cricketModel.getAnswers().get(0), Toast.LENGTH_SHORT).show();
    }

    private void getBundleData2() {
        Bundle bundle = getArguments();
        cricketModel2 = (CricketModel) bundle.getSerializable("data2");
        //  Toast.makeText(getActivity(), cricketModel2.getQuestion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if(!TextUtils.isEmpty(userAnswerSelected2) &&  !TextUtils.isEmpty(userAnswerSelected1)){

                    if(userAnswerSelected1.equals(cricketModel.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
                    if(userAnswerSelected2.equals(cricketModel2.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }

                    listener.onCheckboxNextClick();
                    Log.d("QuizCheckBoxFragment<<",""+totalScore);

                } else{
                    Toast.makeText(getActivity(),"Please give both answers",Toast.LENGTH_SHORT).show();

                }
        }
    }

    public void setNextClickListener(onNextClickCheckboxListener listener){
        this.listener = listener;

    }

    interface onNextClickCheckboxListener{
        void onCheckboxNextClick();
    }
}
