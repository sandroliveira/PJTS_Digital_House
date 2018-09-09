package excurioso.ag_al.com;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import excurioso.ag_al.com.adapters.RecyclerAdapter;
import excurioso.ag_al.com.models.Items;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener {
    RecyclerView recyclerView;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final String TAG = "MyActivity";

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMain);

        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this,
                2, //number of grid columns
                GridLayoutManager.VERTICAL,
                false);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //stagger rows custom
                return (position == 0 ? 2 : 1);
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(MainActivity.this);

        loadFirebase();
    }

    public void loadFirebase(){
        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("itens");

        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    adapter.addItems(item.getValue(Items.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    @Override
    public void onItemClick(int position, List<Items> listData) {
        List<Items> data = listData;
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("url",data.get(position).getLink());
        startActivity(intent);
    }
}
