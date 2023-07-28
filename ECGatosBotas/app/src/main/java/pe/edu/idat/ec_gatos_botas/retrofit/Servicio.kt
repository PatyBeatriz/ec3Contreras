package pe.edu.idat.ec_gatos_botas.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Servicio {

    @GET("search?limit=10")
    fun listarGatos():Call<List<ResponseGatos>>
    @GET("0XYvRd7oD")
    fun obtenerGato():Call<ResponseGatos>
}