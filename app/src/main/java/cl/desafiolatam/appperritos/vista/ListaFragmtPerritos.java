package cl.desafiolatam.appperritos.vista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.appperritos.R;
import cl.desafiolatam.appperritos.model.PojoPerritos;
import cl.desafiolatam.appperritos.presenter.PresenterList;

public class ListaFragmtPerritos extends Fragment implements PresenterList.IPresenterViewList {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    MiPerroRecyclerViewAdapter myAdaptador;

    public static ListaFragmtPerritos newInstance(int mColumnCount) {
        ListaFragmtPerritos fragment = new ListaFragmtPerritos();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, mColumnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item_perritos, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            PresenterList presentador = new PresenterList(this);
            presentador.setImodel(new PojoPerritos(presentador));
            presentador.loadBreeds();
        }
        return view;
    }

    @Override
    public void notificar(List<String> lista) {
    myAdaptador = new MiPerroRecyclerViewAdapter(lista);
    recyclerView.setAdapter(myAdaptador);
    myAdaptador.setOnItemClickListener(new MiPerroRecyclerViewAdapter.OnItemClickListener() {

        @Override
        public void onItemClick(int position) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout,
                    DetalleFrgmtoPerrito.newInstance(lista.get(position)," "), "details")
                    .remove(getActivity().getSupportFragmentManager()
                            .findFragmentByTag("lista perritos")).commit();

        }
    });

 }

}

