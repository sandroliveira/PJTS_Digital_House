package ag_al.com.entregvelaula33;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientesFragment extends Fragment {


    public IngredientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ingredientes, container, false);
        TextView ingredientes = (TextView) v.findViewById(R.id.textIngred);

        ingredientes.setText("FUDEU");


        Bundle bundle = getArguments();
        if (bundle != null){
            ingredientes.setText(bundle.getString("ingred"));

        }else{
           // Toast.makeText(getContext(), "bundle vazia", Toast.LENGTH_SHORT).show();
        }



        return v;
    }

}
