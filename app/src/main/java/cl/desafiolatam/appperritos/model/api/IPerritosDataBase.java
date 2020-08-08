package cl.desafiolatam.appperritos.model.api;


import cl.desafiolatam.appperritos.model.RazaImagen;
import cl.desafiolatam.appperritos.model.RazasLista;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPerritosDataBase {
    @GET("api/breeds/list/all")
    Call<RazasLista> listaRazas();

    @GET("api/breed/{breed}/images")
    Call<RazaImagen> listaImagenes(@Path("breed") String breed);
}