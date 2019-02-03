package com.softwaresolution.motivationalmathapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentLoginForm extends AppCompatActivity {
    private EditText editText_StudentUsername, editText_StudentPassword;
    private Button button_StudentLogin;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_form);
        button_StudentLogin = (Button) findViewById(R.id.button_StudentLogin);
        editText_StudentUsername = (EditText) findViewById(R.id.edittext_StudentUsername);
        editText_StudentPassword = (EditText) findViewById(R.id.edittext_StudentPassword);

        button_StudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMainActivity();
            }
        });
    }
    private void  showMainActivity(){
        Intent intent = new Intent(this,TeacherLoginForm.class);
        startActivity(intent);
    }
}