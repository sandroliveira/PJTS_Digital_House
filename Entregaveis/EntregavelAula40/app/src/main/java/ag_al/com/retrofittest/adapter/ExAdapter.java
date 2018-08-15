package ag_al.com.retrofittest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import ag_al.com.retrofittest.R;
import ag_al.com.retrofittest.model.Results;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ViewHolder> {
    private Context context;
    private List<Results> resultsList;
    private OnItemClickListener onListener;

    public interface OnItemClickListener{
        void onItemClick(int position, List<Results> listData);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onListener = listener;
    }

    public ExAdapter(Context context, List<Results> data){
        this.resultsList = data;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Results currentItem = resultsList.get(position);
        holder.txTitle.setText(currentItem.getTitle());
        holder.txDesc.setText(currentItem.getDesc());
        Picasso.get()
                .load(resultsList.get(position).getImagem())
                .into(holder.txImg);


    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txTitle,txDesc;
        private ImageView txImg;

        public ViewHolder(View itemView) {
            super(itemView);
            txImg = (ImageView) itemView.findViewById(R.id.imageView);
            txDesc = (TextView) itemView.findViewById(R.id.textDesc);
            txTitle = (TextView) itemView.findViewById(R.id.textTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onListener != null){
                        int position = getAdapterPosition();
                        List<Results> list = resultsList;
                        if (position != RecyclerView.NO_POSITION){
                            onListener.onItemClick(position,list);
                        }
                    }
                }
            });
        }
    }


}
