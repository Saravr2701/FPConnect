package com.example.fpconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class estudiante_solicitudes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estudiante_solicitudes)

        val btnInicio = findViewById<ImageButton>(R.id.btnInicio)
        val btnPerfil = findViewById<ImageButton>(R.id.btnPerfil)

        btnInicio.setOnClickListener {
            val intent = Intent(this, estudiante_inicio::class.java)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener {
            val intent = Intent(this, estudiante_perfil::class.java)
            startActivity(intent)
        }

        val contenedor = findViewById<LinearLayout>(R.id.contenedorSolicitudes)

        val solicitudes = listOf(
            Solicitudes(
                "Empresa de ejemplo",
                "Desarrollador de aplicaciones",
                "Prácticas de programación y desarrollo de aplicaciones.",
                "EN_REVISION"
            ),
            Solicitudes(
                "Otra empresa de ejemplo",
                "Técnico de soporte",
                "Prácticas de mantenimiento de equipos informáticos.",
                "ENVIADA"
            ),
            Solicitudes(
                "Una empresa más de ejemplo",
                "Desarrollador web",
                "Prácticas de programación de páginas web.",
                "RESUELTA"
            )
        )

        for (solicitud in solicitudes) {
            val tarjeta = layoutInflater.inflate(R.layout.tarjeta_solicitudes, contenedor, false)
            val nombreEmpresa = tarjeta.findViewById<TextView>(R.id.nombreEmpresa)
            val nombrePuesto = tarjeta.findViewById<TextView>(R.id.nombrePuesto)
            val descripcionPuesto = tarjeta.findViewById<TextView>(R.id.descripcionPuesto)

            val estadoTexto = when (solicitud.estado) {
                "ENVIADA" -> "Enviada"
                "EN_REVISION" -> "En revisión"
                "RESUELTA" -> "Resuelta"
                else -> "Desconocido"
            }

            nombreEmpresa.text = solicitud.empresa
            nombrePuesto.text = solicitud.puesto
            descripcionPuesto.text = solicitud.descripcion
            contenedor.addView(tarjeta)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.solicitudes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

data class Solicitudes(
    val empresa: String,
    val puesto: String,
    val descripcion: String,
    val estado: String
)
