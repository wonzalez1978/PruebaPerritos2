package cl.desafiolatam.appperritos.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cl.desafiolatam.appperritos.R;
import cl.desafiolatam.appperritos.presenter.IPresenterViewDetails;

public class DetalleFrgmtoPerrito extends Fragment implements IPresenterViewDetails {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public DetalleFrgmtoPerrito() {
    }

    public static DetalleFrgmtoPerrito newInstance(String mParam1, String mParam2){
        DetalleFrgmtoPerrito fragment = new DetalleFrgmtoPerrito();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView;
        textView = view.findViewById(R.id.nombrerazadetalle);
        textView.setText(mParam1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragmentodetalle, container, false);
    }




    @Override
    public void showBreedImages(String breed) {

    }
}