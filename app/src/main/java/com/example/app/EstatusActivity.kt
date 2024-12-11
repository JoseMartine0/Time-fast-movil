package com.example.app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityEstatusBinding

class EstatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEstatusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del envío desde el intent
        val numeroGuia = intent.getStringExtra("numeroGuia") ?: "N/A"
        binding.tvNumeroGuia.text = "Número de guía: $numeroGuia"

        // Configurar Spinner con los estados
        val estados = listOf("En tránsito", "Detenido", "Entregado", "Cancelado")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEstatus.adapter = adapter

        // Manejar el clic del botón Guardar
        binding.btnGuardar.setOnClickListener {
            val nuevoEstatus = binding.spinnerEstatus.selectedItem.toString()
            val comentario = binding.etComentario.text.toString()

            // Validar comentario si el estado es Detenido o Cancelado
            if ((nuevoEstatus == "Detenido" || nuevoEstatus == "Cancelado") && comentario.isEmpty()) {
                Toast.makeText(this, "El comentario es obligatorio para el estado $nuevoEstatus.", Toast.LENGTH_SHORT).show()
            } else {
                guardarCambios(numeroGuia, nuevoEstatus, comentario)
            }
        }
    }

    private fun guardarCambios(numeroGuia: String, estatus: String, comentario: String) {
        // Aquí puedes agregar lógica para actualizar el estatus en tu base de datos
        Toast.makeText(this, "Estatus actualizado a $estatus.", Toast.LENGTH_SHORT).show()
        finish() // Cierra la actividad después de guardar
    }
}