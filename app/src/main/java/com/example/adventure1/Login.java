package com.example.adventure1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    ImageButton goSignUp;
    ImageView logo;
    TextView title;
    TextInputLayout email, password;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        goSignUp = findViewById(R.id.buttonSignUp);
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);
        email = findViewById(R.id.titleEmail);
        password = findViewById(R.id.titlePassword);
        login_btn = findViewById(R.id.buttonLogin);

        goSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View,String>(logo,"logo_image");
                pairs[1] = new Pair<View,String>(title,"logo_text");
                pairs[2] = new Pair<View,String>(email,"email_tran");
                pairs[3] = new Pair<View,String>(logo,"password_tran");
                pairs[4] = new Pair<View,String>(login_btn,"button_tran");
                pairs[5] = new Pair<View,String>(goSignUp,"login_signup_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                    startActivity(intent, options.toBundle());
                }

            }
        });

    }
}