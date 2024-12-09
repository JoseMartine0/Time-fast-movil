package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón de inicio de sesión
        binding.btnLogin.setOnClickListener {
            val numeroPersonal = binding.etNumeroPersonal.text.toString().trim()
            val contrasena = binding.etContrasenia.text.toString().trim()

            if (validarCampos(numeroPersonal, contrasena)) {
                autenticarUsuario(numeroPersonal, contrasena)
            }
        }
    }

    // Validar los campos de entrada
    private fun validarCampos(numeroPersonal: String, contrasena: String): Boolean {
        var esValido = true

        if (numeroPersonal.isEmpty()) {
            binding.etNumeroPersonal.error = "Número de personal obligatorio"
            esValido = false
        } else {
            binding.etNumeroPersonal.error = null
        }

        if (contrasena.isEmpty()) {
            binding.etContrasenia.error = "Contraseña obligatoria"
            esValido = false
        } else {
            binding.etContrasenia.error = null
        }

        return esValido
    }

    // Simular autenticación
    private fun autenticarUsuario(numeroPersonal: String, contrasena: String) {
        // Autenticación simulada (puedes conectar con una API real aquí)
        if (numeroPersonal == "12345" && contrasena == "password") {
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Número de personal o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}