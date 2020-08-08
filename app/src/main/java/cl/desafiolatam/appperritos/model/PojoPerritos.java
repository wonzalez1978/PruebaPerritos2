package cl.desafiolatam.appperritos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.desafiolatam.appperritos.model.api.IPerritosDataBase;
import cl.desafiolatam.appperritos.model.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class PojoPerritos implements IModel {


    @Override
    public void loadBreeds() {
        IPerritosDataBase servicios = RetrofitClient.getRetrofitInstance().create(IPerritosDataBase.class);
        Call<RazasLista> razasListaCall = servicios.listaRazas();
        List<String> listaPerros = new ArrayList<>();
        razasListaCall.enqueue(new Callback<RazasLista>() {
            @Override
            public void onResponse(Call<RazasLista> call, Response<RazasLista> response) {
                RazasLista razasLista = response.body();
                Map<String, List<String>> mapa = (Map<String, List<String>>) razasLista.getMessage();

                for (String key : mapa.keySet()) {
                    if (mapa.get(key).isEmpty()) {
                        listaPerros.add(key);
                    } else {
                        for (String subRaza : mapa.get(key)) {
                            listaPerros.add(key + " " + subRaza);
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadImages(String breed) {

    }
}