package ag_al.com.entregvelaula33;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ag_al.com.entregvelaula33.model.ItemReceitaList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExViewHolder> {

    private ArrayList<ItemReceitaList> nItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public void setOnItemCLickListener(OnItemClickListener listener){
        mListener = listener;
    }







    public static class ExViewHolder extends RecyclerView.ViewHolder{
        public ImageView nImageView;
        public TextView nTextView;

        public ExViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            nTextView = itemView.findViewById(R.id.textListReceita);
            nImageView = itemView.findViewById(R.id.imageViewList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });

        }
    }

    public Adapter(ArrayList<ItemReceitaList> itemlist){
        nItemList = itemlist;

    }


    @Override
    public ExViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receitas,parent, false);
        ExViewHolder exvh = new ExViewHolder(v, mListener);
        return exvh;
    }

    @Override
    public void onBindViewHolder(ExViewHolder holder, int position) {
        ItemReceitaList itemAtual = nItemList.get(position);

        holder.nImageView.setImageResource(itemAtual.getxImagem());
        holder.nTextView.setText(itemAtual.getxTextView());

    }

    @Override
    public int getItemCount() {
        return nItemList.size();
    }
}
