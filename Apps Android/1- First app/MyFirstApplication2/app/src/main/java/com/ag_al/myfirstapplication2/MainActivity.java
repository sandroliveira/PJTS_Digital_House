package com.ag_al.myfirstapplication2;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int countb1 = 0;
    int countb2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void onButton1(View view){
        final TextView textView = findViewById(R.id.textView);

        switch (countb1){

            case 0:
                countb1 = 1;
                textView.setTextColor(Color.rgb( 0, 255, 94));//GREEN
                break;

            case 1:
                countb1 = 2;
                textView.setTextColor(Color.rgb(255, 247, 0));//YELLOW
                break;

            case 2:
                countb1 = 0;
                textView.setTextColor(Color.rgb( 162, 0, 255));//PURPLE
                break;
        }

    }

    public void onButton2(View v){
        final LinearLayout linearLayout = findViewById(R.id.layout);
        Random random = new Random();

        switch (countb2){
            case 0:
                countb2 = 1;
                linearLayout.setBackgroundColor(Color.parseColor("#FFF2353C"));
                break;
            case 1:
                countb2 = 2;
                linearLayout.setBackgroundColor(Color.parseColor("#FF1A1A1A"));
                break;
            case 2:
                countb2 = 0;
                linearLayout.setBackgroundColor(Color.parseColor("#FFFF5E00"));
                break;
            default:
                break;
        }
    }
}
