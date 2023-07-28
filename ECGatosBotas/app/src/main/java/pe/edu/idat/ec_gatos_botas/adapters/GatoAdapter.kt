package pe.edu.idat.ec_gatos_botas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import pe.edu.idat.ec_gatos_botas.databinding.ItemGatoBinding
import pe.edu.idat.ec_gatos_botas.retrofit.ResponseGatos

class GatoAdapter(private var lstgato:List<ResponseGatos>)
    :RecyclerView.Adapter<GatoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemGatoBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGatoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(lstgato[position]){
                binding.tvWidth.text= width.toString()
                binding.tvHeight.text=height.toString()
                Glide.with(itemView.context).load(url)
                    .into(binding.ivGato)


            }
        }
}
    override fun getItemCount() = lstgato.size
}