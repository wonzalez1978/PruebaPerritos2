package cl.desafiolatam.appperritos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.desafiolatam.appperritos.model.api.IPerritosDataBase;
import cl.desafiolatam.appperritos.model.api.RetrofitClient;
import cl.desafiolatam.appperritos.presenter.IPresenterDetails;
import cl.desafiolatam.appperritos.presenter.IPresenterModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class PojoPerritos implements IModel {

    IPresenterModel iPresenterModel;
    IPresenterDetails iPresenterDetail;

    public PojoPerritos(IPresenterModel iPresenterModel) {
        this.iPresenterModel = iPresenterModel;
    }

    @Override
    public void loadBreeds() {
        IPerritosDataBase servicios = RetrofitClient.getRetrofitInstance().create(IPerritosDataBase.class);
        Call<RazasLista> listaCall = servicios.listaRazas();
        Call<RazaImagen> razaImagen = servicios.listaImagenes("breed");
        List<String> listaPerros = new ArrayList<>();

        listaCall.enqueue(new Callback<RazasLista>(){


            @Override
            public void onResponse(Call<RazasLista> call, Response<RazasLista> response) {
                RazasLista listaRazas = response.body();
                Map<String, List<String>> map = listaRazas.getMessage();


                for (String key : map.keySet()) {
                    if (map.get(key).isEmpty()) {
                        listaPerros.add(key);
                    } else {
                        for (String subRaza : map.get(key)) {
                            listaPerros.add(key + " " + subRaza);
                        }
                    }

                }
                iPresenterModel.notificar(listaPerros);
            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadImages(String raza) {
        IPerritosDataBase servicio = RetrofitClient.getRetrofitInstance()
                .create(IPerritosDataBase.class);

        Call<RazaImagen>listCall = servicio.listaImagenes(raza);
        List<String> listaPhotosPerros = new ArrayList<>();

        listCall.enqueue(new Callback<RazaImagen>() {
            @Override
            public void onResponse(Call<RazaImagen> call, Response<RazaImagen> response) {
                RazaImagen listaRazas = response.body();
                List<String> lista = listaRazas.getMessage();
                iPresenterDetail.loadBreedImages(raza);
            }

            @Override
            public void onFailure(Call<RazaImagen> call, Throwable t) {

            }
        });

    }
}