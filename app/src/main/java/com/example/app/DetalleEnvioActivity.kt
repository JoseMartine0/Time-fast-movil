package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.example.app.databinding.ActivityDetalleEnvioBinding
import com.example.app.pojo.Envios

class DetalleEnvioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleEnvioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEnvioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el objeto Envio pasado desde la actividad anterior
        val envioJson = intent.getStringExtra("envio") // Recibimos el envío como JSON
        if (envioJson != null) {
            mostrarDetalleEnvio(envioJson)
        } else {
            Toast.makeText(this, "Error al cargar los datos del envío", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarDetalleEnvio(envioJson: String) {
        val gson = Gson()
        val envio = gson.fromJson(envioJson, Envios::class.java)

        // Mostrar los detalles en los TextViews correspondientes
        binding.tvNumeroGuia.text = "Número de guía: ${envio.numeroGuia}"
        binding.tvDireccionOrigen.text = "Dirección de origen: ${envio.direccionOrigen}"
        binding.tvDireccionDestino.text = "Dirección de destino: ${envio.direccionDestino}"
        binding.tvPaquetes.text = "Paquetes contenidos: ${envio.paquetes.joinToString()}"
        binding.tvEstatus.text = "Estatus: ${envio.estatus}"

        // Mostrar los datos del cliente
        binding.tvNombreCliente.text = "Nombre del cliente: ${envio.cliente.nombre}"
        binding.tvTelefonoCliente.text = "Teléfono: ${envio.cliente.telefono}"
        binding.tvCorreoCliente.text = "Correo electrónico: ${envio.cliente.correo}"
    }
}
