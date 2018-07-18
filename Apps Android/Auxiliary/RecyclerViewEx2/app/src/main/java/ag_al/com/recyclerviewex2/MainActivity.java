package ag_al.com.recyclerviewex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.macbookproa1278, "Macbook", "R$ 4.750,00"));
        list.add(new Item(R.drawable.katanasword, "Katana Sword", "R$ 239,97"));
        list.add(new Item(R.drawable.sf4, "Street Fighter 5", "R$ 79,99"));

        recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
