package com.example.parcial1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleDeportistaActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_deportista)

        // Obtener datos del intent
        val nombre = intent.getStringExtra("nombreDeportista")
        val deporte = intent.getStringExtra("deporteDeportista")
        val estaActivo = intent.getBooleanExtra("deportistaActivo", false)

        val nombreTextView = findViewById<TextView>(R.id.textViewNombre)
        val deporteTextView = findViewById<TextView>(R.id.textViewDeporte)
        val estadoTextView = findViewById<TextView>(R.id.textViewActivo)

        nombreTextView.text = "Nombre: $nombre"
        deporteTextView.text = "Deporte: $deporte"
        estadoTextView.text = if (estaActivo) "Estado: Activo" else "Estado: Retirado"

        val buttonVolver = findViewById<Button>(R.id.buttonVolver)
        buttonVolver.setOnClickListener {
            finish()
        }
    }
}
