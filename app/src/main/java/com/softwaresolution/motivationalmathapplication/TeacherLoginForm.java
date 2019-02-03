package com.softwaresolution.motivationalmathapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeacherLoginForm extends AppCompatActivity {
    private EditText editText_TeacherUsername, editText_TeacherPassword;
    private Button button_TeacherLogin;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_form);
        button_TeacherLogin = (Button) findViewById(R.id.button_TeacherLogin);
        editText_TeacherUsername = (EditText) findViewById(R.id.edittext_TeacherUsername);
        editText_TeacherPassword = (EditText) findViewById(R.id.edittext_TeacherPassword);

        button_TeacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
