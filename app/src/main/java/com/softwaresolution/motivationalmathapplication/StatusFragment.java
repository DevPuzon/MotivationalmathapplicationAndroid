package com.softwaresolution.motivationalmathapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatusFragment extends Fragment {
    private EditText editTextQuestion,editTextAnswer;
    private Button buttonSave;
    DatabaseReference databaseReference;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_staus, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("TeacherForm");
        editTextQuestion = (EditText) v.findViewById(R.id.editTextQuestion);
        editTextAnswer = (EditText) v.findViewById(R.id.editTextAnswer);
        buttonSave = (Button) v.findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQuestion();
            }
        });
        return  v;
    }

    private  void addQuestion(){
        String teacherName = editTextQuestion.getText().toString().trim();
        String teacherPassword = editTextAnswer.getText().toString().trim();
        if(TextUtils.isEmpty(teacherName)){
            Toast.makeText(getContext(),"Please enter your teacher name", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(teacherPassword)){
            Toast.makeText(getContext(),"Please enter your password", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            teacherData teacherData = new teacherData(teacherName,teacherPassword);
            databaseReference.child(teacherName).setValue(teacherData);
        }catch (Exception ex){
            Toast.makeText(getContext(),ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();
    }
}
//