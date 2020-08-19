package com.example.quizapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.example.quizapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btnLogin;
    AppCompatEditText et_email,et_name;
    TextInputLayout layout_email,layout_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        et_email = findViewById(R.id.et_email);
        et_name = findViewById(R.id.et_name);
        layout_email = findViewById(R.id.layout_email);
        layout_name = findViewById(R.id.layout_name);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login:
                if(TextUtils.isEmpty(et_email.getText().toString())){
                    layout_email.setError("Please enter Email");
                } else if(!isValidEmail(et_email.getText().toString())){
                    layout_email.setError("Please enter valid email");
                }  else if(TextUtils.isEmpty(et_name.getText().toString())){
                    layout_name.setError("Please enter Name");
                }else {
                    Intent intent = new Intent(this, MainQuizActivty.class);
                    startActivity(intent);
                }
        }
    }



    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
