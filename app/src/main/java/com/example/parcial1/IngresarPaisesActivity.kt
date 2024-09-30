package com.example.parcial1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IngresarPaisesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_paises)

        val editTextPais1 = findViewById<EditText>(R.id.etPais1)
        val editTextPais2 = findViewById<EditText>(R.id.etPais2)
        val editTextPais3 = findViewById<EditText>(R.id.etPais3)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val pais1 = editTextPais1.text.toString().trim()
            val pais2 = editTextPais2.text.toString().trim()
            val pais3 = editTextPais3.text.toString().trim()

            // Verificar que se ingresaron los tres países
            if (pais1.isNotEmpty() && pais2.isNotEmpty() && pais3.isNotEmpty()) {

                val paises = arrayListOf(pais1, pais2, pais3)

                // Navegar a la segunda pantalla (MainActivity) pasando los países
                val intent = Intent(this, MainActivity::class.java)
                intent.putStringArrayListExtra("paises", paises)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingrese los tres países.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}