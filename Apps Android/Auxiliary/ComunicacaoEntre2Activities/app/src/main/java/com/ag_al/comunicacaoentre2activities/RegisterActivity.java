package com.ag_al.comunicacaoentre2activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText confirmPwd;
    Button register2;

    TextInputLayout textInputUsername;
    TextInputLayout textInputPassword;
    TextInputLayout textInputConfirmPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputUsername = (TextInputLayout) findViewById(R.id.textInputUsername);
        textInputPassword = (TextInputLayout) findViewById(R.id.textInputPwd);
        textInputConfirmPwd = (TextInputLayout) findViewById(R.id.textInputConfirmPwd);
        

        register2 = (Button) findViewById(R.id.registerButton2);
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textInputPassword.getEditText().getText().toString().equals(textInputConfirmPwd.getEditText().getText().toString())) {
                    Intent intent = new Intent(RegisterActivity.this, LoginRegister.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", textInputUsername.getEditText().getText().toString());
                    bundle.putString("pwd", textInputPassword.getEditText().getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Account registered successfully", Toast.LENGTH_SHORT).show(); 

                }else{
                    textInputConfirmPwd.setError("Passwords do not match. Try again");
                    //Toast.makeText(RegisterActivity.this, "As senhas não coincidem. Tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }



}

