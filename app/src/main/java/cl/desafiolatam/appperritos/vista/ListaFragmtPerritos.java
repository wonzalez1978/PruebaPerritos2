package cl.desafiolatam.appperritos.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.appperritos.R;
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
    public void notificar(List<String> lista) {
    myAdaptador = new MiPerroRecyclerViewAdapter(lista);
    recyclerView.setAdapter(myAdaptador);
    myAdaptador.setOnItemClickListener(new MiPerroRecyclerViewAdapter.OnItemClickListener() {

        @Override
        public void onItemClick(int position) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.mainLayout,
                    DetalleFrgmtoPerrito.newInstance(lista.get(position), " "), "details")
                    .remove(getActivity().getSupportFragmentManager()
                            .findFragmentByTag("lista perritos"));

        }
    });

 }

}

