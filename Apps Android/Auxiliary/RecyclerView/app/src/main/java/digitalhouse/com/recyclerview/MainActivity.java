package digitalhouse.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import digitalhouse.com.recyclerview.model.Curso;
import digitalhouse.com.recyclerview.model.EstadoAtual;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.list);
        List<Curso> cursos = todosOsCursos();
        ArrayAdapter<Curso> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cursos);
        lista.setAdapter(adapter);
    }

    private List<Curso> todosOsCursos(){
        return new ArrayList<>(Arrays.asList(
                new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
        new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
        new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
        new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
                new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
                new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO),
                new Curso("Kotlin", "básico de kotlin", EstadoAtual.FINALIZANDO),
                new Curso("java", "curso javareiro", EstadoAtual.FAZENDO),
                new Curso("Android", "curso de android", EstadoAtual.FINALIZANDO))
        );
    }

}
