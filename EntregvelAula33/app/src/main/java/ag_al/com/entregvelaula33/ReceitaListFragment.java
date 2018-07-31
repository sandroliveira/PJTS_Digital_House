package ag_al.com.entregvelaula33;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ag_al.com.entregvelaula33.model.ItemReceita;
import ag_al.com.entregvelaula33.model.ItemReceitaList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceitaListFragment extends Fragment {
    FragmentManager fragmentManager;



    public ReceitaListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_receita, container, false);

        if(v.findViewById(R.id.frame1) != null) {

        }else {

            final ArrayList<ItemReceitaList> list = new ArrayList<>();
            final ArrayList<ItemReceita> receitas = new ArrayList<>();

            list.add(new ItemReceitaList(R.drawable.croissant, "croissant"));
            receitas.add(new ItemReceita("10Min", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Cras sit amet laoreet enim, sed facilisis nisl. Morbi blandit tortor at ornare gravida."));

            list.add(new ItemReceitaList(R.drawable.ic_launcher_background, "salgados"));
            receitas.add(new ItemReceita("5Min", "Donec risus eros, aliquet a ullamcorper ac, euismod nec tortor.", "Pellentesque congue, erat in ornare gravida, elit quam commodo leo, vitae commodo dolor ligula eu ligula. Donec at mi justo."));

            RecyclerView mRecyclerView = v.findViewById(R.id.recyclerViewReceitas);
            RecyclerView.LayoutManager xLayoutManager = new LinearLayoutManager(getActivity());
            Adapter exAdapter = new Adapter(list);

            mRecyclerView.setLayoutManager(xLayoutManager);
            mRecyclerView.setAdapter(exAdapter);

            exAdapter.setOnItemCLickListener(new Adapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {





                    FragmentManager fragmentManager = getFragmentManager();

                    ReceitasFragment rf = new ReceitasFragment();

                    //BUNDLE DA ITEMRECEITALIST

                    ItemReceitaList itemReceitaList = list.get(position);
                    ItemReceita itemReceita = receitas.get(position);
                    Bundle bundle = new Bundle();
                    bundle.putInt("imagem", itemReceitaList.getxImagem());
                    bundle.putString("nome", itemReceitaList.getxTextView());
                    bundle.putString("min", itemReceita.getnTextMin());
                    bundle.putString("ingred", itemReceita.getnTextIngred());
                    rf.setArguments(bundle);

                  /*  // BUNDLE DA ITEMRECEITA
                    IngredientesFragment ifrag = new IngredientesFragment();
                    Bundle bundleIngred = new Bundle();
                    bundleIngred.putString("ingredientes", itemReceita.getnTextIngred());
                    //ifrag.setArguments(bundleIngred);

*/




                    fragmentManager.beginTransaction().replace(R.id.frame1, rf).commit();


                    //Toast.makeText(getContext(), receitas.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        return v;
    }

}
