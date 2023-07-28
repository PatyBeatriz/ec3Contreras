package pe.edu.idat.ec_gatos_botas.repository

import androidx.lifecycle.MutableLiveData
import pe.edu.idat.ec_gatos_botas.retrofit.Cliente
import pe.edu.idat.ec_gatos_botas.retrofit.ResponseGatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GatoRepository {

    var responseGato=MutableLiveData<List<ResponseGatos>>()

    var responseGatox=MutableLiveData<ResponseGatos>()

    fun obtenerGato():MutableLiveData<ResponseGatos>{

        val call:Call<ResponseGatos> = Cliente.retrofiteService.obtenerGato()
        call.enqueue(object :Callback<ResponseGatos>{

            override fun onResponse(call: Call<ResponseGatos>, response: Response<ResponseGatos>) {
               responseGatox.value=response.body()
            }

            override fun onFailure(call: Call<ResponseGatos>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return responseGatox
    }




    fun listGato():MutableLiveData<List<ResponseGatos>>{

        val call:Call<List<ResponseGatos>> = Cliente.retrofiteService.listarGatos()
        call.enqueue(object :Callback<List<ResponseGatos>>{
            override fun onResponse(
                call: Call<List<ResponseGatos>>,
                response: Response<List<ResponseGatos>>
            ) {
                responseGato.value=response.body()
            }

            override fun onFailure(call: Call<List<ResponseGatos>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return responseGato
    }
}