package excurioso.ag_al.com.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import excurioso.ag_al.com.R;
import excurioso.ag_al.com.models.Items;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private Context context;

    private List<Items> itemsList = new ArrayList<>();
    private ItemClickListener onListener;


    public void setOnItemClickListener(ItemClickListener listener){
        onListener = listener;
    }


    public RecyclerAdapter (Context context){
        this.onListener = (ItemClickListener) context;
        this.context = context;
    }

    public void addItems(Items items){
        this.itemsList.add(items);
        notifyItemInserted(itemsList.size() - 1);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_main,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Items currentItem = itemsList.get(position);
        Picasso.get()
                .load(currentItem.getImagemURL())
                .into(holder.img);
        holder.title.setText(currentItem.getTitulo());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;

        private String itemId;


        public RecyclerViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onListener != null){
                        int position = getAdapterPosition();
                        List<Items> list = itemsList;
                        if (position != RecyclerView.NO_POSITION) {
                            onListener.onItemClick(position, list);
                        }
                    }
                }
            });

            img = (ImageView) itemView.findViewById(R.id.imageItem);
            title = (TextView) itemView.findViewById(R.id.textItem);

        }

    }

    public interface ItemClickListener{
        void onItemClick(int position, List<Items> listData);
    }
}
