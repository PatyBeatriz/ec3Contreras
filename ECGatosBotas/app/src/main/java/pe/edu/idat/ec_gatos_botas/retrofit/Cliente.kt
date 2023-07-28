package pe.edu.idat.ec_gatos_botas.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Cliente {

    private var okHttpCliente= OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit()= Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .client(okHttpCliente)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofiteService: Servicio by lazy {
        buildRetrofit().create(Servicio::class.java)
    }


}