package ag_al.com.entregvelaula33;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ag_al.com.entregvelaula33.model.ItemReceitaList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceitasFragment extends Fragment {
    List<Fragment> list;



    public ReceitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receitas, container, false);

        TextView nome = (TextView) v.findViewById(R.id.textNomeReceita);
        TextView min = (TextView) v.findViewById(R.id.textMin);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);






        Bundle bundle = getArguments();
        if (bundle != null){
            imageView.setImageResource(bundle.getInt("imagem"));
            nome.setText(bundle.getString("nome"));
            min.setText(bundle.getString("min"));

            String ingred = bundle.getString("ingred");

            Bundle bundleIngred = new Bundle();
            IngredientesFragment ifrag = new IngredientesFragment();
            bundleIngred.putString("ingredientes", ingred);
            ifrag.setArguments(bundleIngred);

        }



        list = new ArrayList<>();

        IngredientesFragment ifrag = new IngredientesFragment();
        ModoDePreparoFragment mdpfrag = new ModoDePreparoFragment();

        list.add(ifrag);
        list.add(mdpfrag);

        FragmentAdapterViewPager fragmentAdapterViewPager = new FragmentAdapterViewPager(getFragmentManager(),list);

        ViewPager viewPager = v.findViewById(R.id.viewPager);

        viewPager.setClipToPadding(false);

        viewPager.setAdapter(fragmentAdapterViewPager);


        return v;
    }

}
