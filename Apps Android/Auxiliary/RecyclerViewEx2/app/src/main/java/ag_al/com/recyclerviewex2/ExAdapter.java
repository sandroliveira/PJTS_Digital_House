package ag_al.com.recyclerviewex2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.exViewHolder> {
    private ArrayList<Item> exList;

    public static class exViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textName;
        public TextView textPrice;

        public exViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textProductName);
            textPrice = itemView.findViewById(R.id.textPrice);
        }
    }

    public ExAdapter(ArrayList<Item> list){
        exList = list;
    }

    @Override
    public exViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        exViewHolder viewHolder = new exViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(exViewHolder holder, int position) {
        Item currentItem = exList.get(position);

        holder.imageView.setImageResource(currentItem.getiResource());
        holder.textName.setText(currentItem.getTextName());
        holder.textPrice.setText(currentItem.getTextPrice());

    }

    @Override
    public int getItemCount() {

        return exList.size();
    }
}
