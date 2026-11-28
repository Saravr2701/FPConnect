package com.example.fpconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class estudiante_perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estudiante_perfil)

        val btnInicio = findViewById<ImageButton>(R.id.btnInicio)
        val btnSolicitudes = findViewById<ImageButton>(R.id.btnSolicitudes)

        btnInicio.setOnClickListener {
            val intent = Intent(this, estudiante_inicio::class.java)
            startActivity(intent)
        }

        btnSolicitudes.setOnClickListener {
            val intent = Intent(this, estudiante_solicitudes::class.java)
            startActivity(intent)
        }
    }
}
