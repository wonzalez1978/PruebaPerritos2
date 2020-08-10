package cl.desafiolatam.appperritos.vista;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.appperritos.R;
/*1.- Crear el Adapter
*2.-extender de RecyclerView.Adapter o de alguna de sus subclases
 */
public class MiPerroRecyclerViewAdapter extends RecyclerView.Adapter<MiPerroRecyclerViewAdapter.ViewHolder>{

        private static final String TAG = "MyDogRecyclerViewAdapter";
        private final List<String> mValues;
        private OnItemClickListener mListener;

    public MiPerroRecyclerViewAdapter(List<String> items) {
        mValues = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmento_perro, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface OnItemClickListener {
        void onItemClick (int position);
    }
    public void setOnItemClickListener(OnItemClickListener mListener){
        this.mListener = mListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public String mItem;


        public ViewHolder(View view, OnItemClickListener mListener) {
            super(view);
            mView = view;
            mIdView = (TextView)view.findViewById(R.id.item_number);
            mContentView = (TextView)view.findViewById(R.id.content);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view ) {
                    mListener.onItemClick(getAdapterPosition());

                }
            });
        }

        @Override
        public String toString() {
            return super.toString()+ " "+"ViewHolder{" +
                    "mView=" + mView +
                    ", mIdView=" + mIdView +
                    ", mContentView=" + mContentView +
                    ", mItem='" + mItem + '\'' +
                    '}';
        }
    }


}


