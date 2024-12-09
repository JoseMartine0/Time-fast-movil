package com.example.app.pojo
import com.example.app.pojo.Clientes

data class Envios(
    val numeroGuia: String,
    val direccionOrigen: String,
    val direccionDestino: String,
    val estatus: String,
    val paquetes: List<String>, // Lista de paquetes contenidos
    val cliente: Clientes // Datos del cliente
)