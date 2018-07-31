package ag_al.com.entregvelaula33;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    private RecyclerView mRecyclerView;
    private Adapter exAdapter;
    private RecyclerView.LayoutManager xLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        if(findViewById(R.id.frame1) != null) {

            if (savedInstanceState != null) {
                return;
            }
        }



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_Receitas:
                                Boolean pass = true;

                                ReceitaListFragment receitaFragment = new ReceitaListFragment();

                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.frame1, receitaFragment, null);
                                fragmentTransaction.commit();

                             /*   }else{
                                    FragmentManager fragmentManager = getSupportFragmentManager();
                                    ReceitaListFragment receitaFragment = new ReceitaListFragment();
                                    fragmentManager.beginTransaction().replace(R.id.frame1, receitaFragment).commit();


                                }*/



                                break;

                        }
                        return false;
                    }
                });




    }
}
