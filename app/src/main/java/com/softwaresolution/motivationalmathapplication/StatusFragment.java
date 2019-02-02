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

        databaseReference = FirebaseDatabase.getInstance().getReference("Quiz");
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
        String question = editTextQuestion.getText().toString().trim();
        String answer = editTextAnswer.getText().toString().trim();
        if(TextUtils.isEmpty(question)){
            Toast.makeText(getContext(),"Please enter your question", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(answer)){
            Toast.makeText(getContext(),"Please enter your answer", Toast.LENGTH_LONG).show();
            return;
        }
        String id ;
        try {
            id = databaseReference.push().getKey();
            Quiz quiz = new Quiz(id,question,answer);
            databaseReference.child(id).setValue(quiz);
        }catch (Exception ex){
            Toast.makeText(getContext(),ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getContext(),"Addede",Toast.LENGTH_LONG).show();
    }
}
