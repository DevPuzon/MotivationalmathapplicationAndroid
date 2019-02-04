package com.softwaresolution.motivationalmathapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentLoginForm extends AppCompatActivity {
    private EditText editText_StudentUsername, editText_StudentPassword;
    private Button button_StudentLogin;
    private TextView textView_studentReg;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_form);
        button_StudentLogin = (Button) findViewById(R.id.button_StudentLogin);
        editText_StudentUsername = (EditText) findViewById(R.id.edittext_StudentUsername);
        editText_StudentPassword = (EditText) findViewById(R.id.edittext_StudentPassword);
        textView_studentReg = (TextView) findViewById(R.id.textview_studentSignup);

        button_StudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMainActivity();
            }
        });
        textView_studentReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStudentReg();
            }
        });
    }
    private void  showMainActivity(){
        Intent intent = new Intent(this,TeacherLoginForm.class);
        startActivity(intent);
    }
    private void showStudentReg(){
        Intent intent = new Intent(this,StudentRegistration.class);
        startActivity(intent);
    }
}