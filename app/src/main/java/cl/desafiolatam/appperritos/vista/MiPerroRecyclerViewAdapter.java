package cl.desafiolatam.appperritos.vista;



import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiPerroRecyclerViewAdapter extends RecyclerView.Adapter {

    public MiPerroRecyclerViewAdapter(List<String> lista) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public interface OnItemClickListener {
        void onItemClick (int position);
    }
    public void setOnItemClickListener(OnItemClickListener itemClickListener){

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}


