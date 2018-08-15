package ag_al.com.retrofittest.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ag_al.com.retrofittest.MainActivity;
import ag_al.com.retrofittest.R;
import ag_al.com.retrofittest.model.Results;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private TextView txtTitle;
    private TextView txtDesc;
    private String getImg;
    private ImageView img;
    private ImageView imgBackground;
    private boolean pass = true;
    private OnGetItemSelectedListener listener;
    private ArrayList<Results> resultsList = null;

    public DetailFragment() {
        // Required empty public constructor
    }

    public interface OnGetItemSelectedListener{
        public void onGetItemSelected(ArrayList<Results> array);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        final LottieAnimationView animationView = (LottieAnimationView) v.findViewById(R.id.favoriteLottie2);


        txtTitle = (TextView) v.findViewById(R.id.textDetailTitle);
        txtDesc = (TextView) v.findViewById(R.id.textDetailDesc);
        img = (ImageView) v.findViewById(R.id.imageView2);
        imgBackground = (ImageView) v.findViewById(R.id.imageView3);

        Bundle bundleFrag = getArguments();
        if (bundleFrag != null) {
            txtTitle.setText(bundleFrag.getString("title"));
            txtDesc.setText(bundleFrag.getString("description"));
            getImg = bundleFrag.getString("image");
            Picasso.get()
                    .load(getImg)
                    .into(img);

            Picasso.get()
                    .load(getImg)
                    .into(imgBackground);

        }


        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass == true) {
                    animationView.setMinAndMaxFrame(50, 120);
                    animationView.playAnimation();
                    Toast.makeText(getContext(), "Você adicionou " + txtTitle.getText() + " ao seus favoritos", Toast.LENGTH_SHORT).show();
                   /* resultsList.add(new Results(txtTitle.getText().toString(), txtDesc.getText().toString(), getImg));
                    listener.onGetItemSelected(resultsList);*/

                    pass = false;
                } else {
                    Toast.makeText(getContext(), "Você retirou " + txtTitle.getText() + " dos favoritos", Toast.LENGTH_SHORT).show();
                    animationView.setMinAndMaxFrame(135, 150);
                    animationView.playAnimation();
                    pass = true;
                }

            }
        });


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try{
            listener = (OnGetItemSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"tem que implementar o onGetItemSelected...");
        }
    }
}

