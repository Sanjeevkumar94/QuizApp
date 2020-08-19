package com.example.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.model.CricketModel;

import java.util.ArrayList;

import static com.example.quizapp.utils.CommonUtils.btnAnswer1;
import static com.example.quizapp.utils.CommonUtils.btnAnswer2;
import static com.example.quizapp.utils.CommonUtils.btnAnswer2_1;
import static com.example.quizapp.utils.CommonUtils.btnAnswer2_2;
import static com.example.quizapp.utils.CommonUtils.btnAnswer2_3;
import static com.example.quizapp.utils.CommonUtils.btnAnswer2_4;
import static com.example.quizapp.utils.CommonUtils.btnAnswer3;
import static com.example.quizapp.utils.CommonUtils.btnAnswer4;
import static com.example.quizapp.utils.CommonUtils.btnCorrectAnswer;
import static com.example.quizapp.utils.CommonUtils.btnCorrectAnswer2;
import static com.example.quizapp.utils.CommonUtils.btnQuestion;
import static com.example.quizapp.utils.CommonUtils.btnQuestion2;
import static com.example.quizapp.utils.CommonUtils.cbAnswer1;
import static com.example.quizapp.utils.CommonUtils.cbAnswer2;
import static com.example.quizapp.utils.CommonUtils.cbAnswer2_1;
import static com.example.quizapp.utils.CommonUtils.cbAnswer2_2;
import static com.example.quizapp.utils.CommonUtils.cbAnswer2_3;
import static com.example.quizapp.utils.CommonUtils.cbAnswer2_4;
import static com.example.quizapp.utils.CommonUtils.cbAnswer3;
import static com.example.quizapp.utils.CommonUtils.cbAnswer4;
import static com.example.quizapp.utils.CommonUtils.cbCorrectAnswer;
import static com.example.quizapp.utils.CommonUtils.cbCorrectAnswer2;
import static com.example.quizapp.utils.CommonUtils.cbQuestion;
import static com.example.quizapp.utils.CommonUtils.cbQuestion2;
import static com.example.quizapp.utils.CommonUtils.rbAnswer1;
import static com.example.quizapp.utils.CommonUtils.rbAnswer2;
import static com.example.quizapp.utils.CommonUtils.rbAnswer2_1;
import static com.example.quizapp.utils.CommonUtils.rbAnswer2_2;
import static com.example.quizapp.utils.CommonUtils.rbAnswer2_3;
import static com.example.quizapp.utils.CommonUtils.rbAnswer2_4;
import static com.example.quizapp.utils.CommonUtils.rbAnswer3;
import static com.example.quizapp.utils.CommonUtils.rbAnswer4;
import static com.example.quizapp.utils.CommonUtils.rbCorrectAnswer;
import static com.example.quizapp.utils.CommonUtils.rbCorrectAnswer2;
import static com.example.quizapp.utils.CommonUtils.rbQuestion;
import static com.example.quizapp.utils.CommonUtils.rbQuestion2;
import static com.example.quizapp.utils.CommonUtils.rvAnswer1;
import static com.example.quizapp.utils.CommonUtils.rvAnswer2;
import static com.example.quizapp.utils.CommonUtils.rvAnswer2_1;
import static com.example.quizapp.utils.CommonUtils.rvAnswer2_2;
import static com.example.quizapp.utils.CommonUtils.rvAnswer2_3;
import static com.example.quizapp.utils.CommonUtils.rvAnswer2_4;
import static com.example.quizapp.utils.CommonUtils.rvAnswer3;
import static com.example.quizapp.utils.CommonUtils.rvAnswer4;
import static com.example.quizapp.utils.CommonUtils.rvCorrectAnswer;
import static com.example.quizapp.utils.CommonUtils.rvCorrectAnswer2;
import static com.example.quizapp.utils.CommonUtils.rvQuestion;
import static com.example.quizapp.utils.CommonUtils.rvQuestion2;
import static com.example.quizapp.utils.CommonUtils.totalScore;

public class MainQuizActivty extends AppCompatActivity implements QuizButtonFragment.onNextClickListener,QuizCheckBoxFragment.onNextClickCheckboxListener,RadioButtonFragment.onNextClickCheckboxListener,QuizImagesActivity.onNextClickImageListener,QuizListActivity.FinishClickListener {

    ArrayList<CricketModel> listCricketQuestions;
    ArrayList<String> listAnswers;
    ArrayList<String> listAnswers2;
    ArrayList<String> listCheckBoxAns;
    ArrayList<String> listCheckBoxAns2;
    ArrayList<String> listRadioButtonAns;
    ArrayList<String> listRadioButtonAns2;
    ArrayList<String> recyclerViewAns;
    ArrayList<String> recyclerViewAns2;

    QuizButtonFragment quizButtonFragment;
    QuizCheckBoxFragment quizCheckBoxFragment;

    RadioButtonFragment radioButtonFragment;
    QuizImagesActivity  quizImagesActivity;
    QuizListActivity quizListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz_activty);

        listAnswers  = new ArrayList<>();
        listAnswers.add(btnAnswer1);
        listAnswers.add(btnAnswer2);
        listAnswers.add(btnAnswer3);
        listAnswers.add(btnAnswer4);

        listAnswers2  = new ArrayList<>();
        listAnswers2.add(btnAnswer2_1);
        listAnswers2.add(btnAnswer2_2);
        listAnswers2.add(btnAnswer2_3);
        listAnswers2.add(btnAnswer2_4);

        listCheckBoxAns = new ArrayList();
        listCheckBoxAns.add(cbAnswer1);
        listCheckBoxAns.add(cbAnswer2);
        listCheckBoxAns.add(cbAnswer3);
        listCheckBoxAns.add(cbAnswer4);

        listCheckBoxAns2 = new ArrayList<>();
        listCheckBoxAns2.add(cbAnswer2_1);
        listCheckBoxAns2.add(cbAnswer2_2);
        listCheckBoxAns2.add(cbAnswer2_3);
        listCheckBoxAns2.add(cbAnswer2_4);

        listRadioButtonAns =new ArrayList<>();
        listRadioButtonAns.add(rbAnswer1);
        listRadioButtonAns.add(rbAnswer2);
        listRadioButtonAns.add(rbAnswer3);
        listRadioButtonAns.add(rbAnswer4);

        listRadioButtonAns2 =new ArrayList<>();
        listRadioButtonAns2.add(rbAnswer2_1);
        listRadioButtonAns2.add(rbAnswer2_2);
        listRadioButtonAns2.add(rbAnswer2_3);
        listRadioButtonAns2.add(rbAnswer2_4);

        recyclerViewAns = new ArrayList<>();
        recyclerViewAns.add(rvAnswer1);
        recyclerViewAns.add(rvAnswer2);
        recyclerViewAns.add(rvAnswer3);
        recyclerViewAns.add(rvAnswer4);

        recyclerViewAns2 = new ArrayList<>();
        recyclerViewAns2.add(rvAnswer2_1);
        recyclerViewAns2.add(rvAnswer2_2);
        recyclerViewAns2.add(rvAnswer2_3);
        recyclerViewAns2.add(rvAnswer2_4);





        listCricketQuestions = new ArrayList<>();
        listCricketQuestions.add(new CricketModel(btnQuestion,listAnswers,btnCorrectAnswer));
        listCricketQuestions.add(new CricketModel(btnQuestion2,listAnswers2,btnCorrectAnswer2));
        listCricketQuestions.add(new CricketModel(cbQuestion,listCheckBoxAns,cbCorrectAnswer));
        listCricketQuestions.add(new CricketModel(cbQuestion2,listCheckBoxAns2,cbCorrectAnswer2));
        listCricketQuestions.add(new CricketModel(rbQuestion,listRadioButtonAns,rbCorrectAnswer));
        listCricketQuestions.add(new CricketModel(rbQuestion2,listRadioButtonAns2,rbCorrectAnswer2));
        listCricketQuestions.add(new CricketModel(rvQuestion,recyclerViewAns,rvCorrectAnswer));
        listCricketQuestions.add(new CricketModel(rvQuestion2,recyclerViewAns2,rvCorrectAnswer2));

        quizButtonFragment = new QuizButtonFragment();
        quizButtonFragment.setNextClickListener(this);
        loadFragment(quizButtonFragment,0,1);

        quizCheckBoxFragment = new QuizCheckBoxFragment();
        quizCheckBoxFragment.setNextClickListener(this);


        radioButtonFragment = new RadioButtonFragment();
        radioButtonFragment.setNextClickListener(this);

        quizImagesActivity = new QuizImagesActivity();
        quizImagesActivity.setNextClickListener(this);

        quizListActivity = new QuizListActivity();
        quizListActivity.setFinishClickListener(this);



        Log.d("anser<<<<",listCricketQuestions.get(0).getAnswers().get(0));
    }

    private void loadFragment(Fragment fragment, int i, int j) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("data", listCricketQuestions.get(i));
        bundle.putSerializable("data2", listCricketQuestions.get(j));

        fragment.setArguments(bundle);

        // create a FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onNextClick() {
        loadFragment(quizCheckBoxFragment,2,3);
    }

    @Override
    public void onCheckboxNextClick() {
        loadFragment(radioButtonFragment,4,5);
    }

    @Override
    public void onRadioBtnxNextClick() {

        loadFragment(quizImagesActivity,0,1);
    }

    @Override
    public void onImageBtnxNextClick() {
    loadFragment(quizListActivity,6,7);
    }

    @Override
    public void onfinishClick() {
        startActivity(new Intent(this,ScoreActivity.class));
        finish();
    }
}
