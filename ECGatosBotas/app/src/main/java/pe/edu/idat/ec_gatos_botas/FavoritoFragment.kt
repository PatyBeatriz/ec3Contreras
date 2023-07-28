package pe.edu.idat.ec_gatos_botas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import pe.edu.idat.ec_gatos_botas.databinding.FragmentFavoritoBinding
import pe.edu.idat.ec_gatos_botas.viewmodel.GatoViewModel


class FavoritoFragment : Fragment() {

    private var _binding:FragmentFavoritoBinding?=null
    private val binding get() = _binding!!
    private lateinit var gatoViewModel: GatoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFavoritoBinding.inflate(inflater,container,false)
        gatoViewModel=ViewModelProvider(requireActivity()).get(GatoViewModel::class.java)

        gatoFavorito()
        return binding.root
    }

    private fun gatoFavorito(){

        gatoViewModel.obtenerFav().observe(viewLifecycleOwner,
        Observer {
            binding.tvId.text = it.id
            binding.tvFavHeight.text= it.height.toString()
            binding.tvFavWidth.text=it.width.toString()

            Glide.with(binding.root).load(it.url)
                .into(binding.ivFavorito)

        })

    }

}