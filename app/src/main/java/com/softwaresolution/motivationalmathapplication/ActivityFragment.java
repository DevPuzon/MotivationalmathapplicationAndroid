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
import android.widget.Button;
import android.widget.EditText;
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

public class ActivityFragment extends Fragment implements View.OnClickListener{
    View v;
    private Button bttn_register;
    private EditText editxt_username,editxt_password;
    private TextView textview_signup;
    private ProgressDialog progressDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_activity, container, false);
        progressDialog = new ProgressDialog(getActivity());
        bttn_register = (Button) v.findViewById(R.id.bttn_Register);
        editxt_username = (EditText) v.findViewById(R.id.editxt_username);
        editxt_password = (EditText) v.findViewById(R.id.editxt_password);
        textview_signup = (TextView) v.findViewById(R.id.textview_signup);

        bttn_register.setOnClickListener(this);
        textview_signup.setOnClickListener(this);
        return v;
    }

    List<LoginTeacher> loginTeachers;
    private void userRegister(){
         final String username = editxt_username.getText().toString();
         final String password = editxt_password.getText().toString();

//        if(TextUtils.isEmpty(username)){
//            Toast.makeText(getContext(),"Please enter you username", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if(TextUtils.isEmpty(password)){
//            Toast.makeText(getContext(),"Please enter you password", Toast.LENGTH_LONG).show();
//            return;
//        }

        loginTeachers = new ArrayList<LoginTeacher>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("TeacherForm");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loginTeachers.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    LoginTeacher loginTeacher1 = dataSnapshot1.getValue(LoginTeacher.class);
                    loginTeachers.add(loginTeacher1);
                }
                for (int i = 0;i < loginTeachers.size();i++){
                    if(username.equals(loginTeachers.get(i).teacherName)
                            && password.equals(loginTeachers.get(i).teacherPassword)){
                        Toast.makeText(getContext(),"Success",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(getContext(),"Failed",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),"Database error",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == bttn_register){
            userRegister();
        }
        if(view == textview_signup){

        }
    }
}
