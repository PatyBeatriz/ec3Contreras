package pe.edu.idat.ec_gatos_botas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.ec_gatos_botas.repository.GatoRepository
import pe.edu.idat.ec_gatos_botas.retrofit.ResponseGatos

class GatoViewModel:ViewModel() {

    private var repository=GatoRepository()

    fun listar():LiveData<List<ResponseGatos>>{
        return  repository.listGato()
    }

    fun obtenerFav():LiveData<ResponseGatos>{
        return repository.obtenerGato()
    }

}