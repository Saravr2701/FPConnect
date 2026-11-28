package com.example.fpconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout

class estudiante_inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estudiante_inicio)

        val btnSolicitudes = findViewById<ImageButton>(R.id.btnSolicitudes)
        val btnPerfil = findViewById<ImageButton>(R.id.btnPerfil)

        btnSolicitudes.setOnClickListener {
            val intent = Intent(this, estudiante_solicitudes::class.java)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener {
            val intent = Intent(this, estudiante_perfil::class.java)
            startActivity(intent)
        }

        val contenedor = findViewById<LinearLayout>(R.id.contenedorOfertas)

        val ofertas = listOf(
            OfertaPracticas(
                "Empresa de ejemplo",
                "Desarrollador de aplicaciones",
                "Prácticas de programación y desarrollo de aplicaciones."
            ),
            OfertaPracticas(
                "Otra empresa de ejemplo",
                "Técnico de soporte",
                "Prácticas de mantenimiento de equipos informáticos."
            )
        )

        for (oferta in ofertas) {
            val tarjeta = layoutInflater.inflate(R.layout.tarjeta_oferta, contenedor, false)
            val nombreEmpresa = tarjeta.findViewById<TextView>(R.id.nombreEmpresa)
            val nombrePuesto = tarjeta.findViewById<TextView>(R.id.nombrePuesto)
            val descripcionPuesto = tarjeta.findViewById<TextView>(R.id.descripcionPuesto)

            nombreEmpresa.text = oferta.empresa
            nombrePuesto.text = oferta.puesto
            descripcionPuesto.text = oferta.descripcion
            contenedor.addView(tarjeta)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inicio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

data class OfertaPracticas(
    val empresa: String,
    val puesto: String,
    val descripcion: String
)