package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityListaEnviosBinding
import com.example.app.pojo.Clientes
import com.example.app.pojo.EnvioAdapter
import com.example.app.pojo.Envios

class ListaEnviosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEnviosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEnviosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Datos de ejemplo, en un caso real esto vendría de un backend o base de datos
        val listaEnvios = listOf(
            Envios("12345", "Calle Falsa 123, Ciudad XYZ", "Calle principal, 123","En transito", paquetes = listOf("2"), cliente = Clientes("Juan","2311172215", "juan@example.com")),
            //Envios("67890", "Avenida Siempre Viva 742, Ciudad ABC", "Entregado"),
            //Envios("11223", "Calle Secundaria 12, Ciudad DEF", "Detenido")
        )

        // Configuramos el RecyclerView
        val adapter = EnvioAdapter(listaEnvios)
        binding.recyclerViewEnvios.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewEnvios.adapter = adapter

    }
}
