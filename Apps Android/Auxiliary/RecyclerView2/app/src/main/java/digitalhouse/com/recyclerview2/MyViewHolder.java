package digitalhouse.com.recyclerview2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private List<String>list;

    MyViewHolder(List<String> list){
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflate.inflate(R.layout.item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String titulo = list.get(position);
        holder.bind(titulo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Posição", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

}
