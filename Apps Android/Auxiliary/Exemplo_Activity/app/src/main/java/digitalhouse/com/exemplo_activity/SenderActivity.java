package digitalhouse.com.exemplo_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SenderActivity extends AppCompatActivity {
    EditText nome,apelido,idade;
    Button botao;
    String vCampo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = (Button) findViewById(R.id.button);
        nome = (EditText) findViewById(R.id.nomeEdit);
        apelido = findViewById(R.id.apelidoEdit);
        idade = findViewById(R.id.idadeEdit);

    }

    public void botao(View v){
        Toast.makeText(this, "Foi caramba", Toast.LENGTH_SHORT).show();
        Intent meuIntent = new Intent(this,ReceptorActivity.class);
        Bundle meuBundle = new Bundle();
        meuBundle.putString("nome",nome.getText().toString());
        meuBundle.putString("apelido",apelido.getText().toString());
        meuBundle.putString("idade",idade.getText().toString());
        meuIntent.putExtras(meuBundle);
        startActivity(meuIntent);


    }
}
