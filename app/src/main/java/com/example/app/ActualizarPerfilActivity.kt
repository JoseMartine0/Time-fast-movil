package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityActualizarPerfilBinding

class ActualizarPerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActualizarPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActualizarPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos actuales del conductor (en un proyecto real vendrían de la base de datos o API)
        val nombre = intent.getStringExtra("nombre") ?: "Conductor"
        val telefono = intent.getStringExtra("telefono") ?: ""
        val correo = intent.getStringExtra("correo") ?: ""

        // Prellenar los campos
        binding.etNombre.setText(nombre)
        binding.etTelefono.setText(telefono)
        binding.etCorreo.setText(correo)

        // Manejar el clic del botón Guardar
        binding.btnGuardar.setOnClickListener {
            val nuevoNombre = binding.etNombre.text.toString()
            val nuevoTelefono = binding.etTelefono.text.toString()
            val nuevoCorreo = binding.etCorreo.text.toString()

            // Validar campos
            if (validarCampos(nuevoNombre, nuevoTelefono, nuevoCorreo)) {
                guardarCambios(nuevoNombre, nuevoTelefono, nuevoCorreo)
            }
        }
    }

    private fun validarCampos(nombre: String, telefono: String, correo: String): Boolean {
        var esValido = true

        if (nombre.isEmpty()) {
            binding.etNombre.error = "El nombre es obligatorio."
            esValido = false
        }

        if (telefono.isEmpty()) {
            binding.etTelefono.error = "El teléfono es obligatorio."
            esValido = false
        }

        if (correo.isEmpty()) {
            binding.etCorreo.error = "El correo es obligatorio."
            esValido = false
        }

        return esValido
    }

    private fun guardarCambios(nombre: String, telefono: String, correo: String) {
        // Lógica para guardar cambios en la base de datos
        Toast.makeText(this, "Perfil actualizado correctamente.", Toast.LENGTH_SHORT).show()
        finish() // Cierra la actividad después de guardar
    }
}