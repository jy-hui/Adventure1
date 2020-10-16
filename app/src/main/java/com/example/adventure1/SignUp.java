package com.example.adventure1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout regFullName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, goLogin;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        regFullName = findViewById(R.id.titleFullName);
        regUsername = findViewById(R.id.titleUsername);
        regEmail = findViewById(R.id.titleEmail);
        regPhoneNo = findViewById(R.id.titlePhoneNo);
        regPassword = findViewById(R.id.titlePassword);
        regBtn = findViewById(R.id.buttonSignUp);
        goLogin = findViewById(R.id.buttonLogin);

        regBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String fullName = regFullName.getEditText().toString();
                String username = regUsername.getEditText().toString();
                String email = regEmail.getEditText().toString();
                String phoneNo = regPhoneNo.getEditText().toString();
                String password = regPassword.getEditText().toString();

                UserHelper helperClass = new UserHelper(fullName, username, email, phoneNo, password);
                reference.setValue("First data storage");


            }
        });
    }
}