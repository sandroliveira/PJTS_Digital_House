package excurioso.ag_al.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nome;
    private TextView email;
    private ImageView perfil;

    private SignInButton signIn;
    private Button disconnect;


    public static final int RC_SIGN_IN = 1;
    GoogleSignInClient mGoogleSignInClient;
    public static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;



    // SharedPreference
    SharedPreferences sharedPreferences;
    public static final String mypreference = "mypref";
    public static final String NAME = "Name";
    public static final String IMG = "http://pngimage.net/wp-content/uploads/2018/06/perfil-icono-png-4.png";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializingViews();
    }


    public void initializingViews() {
        // variáveis da tela de perfil
        nome = findViewById(R.id.name);
        email = findViewById(R.id.email);
        perfil = findViewById(R.id.imageView);

        // Botões de login Gmail
        signIn = (SignInButton)findViewById(R.id.sign_in_button);
        signIn.setOnClickListener(this);
        disconnect = (Button) findViewById(R.id.disconnect_button);
        disconnect.setOnClickListener(this);

        // Recuperando os últimos dados salvos da tela de perfil com SharedPreference
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(NAME)) {
            nome.setText(sharedPreferences.getString(NAME, ""));
        }
        if (sharedPreferences.contains(IMG)) {
            Picasso.get().load(sharedPreferences.getString(IMG, "")).resize(300, 300).into(perfil);
        }

        // Objeto de autenticação
        mAuth = FirebaseAuth.getInstance();


        // Instanciando objeto do Gmail
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(MainActivity.this, gso);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.disconnect_button:
                disconnect();
                break;
        }
    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    public void disconnect(){
        mAuth.signOut();

        // Google revoke access

        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) { updateUI(null); }
        });

        // Resetando os dados do usuário no perfil
        nome.setText("nome");
        perfil.setImageResource(R.mipmap.ic_launcher_round);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMG, "http://pngimage.net/wp-content/uploads/2018/06/perfil-icono-png-4.png".toString());
        editor.putString(NAME, "Name");
        editor.commit();
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this,"you are not able to log in to google",Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {

        //signOut.setVisibility(View.VISIBLE);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();


            // Parseando os dados do usuário para tela de perfil
            nome.setText(personName);
            email.setText(personEmail);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(IMG, personPhoto.toString());
            editor.putString(NAME, personName);
            editor.commit();

            Picasso.get().load(personPhoto.toString()).resize(300, 300).into(perfil);


            Toast.makeText(this, "Usuário :" + personName + " Está conectado", Toast.LENGTH_SHORT).show();

        }


    }



    /** TODO: PEDRO, UTILIZE O MÉTODO ABAIXO (isUserAuthenticaded) PARA FAZER A DECISÃO SE O USUÁRIO ESTÁ CONECTADO ENTRA NA MAINACTIVITY SE NÃO ENTRA NO LOGIN.
     *
     * EXEMPLO
     *
     * if (!isUserAuthenticated()) {
     *      Intent intent = new Intent(LoginActivity.class);
     *      startActivity(intent);
     * }   else {
     *      Intent intent = new Intent(MainActivity.class);
     *      startActivity(intent);
     * }
     *
     *
     *
     */


    private boolean isUserAuthenticated() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }




}
