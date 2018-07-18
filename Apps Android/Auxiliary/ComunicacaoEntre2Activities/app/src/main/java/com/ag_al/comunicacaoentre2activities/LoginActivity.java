package com.ag_al.comunicacaoentre2activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        texto = (TextView) findViewById(R.id.te);

        try {
            Bundle bundle = getIntent().getExtras();
            texto.setText("Welcome" +" "+ bundle.getString("username"));
        }catch (Exception e){

        }


    }
}
