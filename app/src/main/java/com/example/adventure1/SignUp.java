package com.example.adventure1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    ImageView logo;
    TextView title;
    TextInputLayout regFullName, regUsername, regEmail, regPhoneNo, regPassword;
    TextInputEditText eFullName, eUsername, eEmail, ePhoneNo, ePassword;
    Button regBtn, goLogin;
    boolean pass = false;

    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mFirebaseAuth = FirebaseAuth.getInstance();
        //input edit text
        eFullName = findViewById(R.id.inputFullName);
        eUsername = findViewById(R.id.inputUsername);
        eEmail = findViewById(R.id.inputEmail);
        ePhoneNo = findViewById(R.id.inputPhoneNo);
        ePassword = findViewById(R.id.inputPassword);
        //For animation
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.titleSignUp);
        regFullName = findViewById(R.id.titleFullName);
        regUsername = findViewById(R.id.titleUsername);
        regEmail = findViewById(R.id.titleEmail);
        regPhoneNo = findViewById(R.id.titlePhoneNo);
        regPassword = findViewById(R.id.titlePassword);
        regBtn = findViewById(R.id.buttonSignUp);
        goLogin = findViewById(R.id.buttonLogin);

        regBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String fullName = eFullName.getText().toString();
                String username = eUsername.getText().toString();
                String email = eEmail.getText().toString();
                String phoneNo = ePhoneNo.getText().toString();
                String password = ePassword.getText().toString();

                if (fullName.isEmpty()) {
                    eFullName.setError("Please fill in!!!");
                    eFullName.requestFocus();
                } else if (username.isEmpty()) {
                    eUsername.setError("Please fill in!!!");
                    eUsername.requestFocus();
                } else if (email.isEmpty()) {
                    eEmail.setError("Please fill in!!!");
                    eEmail.requestFocus();
                } else if (phoneNo.isEmpty()) {
                    ePhoneNo.setError("Please fill in!!!");
                    ePhoneNo.requestFocus();
                } else if (password.isEmpty()) {
                    ePassword.setError("Please fill in!!!");
                    ePassword.requestFocus();
                } else {
                    pass = true;
                }
                if (pass == true) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, Home.class);
                                Pair[] pairs = new Pair[9];
                                pairs[0] = new Pair<View, String>(logo, "logo_image");
                                pairs[1] = new Pair<View, String>(title, "logo_text");
                                pairs[2] = new Pair<View, String>(regFullName, "fullname_tran");
                                pairs[3] = new Pair<View, String>(regUsername, "username_tran");
                                pairs[4] = new Pair<View, String>(regEmail, "email_tran");
                                pairs[5] = new Pair<View, String>(regPhoneNo, "phoneno_tran");
                                pairs[6] = new Pair<View, String>(regPassword, "password_tran");
                                pairs[7] = new Pair<View, String>(regBtn, "button_tran");
                                pairs[8] = new Pair<View, String>(goLogin, "login_signup_tran");

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                                    startActivity(intent, options.toBundle());
                                } else {
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        });
        goLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                Pair[] pairs = new Pair[9];
                pairs[0] = new Pair<View, String>(logo, "logo_image");
                pairs[1] = new Pair<View, String>(title, "logo_text");
                pairs[2] = new Pair<View, String>(regFullName, "fullname_tran");
                pairs[3] = new Pair<View, String>(regUsername, "username_tran");
                pairs[4] = new Pair<View, String>(regEmail, "email_tran");
                pairs[5] = new Pair<View, String>(regPhoneNo, "phoneno_tran");
                pairs[6] = new Pair<View, String>(regPassword, "password_tran");
                pairs[7] = new Pair<View, String>(regBtn, "button_tran");
                pairs[8] = new Pair<View, String>(goLogin, "login_signup_tran");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}