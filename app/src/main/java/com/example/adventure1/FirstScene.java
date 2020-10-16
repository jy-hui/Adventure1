package com.example.adventure1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstScene extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    //Variables
    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.first_scene);

        ///Variables
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.app_name);

        logo.setAnimation(topAnim);
        title.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent (FirstScene.this,Login.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(logo,"logo_image");
                pairs[1] = new Pair<View,String>(title,"logo_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(FirstScene.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
                else{
                    startActivity(intent);
                }
            }
        },SPLASH_SCREEN);
    }
}