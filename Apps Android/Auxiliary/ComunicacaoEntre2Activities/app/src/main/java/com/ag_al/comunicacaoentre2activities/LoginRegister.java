package com.ag_al.comunicacaoentre2activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginRegister extends AppCompatActivity implements View.OnClickListener {

   /*EditText username;
    EditText password;*/

   TextInputLayout usernameLogin;
   TextInputLayout passwordLogin;

    Button login;
    Button register;
    String userBundle;
    String pwdBundle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle bundle = getIntent().getExtras();
            userBundle = bundle.getString("user");
            pwdBundle = bundle.getString("pwd");
        }catch (Exception e){

        }

        usernameLogin = (TextInputLayout) findViewById(R.id.textInputUsernameLogin);
        passwordLogin = (TextInputLayout)findViewById(R.id.textInputPwdLogin);



       /* username = (EditText) findViewById(R.id.editUsername1);
        password = (EditText) findViewById(R.id.editPassword1);*/

        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(this);
        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.loginButton:
                try{
                    if (userBundle.equals(usernameLogin.getEditText().getText().toString()) && pwdBundle.equals(passwordLogin.getEditText().getText().toString())){
                        Intent intent = new Intent(LoginRegister.this,LoginActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username", userBundle);
                        intent.putExtras(bundle);
                        Snackbar.make(view, "Message is deleted", Snackbar.LENGTH_LONG).show();
                        startActivity(intent);

                    }else{
                        passwordLogin.setError("Invalid user and/or password. Please try again.");
                    }
                }catch (Exception e){

                }

                break;
            case R.id.registerButton:
                startActivity(new Intent(LoginRegister.this, RegisterActivity.class));
        }

    }
}
