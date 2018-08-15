package ag_al.com.retrofittest;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ag_al.com.retrofittest.adapter.ExAdapter;
import ag_al.com.retrofittest.api.ApiClient;
import ag_al.com.retrofittest.api.RequestInterface;

import ag_al.com.retrofittest.fragment.DetailFragment;
import ag_al.com.retrofittest.model.Results;
import ag_al.com.retrofittest.model.ResultsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements ExAdapter.OnItemClickListener,DetailFragment.OnGetItemSelectedListener{
    private RecyclerView recyclerView;
    ProgressBar progressBar;

    private List<Results> results;
    ExAdapter exAdapter;
    FragmentManager fm = getSupportFragmentManager();
    private List<Results> favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.favorites:
                       /* Fragment fragment = fm.findFragmentById(R.id.frame1);
                        FragmentTransaction ft3 = fm.beginTransaction();
                        ft3.remove(fragment);
                        ft3.commit();*/


                        /*Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);
                        startActivity(intent);*/
                       break;
                    case R.id.home:





                }


                return false;
            }
        });

        recyclerViewStart();
    }





    public void recyclerViewStart() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



    }


    private void loadJson(String anime) {
        progressBar.setVisibility(View.VISIBLE);
        RequestInterface request = ApiClient.getClient().create(RequestInterface.class);
        Call<ResultsResponse> call = request.getJson(anime);
        call.enqueue(new Callback<ResultsResponse>() {
            @Override
            public void onResponse(Call<ResultsResponse> call, Response<ResultsResponse> response) {
                List<Results> data = response.body().getResults();
                exAdapter = new ExAdapter(getApplicationContext(),data);
                recyclerView.setAdapter(exAdapter);
                exAdapter.setOnItemClickListener(MainActivity.this);
                progressBar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<ResultsResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search_button).getActionView();

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );

        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2){
                    loadJson(query);
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 2){
                    loadJson(newText);
                }

                return false;
            }
        });

        return true;
    }

    @Override
    public void onItemClick(int position, List<Results> listData) {
        Boolean passFrag = true;
        DetailFragment dFragment = new DetailFragment();
        List<Results> detailBundle = listData;
        Bundle bundle = new Bundle();
        bundle.putString("title", detailBundle.get(position).getTitle());
        bundle.putString("description", detailBundle.get(position).getDesc());
        bundle.putString("image", detailBundle.get(position).getImagem());
        dFragment.setArguments(bundle);


        if (passFrag == true) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.frame1,dFragment);
            ft.commit();
            passFrag = false;
        }else {
            FragmentTransaction ft2 = fm.beginTransaction();
            ft2.replace(R.id.frame1,dFragment);
            ft2.commit();
        }
    }
    public void close (View view){
        Fragment fragment = fm.findFragmentById(R.id.frame1);
        FragmentTransaction ft3 = fm.beginTransaction();
        ft3.remove(fragment);
        ft3.commit();
    }


    @Override
    public void onGetItemSelected(ArrayList<Results> array) {
        ArrayList<Results> resultsArrayList = array;
        Intent intent = new Intent(getApplicationContext(),FavoritesActivity.class);
        intent.putExtra("bundle", resultsArrayList);
        startActivity(intent);
    }
}
