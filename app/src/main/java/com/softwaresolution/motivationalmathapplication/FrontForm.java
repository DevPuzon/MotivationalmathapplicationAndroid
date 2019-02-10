package com.softwaresolution.motivationalmathapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class FrontForm extends AppCompatActivity {
    private CardView button_teacher,button_student;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_form);
        button_teacher = (CardView) findViewById(R.id.button_teacher);
        button_student = (CardView) findViewById(R.id.button_student);
        button_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTeacherLoginForm();
            }
        });
        button_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStudentLoginForm();
            }
        });
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        button_teacher.startAnimation(animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.sample_anim);
        button_student.startAnimation(animation2);
    }

    private void showTeacherLoginForm(){
        Intent intent = new Intent(this,TeacherLoginForm.class);
        startActivity(intent);
    }
    private void showStudentLoginForm(){
        Intent intent = new Intent(this,StudentLoginForm.class);
        startActivity(intent);
    }
}
