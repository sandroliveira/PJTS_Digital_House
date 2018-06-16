package com.ag_al.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onDisplay(View v){
        edit = (EditText)findViewById(R.id.plain_text_input);
        String message = edit.getText().toString();
        Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
    }



}
