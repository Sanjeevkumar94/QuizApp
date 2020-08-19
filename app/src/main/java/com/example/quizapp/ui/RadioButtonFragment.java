package com.example.quizapp.ui;

import android.os.Bundle;

import android.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.model.CricketModel;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;

import static com.example.quizapp.utils.CommonUtils.totalScore;


public class RadioButtonFragment extends Fragment implements View.OnClickListener {


    AppCompatRadioButton radio_btn_1_1,radio_btn_1_2,radio_btn_1_3,radio_btn_1_4,radio_btn_2_1,radio_btn_2_2,radio_btn_2_3,radio_btn_2_4;
    RadioGroup radioGroup1,radioGroup2;
    AppCompatTextView tv_ques_1,tv_ques_2;
    CricketModel cricketModel;
    CricketModel cricketModel2;
    AppCompatButton btn_next;
    String userAnswerSelected1 = "";
    String userAnswerSelected2 = "";
    onNextClickCheckboxListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_radio_button, container, false);

        //find views

        radio_btn_1_1 = view.findViewById(R.id.radio_btn_1_1);
        radio_btn_1_2 = view.findViewById(R.id.radio_btn_1_2);
        radio_btn_1_3 = view.findViewById(R.id.radio_btn_1_3);
        radio_btn_1_4 = view.findViewById(R.id.radio_btn_1_4);
        radio_btn_2_1 = view.findViewById(R.id.radio_btn_2_1);
        radio_btn_2_2 = view.findViewById(R.id.radio_btn_2_2);
        radio_btn_2_3 = view.findViewById(R.id.radio_btn_2_3);
        radio_btn_2_4 = view.findViewById(R.id.radio_btn_2_4);

        tv_ques_1 = view.findViewById(R.id.tv_ques_1);
        tv_ques_2 = view.findViewById(R.id.tv_ques_2);

        btn_next = view.findViewById(R.id.btn_next);

        radioGroup1 = view.findViewById(R.id.radioGroup);
        radioGroup2 = view.findViewById(R.id.radioGroup2);

        //set Listeners
        btn_next.setOnClickListener(this);

        //get data
        getBundleData();
        getBundleData2();

        //set data
        tv_ques_1.setText(cricketModel.getQuestion());
        radio_btn_1_1.setText(cricketModel.getAnswers().get(0));
        radio_btn_1_2.setText(cricketModel.getAnswers().get(1));
        radio_btn_1_3.setText(cricketModel.getAnswers().get(2));
        radio_btn_1_4.setText(cricketModel.getAnswers().get(3));

        tv_ques_2.setText(cricketModel2.getQuestion());
        radio_btn_2_1.setText(cricketModel2.getAnswers().get(0));
        radio_btn_2_2.setText(cricketModel2.getAnswers().get(1));
        radio_btn_2_3.setText(cricketModel2.getAnswers().get(2));
        radio_btn_2_4.setText(cricketModel2.getAnswers().get(3));


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                AppCompatRadioButton radioButton =  group.findViewById(checkedId);
                userAnswerSelected1 = radioButton.getText().toString();
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                AppCompatRadioButton radioButton =  group.findViewById(checkedId);
                userAnswerSelected2 = radioButton.getText().toString();
            }
        });

        return view;
    }
    private void getBundleData() {
        Bundle bundle = getArguments();
        cricketModel = (CricketModel) bundle.getSerializable("data");
//        Toast.makeText(getActivity(), cricketModel.getAnswers().get(0), Toast.LENGTH_SHORT).show();
    }

    private void getBundleData2() {
        Bundle bundle = getArguments();
        cricketModel2 = (CricketModel) bundle.getSerializable("data2");
        //  Toast.makeText(getActivity(), cricketModel2.getQuestion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                if(!TextUtils.isEmpty(userAnswerSelected2) &&  !TextUtils.isEmpty(userAnswerSelected1)){

                    if(userAnswerSelected1.equals(cricketModel.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
                    if(userAnswerSelected2.equals(cricketModel2.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }

                    Log.d("RadioButtonFragment<<<",""+totalScore);
                   listener.onRadioBtnxNextClick();

                } else{
                    Toast.makeText(getActivity(),"Please give both answers",Toast.LENGTH_SHORT).show();

                }

        }
    }


    public void setNextClickListener(onNextClickCheckboxListener listener){
        this.listener = listener;

    }

    interface onNextClickCheckboxListener{
        void onRadioBtnxNextClick();
    }
}
