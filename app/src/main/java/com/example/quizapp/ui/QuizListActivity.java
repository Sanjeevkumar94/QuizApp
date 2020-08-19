package com.example.quizapp.ui;

import android.os.Bundle;

import android.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.adapter.CustomAdapter2;
import com.example.quizapp.adapter.customAdapter1;
import com.example.quizapp.model.CricketModel;
import com.example.quizapp.model.ListModel;

import java.util.ArrayList;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.quizapp.utils.CommonUtils.totalScore;


public class QuizListActivity extends Fragment implements customAdapter1.OnLastNextCliCkListener, CustomAdapter2.OnLastNextCliCkListener2,View.OnClickListener{


    AppCompatTextView tv_ques_1,tv_ques_2;
    RecyclerView rv_1,rv_2;
    CricketModel cricketModel;
    CricketModel cricketModel2;

    ArrayList<ListModel> listModels;
    ArrayList<ListModel> listModels2;

    String userAnswerSelected1 = "";
    String userAnswerSelected2 = "";
    customAdapter1 myCustomerAdapter;
    CustomAdapter2 myCustomerAdapter2;

    AppCompatButton btn_finish;

    FinishClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_list_activity, container, false);

        //finding views
        tv_ques_1 = view.findViewById(R.id.tv_ques_1);
        tv_ques_2 = view.findViewById(R.id.tv_ques_2);
        rv_1 = view.findViewById(R.id.rv_1);
        rv_2 = view.findViewById(R.id.rv_2);
        btn_finish = view.findViewById(R.id.btn_finish);

        //set lisners
        btn_finish.setOnClickListener(this);

        //get data
        getBundleData();
        getBundleData2();


        //set data
        tv_ques_1.setText(cricketModel.getQuestion());
        tv_ques_2.setText(cricketModel2.getQuestion());

        //init recyclerview


        listModels = new ArrayList<>();
        listModels2 = new ArrayList<>();

        listModels.add(new ListModel(cricketModel.getAnswers().get(0),false));
        listModels.add(new ListModel(cricketModel.getAnswers().get(1),false));
        listModels.add(new ListModel(cricketModel.getAnswers().get(2),false));
        listModels.add(new ListModel(cricketModel.getAnswers().get(3),false));

        listModels2.add(new ListModel(cricketModel2.getAnswers().get(0),false));
        listModels2.add(new ListModel(cricketModel2.getAnswers().get(1),false));
        listModels2.add(new ListModel(cricketModel2.getAnswers().get(2),false));
        listModels2.add(new ListModel(cricketModel2.getAnswers().get(3),false));


         myCustomerAdapter = new customAdapter1(this,listModels);
        rv_1.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_1.setAdapter(myCustomerAdapter);

         myCustomerAdapter2 = new CustomAdapter2(this,listModels2);
        rv_2.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_2.setAdapter(myCustomerAdapter2);

        return  view;

    }

    private void getBundleData() {
        Bundle bundle = getArguments();
        cricketModel = (CricketModel) bundle.getSerializable("data");
//        Toast.makeText(getActivity(), cricketModel.getCorrectAnswer(), Toast.LENGTH_SHORT).show();
    }

    private void getBundleData2() {
        Bundle bundle = getArguments();
        cricketModel2 = (CricketModel) bundle.getSerializable("data2");
        //  Toast.makeText(getActivity(), cricketModel2.getQuestion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLastClick(String s, int position) {
        userAnswerSelected1=s;
//        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
        myCustomerAdapter.setBackGroundColorOfViews(position);

    }

    @Override
    public void onLastClick2(String s, int position) {
        userAnswerSelected2=s;
        myCustomerAdapter2.setBackGroundColorOfViews(position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                if(!TextUtils.isEmpty(userAnswerSelected2) &&  !TextUtils.isEmpty(userAnswerSelected1)){

                    Log.d("correctAnser<<<<<<<",cricketModel.getCorrectAnswer());
                    Log.d("correctAnser<<<<<<<",userAnswerSelected1);

                    if(userAnswerSelected1.equals(cricketModel.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
                    if(userAnswerSelected2.equals(cricketModel2.getCorrectAnswer())){
                        totalScore = totalScore+1;
                    }
//                    Toast.makeText(getActivity(),""+totalScore,Toast.LENGTH_SHORT).show();
                    Log.d("QuizListActivity<<<",""+totalScore);

                    listener.onfinishClick();

                } else{
                    Toast.makeText(getActivity(),"Please give both answers",Toast.LENGTH_SHORT).show();

                }
        }


    }

    public  void setFinishClickListener(FinishClickListener listener){
        this.listener = listener;
    }


    interface FinishClickListener{
        void onfinishClick();
    }
}
