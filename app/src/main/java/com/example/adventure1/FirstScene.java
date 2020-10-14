package com.example.adventure1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class FirstScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_scene);
        public void onClick(View view) {
            Intent intent = new Intent(FirstScene.this, Login.class);
            startActivity(intent);
        }
    }
}