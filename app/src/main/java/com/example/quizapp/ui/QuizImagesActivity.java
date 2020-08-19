package com.example.quizapp.ui;

import android.graphics.Color;
import android.os.Bundle;

import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.quizapp.R;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import static com.example.quizapp.utils.CommonUtils.totalScore;


public class QuizImagesActivity extends Fragment implements View.OnClickListener {

    FrameLayout fl_mumbai, fl_punjab, fl_hyderabad, fl_kolkata, fl_multan_sultan, fl_karachi, fl_lahore, fl_peshawar;
    String userAnswerSelected1 = "";
    String userAnswerSelected2 = "";
    AppCompatButton btn_next;
    onNextClickImageListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz_images_activity, container, false);

        //finding views
        fl_mumbai = view.findViewById(R.id.fl_mumbai);
        fl_punjab = view.findViewById(R.id.fl_punjab);
        fl_hyderabad = view.findViewById(R.id.fl_hyderabad);
        fl_kolkata = view.findViewById(R.id.fl_kolkata);
        fl_multan_sultan = view.findViewById(R.id.fl_multan_sultan);
        fl_karachi = view.findViewById(R.id.fl_karachi);
        fl_lahore = view.findViewById(R.id.fl_lahore);
        fl_peshawar = view.findViewById(R.id.fl_peshawar);

        btn_next = view.findViewById(R.id.btn_next);

        //set listeners
        fl_mumbai.setOnClickListener(this);
        fl_punjab.setOnClickListener(this);
        fl_hyderabad.setOnClickListener(this);
        fl_kolkata.setOnClickListener(this);
        fl_multan_sultan.setOnClickListener(this);
        fl_karachi.setOnClickListener(this);
        fl_lahore.setOnClickListener(this);
        fl_peshawar.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fl_mumbai:
                userAnswerSelected1 = "yes";
                fl_mumbai.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_punjab.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_hyderabad.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_kolkata.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_punjab:
                userAnswerSelected1 = "no";
                fl_punjab.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_mumbai.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_hyderabad.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_kolkata.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_hyderabad:
                userAnswerSelected1 = "no";
                fl_hyderabad.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_mumbai.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_punjab.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_kolkata.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_kolkata:
                userAnswerSelected1 = "no";
                fl_kolkata.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_mumbai.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_punjab.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_hyderabad.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_multan_sultan:
                userAnswerSelected2 = "no";
                fl_multan_sultan.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_karachi.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_lahore.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_peshawar.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_karachi:
                userAnswerSelected2 = "yes";
                fl_karachi.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_multan_sultan.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_lahore.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_peshawar.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_lahore:
                userAnswerSelected2 = "no";
                fl_lahore.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_karachi.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_karachi.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_peshawar.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.fl_peshawar:
                userAnswerSelected2 = "no";
                fl_peshawar.setBackgroundColor(Color.parseColor("#DAD9D5"));
                fl_karachi.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_lahore.setBackgroundColor(Color.parseColor("#ffffff"));
                fl_lahore.setBackgroundColor(Color.parseColor("#ffffff"));
                break;

            case R.id.btn_next:
                if(!TextUtils.isEmpty(userAnswerSelected2) &&  !TextUtils.isEmpty(userAnswerSelected1)){

                    if(userAnswerSelected1.equals("yes")){
                        totalScore = totalScore+1;
                    }
                    if(userAnswerSelected2.equals("yes")){
                        totalScore = totalScore+1;
                    }

                    Log.d("QuizImagesActivity<<<",""+totalScore);
                    listener.onImageBtnxNextClick();

                } else{
                    Toast.makeText(getActivity(),"Please give both answers",Toast.LENGTH_SHORT).show();

                }
        }
    }


    public void setNextClickListener(onNextClickImageListener listener){
        this.listener = listener;

    }

    interface onNextClickImageListener{
        void onImageBtnxNextClick();
    }
}
