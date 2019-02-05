package com.softwaresolution.motivationalmathapplication;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragment extends Fragment{
    View v;
    private ListView listView_quizList;

    List<String> quizLists;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_activity, container, false);
        listView_quizList = (ListView) v.findViewById(R.id.listView_quizList);
        quizLists = new ArrayList<>();
        listView_quizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                int trueIndex = i + 1;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuizActivity()).commit();
            }
        });
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        DatabaseReference databaseReferenceQuiz = FirebaseDatabase.getInstance().getReference("TeacherForm").child("qw").child("QuizNumber");
        databaseReferenceQuiz.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    QuizNumber getQuiz = dataSnapshot.getValue(QuizNumber.class);
                    for (int i = 1; i <= Integer.parseInt(getQuiz.getQuizNumber()); ++i){
                        quizLists.add("Quiz No " + String.valueOf(i));
                    }
                }catch (Exception ex){
                    Toast.makeText(getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
                QuizListLayout quizListLayout = new QuizListLayout(getActivity(),quizLists);
                listView_quizList.setAdapter(quizListLayout);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
//        DatabaseReference dbQuizList = FirebaseDatabase.getInstance().getReference("TeacherForm").child("qw").child("Quiz");
//        dbQuizList.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                quizLists.clear();
//                try {
//                    for (DataSnapshot dsQuizList : dataSnapshot.getChildren()){
//                        QuizList quizList = dsQuizList.getValue(QuizList.class);
////                        quizLists.add(quizList);
//                    }
//                }catch (Exception ex){
//                    Toast.makeText(getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
//                }
////                QuizListLayout quizListLayout = new QuizListLayout(getActivity(),quizLists);
////                listView_quizList.setAdapter(quizListLayout);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(getContext(),"Database Error",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private void getQuizNumber(){
        DatabaseReference databaseReferenceQuiz = FirebaseDatabase.getInstance().getReference("TeacherForm").child("qw").child("QuizNumber");
        databaseReferenceQuiz.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    QuizNumber getQuiz = dataSnapshot.getValue(QuizNumber.class);
                }catch (Exception ex){
                    Toast.makeText(getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
