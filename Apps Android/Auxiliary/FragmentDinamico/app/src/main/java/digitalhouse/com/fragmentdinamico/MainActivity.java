package digitalhouse.com.fragmentdinamico;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private Button botao2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button);
        botao2 = (Button) findViewById(R.id.button2);

        //Pegar fragmentManager
        fragmentManager = getSupportFragmentManager();

        //Abre uma Transação e adiciona
        fragmentManager.beginTransaction()
                .add(R.id.frame1, new BlankFragment1())
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame2, new BlankFragment2())
                .commit();

        //Substituir um Fragment



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame2);
                if(fragment != null)

                    fragmentManager.
                            beginTransaction().
                            remove(fragment).
                            commit();
                Toast.makeText(view.getContext(), "Você está no fragment 2", Toast.LENGTH_SHORT).show();
            }
        });

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame1, new BlankFragment2())
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}
