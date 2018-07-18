package com.ag_al.formactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SentActivity extends AppCompatActivity {
    TextView textName,textNickname,textAge,textCareer,textEmail,textChecklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);

        textName = (TextView) findViewById(R.id.textName);
        textNickname = (TextView) findViewById(R.id.textNickname);
        textAge = (TextView) findViewById(R.id.textAge);
        textCareer = (TextView) findViewById(R.id.textCareer);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textChecklist = (TextView) findViewById(R.id.textInformation);

        Bundle bundle = getIntent().getExtras();
        textName.setText("Name: " + bundle.getString("name"));
        textNickname.setText("Nickname: " + bundle.getString("nickname"));
        textAge.setText("Age: " + bundle.getString("age"));
        textCareer.setText("Career: " + bundle.getString("career"));
        textEmail.setText("Email: " + bundle.getString("email"));
        textChecklist.setText(bundle.getString("checkbox"));




    }
}
