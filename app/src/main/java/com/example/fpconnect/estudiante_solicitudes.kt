package com.example.fpconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

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
    }
}
