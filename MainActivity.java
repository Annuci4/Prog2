package com.example.annak.colorsmatchapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_button, iv_heart;
    TextView points;
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;

    Random r;

    private final static int STATE_PINK = 1;
    private final static int STATE_PURPLE = 2;
    private final static int STATE_RED = 3;
    private final static int STATE_BURGUNDI = 4;

    int buttonState = STATE_PINK;
    int heartState = STATE_PINK;

    int currentTime = 4000;
    int startTime= 4000;

    int currentPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_button=findViewById(R.id.iv_button);
        iv_heart=findViewById(R.id.iv_heart);
        points = findViewById(R.id.points);
        progressBar= findViewById(R.id.progressBar);



        progressBar.setMax(startTime);
        progressBar.setProgress(startTime);

        points.setText("Points: "+ currentPoints);

        r= new Random();
        heartState= r.nextInt(4)+1;
        setHeartImage(heartState);

        iv_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setButtonImage(setButtonPosition(buttonState));
            }
        });
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime -100;
                progressBar.setProgress(currentTime);
                if (currentTime > 0){
                    handler.postDelayed(runnable, 100);
                }else{
                    if (buttonState == heartState){
                        currentPoints = currentPoints + 1;
                        points.setText("Points: "+ currentPoints);

                        startTime= startTime - 100;
                        if (startTime < 1000){
                            startTime = 2000;
                        }
                        progressBar.setMax(startTime);
                        currentTime = startTime;
                        progressBar.setProgress(currentTime);

                        heartState= r.nextInt(4)+1;
                        setHeartImage(heartState);

                        handler.postDelayed(runnable, 100);

                    }else{
                        iv_button.setEnabled(false);
                        Toast.makeText(MainActivity.this, "Game Over!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        handler.postDelayed(runnable,100);
    }
    private void setHeartImage(int state){
        switch (state){
            case STATE_PINK:
                iv_heart.setImageResource(R.drawable.pink);
                heartState=STATE_PINK;
                break;
            case STATE_PURPLE:
                iv_heart.setImageResource(R.drawable.purple);
                heartState=STATE_PURPLE;
                break;
             case STATE_RED:
                iv_heart.setImageResource(R.drawable.red);
                heartState=STATE_RED;
                break;
            case STATE_BURGUNDI:
                iv_heart.setImageResource(R.drawable.burgundi);
                heartState=STATE_BURGUNDI;
                break;
        }
    }
    private void setRotation(final ImageView image, final int drawable){
        RotateAnimation rotateAnimation = new RotateAnimation(0,90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setImageResource(drawable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(rotateAnimation);

    }
    private int setButtonPosition(int position){
        position = position + 1;
        if (position == 5){
            position = 1;
        }
        return position;
    }
    private void setButtonImage(int state){
        switch (state){
            case STATE_PINK:
                setRotation(iv_button, R.drawable.c_pink);
                buttonState=STATE_PINK;
                break;
            case STATE_PURPLE:
            setRotation(iv_button, R.drawable.c_purple);
            buttonState=STATE_PURPLE;
            break;
            case STATE_RED:
                setRotation(iv_button, R.drawable.c_red);
                buttonState=STATE_RED;
                break;
            case STATE_BURGUNDI:
                setRotation(iv_button, R.drawable.c_burgundi);
                buttonState=STATE_BURGUNDI;
                break;

        }
    }
}
