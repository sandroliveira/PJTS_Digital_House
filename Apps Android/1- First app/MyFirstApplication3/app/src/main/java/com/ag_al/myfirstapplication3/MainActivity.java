package com.ag_al.myfirstapplication3;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
public final static String TEXT_LOG = "MainActivity";
int reject = 100;
int accept = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button4 = findViewById(R.id.button4);

        button.setSoundEffectsEnabled(false);
        button4.setSoundEffectsEnabled(false);



    }


    public void btn(View v){
        Log.v(TEXT_LOG, "Button");
        final MediaPlayer naruto = MediaPlayer.create(this, R.raw.naruto );
        final MediaPlayer sasuke = MediaPlayer.create(this, R.raw.sasuke );
        final MediaPlayer kakashi = MediaPlayer.create(this, R.raw.kakashi );

        final MediaPlayer achievement = MediaPlayer.create(this, R.raw.achievement);
        achievement.start();

        final Handler handler = new Handler();

        switch (reject){
            case 100:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        naruto.start();
                    }
                }, 1000);
                break;
            case 3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        kakashi.start();
                    }
                }, 1000);
                break;
            case 2:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sasuke.start();
                    }
                }, 1000);
                break;
            case 1:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        naruto.start();
                    }
                }, 1000);
                break;
        }





    }

    public void rjt(View v){
        ImageView imageView = findViewById(R.id.imageView);
        final MediaPlayer next = MediaPlayer.create(this, R.raw.lockoff);
        next.start();
        switch (reject){
            case 1:
                imageView.setImageResource(R.drawable.sasuke);
                reject = 2;
                break;
            case 2:
                imageView.setImageResource(R.drawable.kakashi);
                reject = 3;
                break;
            case 100:
                imageView.setImageResource(R.drawable.sasuke);
                reject = 2;
                break;
            default:
                imageView.setImageResource(R.drawable.naruto);
                reject = 1;
                break;
        }



    }


}
