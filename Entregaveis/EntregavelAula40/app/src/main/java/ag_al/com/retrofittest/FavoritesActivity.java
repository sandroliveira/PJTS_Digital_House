package ag_al.com.retrofittest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ag_al.com.retrofittest.adapter.ExAdapter;
import ag_al.com.retrofittest.fragment.DetailFragment;
import ag_al.com.retrofittest.model.Results;

public class FavoritesActivity extends AppCompatActivity  {
    ArrayList<Results> resultsArrayList;
    ExAdapter adapter;
    RecyclerView recyclerViewFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

      /*  Intent intent = getIntent();
        resultsArrayList = (ArrayList<Results>) getIntent().getSerializableExtra("bundle");


        recyclerViewFrag = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerViewFrag.setHasFixedSize(true);
        recyclerViewFrag.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new ExAdapter(getApplicationContext(),resultsArrayList);
        recyclerViewFrag.setAdapter(adapter);

*/

    }






}
