package fine.koacaiia.androidysk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListView> {
    ArrayList<RecyclerList> list;

    public RecyclerAdapter(ArrayList<RecyclerList> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        return new ListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListView holder, int position) {
        holder.txtContents.setText(list.get(position).getContents());
        holder.txtName.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListView extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtContents;
        public ListView(@NonNull View itemView) {
            super(itemView);
            this.txtName=itemView.findViewById(R.id.txtName);
            this.txtContents=itemView.findViewById(R.id.txtContents);
        }
    }
}
