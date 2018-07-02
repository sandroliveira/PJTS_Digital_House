package digitalhouse.com.exemplo_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReceptorActivity extends AppCompatActivity {
    TextView nome,apelido,idade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);
        nome = findViewById(R.id.textViewNome);
        apelido = findViewById(R.id.textViewApelido);
        idade = findViewById(R.id.textViewIdade);



        Intent outroIntent = getIntent();
        Bundle outroBundle = outroIntent.getExtras();
        String v_nome = outroBundle.getString("nome");
        String v_apelido = outroBundle.getString("apelido");
        String v_idade = outroBundle.getString("idade");

        nome.setText(v_nome);
        apelido.setText(v_apelido);
        idade.setText(v_idade);

    }



}
