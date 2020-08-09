package cl.desafiolatam.appperritos.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cl.desafiolatam.appperritos.R;

public class DogPhotosRecyclerViewAdapter extends RecyclerView.Adapter<DogPhotosRecyclerViewAdapter.ViewHolderImage>{


    @Override
    public ViewHolderImage onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderImage holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView mTextView;

        public ViewHolderImage(@NonNull View itemView, View mView, TextView mTextView) {
            super(itemView);
            this.mView = mView;
            this.mTextView = mTextView;
            mTextView = (TextView) itemView.findViewById(R.id.nombrerazadetalle);

        }
    }
}