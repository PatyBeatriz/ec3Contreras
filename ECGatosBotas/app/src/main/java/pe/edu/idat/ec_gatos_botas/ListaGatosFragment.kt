package pe.edu.idat.ec_gatos_botas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.ec_gatos_botas.adapters.GatoAdapter
import pe.edu.idat.ec_gatos_botas.databinding.FragmentListaGatosBinding
import pe.edu.idat.ec_gatos_botas.viewmodel.GatoViewModel


class ListaGatosFragment : Fragment() {

    private var _binding:FragmentListaGatosBinding?=null
    private val binding get()=_binding!!
    private lateinit var gatoViewModel: GatoViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentListaGatosBinding.inflate(inflater,container,false)
        binding.rvgatos.layoutManager=LinearLayoutManager(requireActivity())
        gatoViewModel=ViewModelProvider(requireActivity()).get(GatoViewModel::class.java)
        listarGatos()

        return binding.root
    }

    private fun listarGatos(){
        gatoViewModel.listar().observe(viewLifecycleOwner,
        Observer {
            binding.rvgatos.adapter=GatoAdapter(it)
        })
    }

}