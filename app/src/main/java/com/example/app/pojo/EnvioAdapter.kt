package com.example.app.pojo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.DetalleEnvioActivity
import com.example.app.R
import com.example.app.databinding.EnvioBinding
import com.google.gson.Gson


class EnvioAdapter(private val binding: EnvioBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(envio: Envios) {
        binding.tvNumeroGuia.text = "Número de guía: ${envio.numeroGuia}"
        binding.tvDireccionDestino.text = "Dirección de destino: ${envio.direccionDestino}"
        binding.tvEstatus.text = "Estatus: ${envio.estatus}"

        // Establecer el click listener para navegar al detalle
        itemView.setOnClickListener {
            val gson = Gson()
            val envioJson = gson.toJson(envio)

            val intent = Intent(itemView.context, DetalleEnvioActivity::class.java)
            intent.putExtra("envio", envioJson)
            itemView.context.startActivity(intent)
        }
    }
}
