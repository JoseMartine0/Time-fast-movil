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




class EnvioAdapter(
    private val envios: List<Envios>
) : RecyclerView.Adapter<EnvioAdapter.EnvioViewHolder>() {

    class EnvioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numeroGuia = itemView.findViewById<TextView>(R.id.tvNumeroGuia)
        val direccionDestino = itemView.findViewById<TextView>(R.id.tvDireccionDestino)
        val estatus = itemView.findViewById<TextView>(R.id.tvEstatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnvioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.envio, parent, false)
        return EnvioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnvioViewHolder, position: Int) {
        val envio = envios[position]
        holder.numeroGuia.text = envio.numeroGuia
        holder.direccionDestino.text = envio.direccionDestino
        holder.estatus.text = envio.estatus
    }

    override fun getItemCount(): Int = envios.size
}

