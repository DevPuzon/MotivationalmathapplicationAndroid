package com.softwaresolution.motivationalmathapplication;

import android.app.ProgressDialog;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityFragment extends Fragment implements View.OnClickListener{
    View v;
    private Button bttn_register;
    private EditText editxt_username,editxt_password;
    private TextView textview_signup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_activity, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(    getActivity());
        bttn_register = (Button) v.findViewById(R.id.bttn_Register);
        editxt_username = (EditText) v.findViewById(R.id.editxt_username);
        editxt_password = (EditText) v.findViewById(R.id.editxt_password);
        textview_signup = (TextView) v.findViewById(R.id.textview_signup);

        bttn_register.setOnClickListener(this);
        textview_signup.setOnClickListener(this);
        return v;
    }

    private void userRegister(){
        String username = editxt_username.getText().toString().trim();
        String password = editxt_password.getText().toString().trim();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(getContext(),"Please enter you username", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getContext(),"Please enter you password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering user....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(username,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(),"Could not register",Toast.LENGTH_SHORT).show();
                        }
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
