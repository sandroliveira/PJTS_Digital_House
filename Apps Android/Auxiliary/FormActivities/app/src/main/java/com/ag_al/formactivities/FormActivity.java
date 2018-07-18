package com.ag_al.formactivities;

import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private TextInputLayout name,nickname,age,career,email;
    private CheckBox checkOne,checkTwo,checkThree;
    private Button sent;
    private StringBuilder selectBox = new StringBuilder("");
    private int count = 1;
    private boolean pass,one,two,three,four,five,six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = (TextInputLayout) findViewById(R.id.textInputName);
        nickname = (TextInputLayout) findViewById(R.id.textInputNickname);
        age = (TextInputLayout) findViewById(R.id.textInputAge);
        career = (TextInputLayout) findViewById(R.id.textInputCareer);
        email = (TextInputLayout) findViewById(R.id.textInputEmail);


        checkOne = (CheckBox) findViewById(R.id.checkBox);
        checkTwo = (CheckBox) findViewById(R.id.checkBox2);
        checkThree = (CheckBox) findViewById(R.id.checkBox3);

        sent = (Button) findViewById(R.id.sent);
    }

    public void sentButton(View view){

        while(count < 8){
            switch (count){
                case 1:
                    if (name.getEditText().getText().length() == 0){
                        name.setError("Is empty");
                    }else {
                        one = true;
                        name.setErrorEnabled(false);
                    }
                    break;
                case 2:
                    if (nickname.getEditText().getText().length() == 0){
                        nickname.setError("Is empty");
                    }else {
                        two = true;
                        nickname.setErrorEnabled(false);
                    }
                    break;
                case 3:
                    if (age.getEditText().getText().length() == 0){
                        age.setError("Is empty");
                    }else{
                        three = true;
                        age.setErrorEnabled(false);
                    }
                    break;
                case 4:
                    if (career.getEditText().getText().length() == 0){
                        career.setError("Is empty");
                    }else{
                        four = true;
                        career.setErrorEnabled(false);
                    }
                    break;
                case 5:
                    if (email.getEditText().getText().length() == 0){
                        email.setError("Is empty");
                    }else{
                        five = true;
                        email.setErrorEnabled(false);
                    }
                    break;
                case 6:
                    if (checkOne.isChecked() || checkTwo.isChecked() || checkThree.isChecked()){
                        selectBox.delete(0,selectBox.length());
                        if (checkOne.isChecked()) {
                            six = true;
                            selectBox.append("Tournaments ");
                        }
                        if(checkTwo.isChecked()) {
                            six = true;
                            selectBox.append("Meeting ");
                        }
                        if(checkThree.isChecked()) {
                            six = true;
                            selectBox.append("Barbecue");
                        }

                    }else{
                        Toast.makeText(this, "You must choose one of the checklist above", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                   if(one == true && two == true && three == true && four == true && five == true && six == true){
                       pass = true;

                   }

            }
            count +=1;


        }
        count = 1;

        if (pass == true){
            Intent intent = new Intent(FormActivity.this, SentActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", name.getEditText().getText().toString());
            bundle.putString("nickname", nickname.getEditText().getText().toString());
            bundle.putString("age", age.getEditText().getText().toString());
            bundle.putString("career", career.getEditText().getText().toString());
            bundle.putString("email", email.getEditText().getText().toString());
            bundle.putString("checkbox", selectBox.toString());
            intent.putExtras(bundle);
            startActivity(intent);

        }

    }



}
