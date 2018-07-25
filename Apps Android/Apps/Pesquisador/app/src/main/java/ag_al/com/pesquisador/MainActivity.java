package ag_al.com.pesquisador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static  final  String EXTRA_URL = "imageUrl";
    public static  final String EXTRA_CREATOR = "creatorName";
    public static  final  String EXTRA_LIKES = "likeCount";

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    private TextView search;
    private Button go;

    private String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        search = (TextView) findViewById(R.id.search_text);
        go = (Button) findViewById(R.id.go_button);

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

    }


    public void goSearch(View view){
         url = "https://pixabay.com/api/?key=9629719-206da1b0c17c8fe915c465a14&q="+search.getText().toString()+"&image_type=photo";


        //url = "https://pixabay.com/api/?key=9629719-206da1b0c17c8fe915c465a14&q=yellow+flowers&image_type=photo";

        Toast.makeText(this, "Pesquisando...", Toast.LENGTH_SHORT).show();

        mExampleList.clear();

        parseJSON();


    }




    private void parseJSON() {

        //url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true%22";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");

                                mExampleList.add(new ExampleItem(imageUrl, creatorName, likeCount));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ExampleItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_URL, clickedItem.getmImageurl());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getmCreator());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getmLikes());

        startActivity(detailIntent);
    }
}