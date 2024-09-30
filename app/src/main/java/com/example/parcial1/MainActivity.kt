package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var listaDeportistas: ListView
    private lateinit var deportistas: List<Deportista>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinnerPaises)
        listaDeportistas = findViewById(R.id.listViewDeportistas)

        val paises = intent.getStringArrayListExtra("paises") ?: arrayListOf("Argentina", "Estados Unidos", "España")

        // Verificar si hay países
        if (paises.isNotEmpty()) {
            val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, paises)
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adaptador
        } else {
            Toast.makeText(this, "No se encontraron países", Toast.LENGTH_SHORT).show()
        }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        // Acción al seleccionar un deportista
        listaDeportistas.setOnItemClickListener { _, _, position, _ ->
            val deportistaSeleccionado = deportistas[position]
            Log.d("MainActivity", "Deportista seleccionado: ${deportistaSeleccionado.nombre}")

            val intent = Intent(this, DetalleDeportistaActivity::class.java)
            intent.putExtra("nombreDeportista", deportistaSeleccionado.nombre)
            intent.putExtra("deporteDeportista", deportistaSeleccionado.deporte)
            intent.putExtra("deportistaActivo", deportistaSeleccionado.estaActivo)


            Log.d("MainActivity", "Datos a enviar: Nombre: ${deportistaSeleccionado.nombre}, Deporte: ${deportistaSeleccionado.deporte}, Activo: ${deportistaSeleccionado.estaActivo}")

            startActivity(intent)
        }
    }

    // Método para obtener la lista de deportistas según el país seleccionado
    private fun obtenerDeportistasPorPais(pais: String): List<Deportista> {
        return when (pais) {
            "Argentina" -> listOf(
                Deportista("Lionel Messi", "Fútbol", true),
                Deportista("Diego Maradona", "Fútbol", false),
                Deportista("Juan Martín del Potro", "Tenis", false),
                Deportista("Gabriela Sabatini", "Tenis", false),
                Deportista("Manu Ginóbili", "Baloncesto", false),
                Deportista("Sergio Agüero", "Fútbol", false),
                Deportista("Paula Pareto", "Judo", true),
                Deportista("Luciana Aymar", "Hockey sobre césped", false),
                Deportista("Carlos Tevez", "Fútbol", false),
                Deportista("Javier Mascherano", "Fútbol", false)
            )
            "Estados Unidos" -> listOf(
                Deportista("Michael Jordan", "Baloncesto", false),
                Deportista("Serena Williams", "Tenis", true),
                Deportista("LeBron James", "Baloncesto", true),
                Deportista("Tiger Woods", "Golf", true),
                Deportista("Simone Biles", "Gimnasia", true),
                Deportista("Tom Brady", "Fútbol Americano", false),
                Deportista("Kobe Bryant", "Baloncesto", false),
                Deportista("Shaun White", "Snowboard", false),
                Deportista("Megan Rapinoe", "Fútbol", true),
                Deportista("Carl Lewis", "Atletismo", false)
            )
            "España" -> listOf(
                Deportista("Rafael Nadal", "Tenis", true),
                Deportista("Pau Gasol", "Baloncesto", false),
                Deportista("Iker Casillas", "Fútbol", false),
                Deportista("Fernando Alonso", "Fórmula 1", true),
                Deportista("Xavi Hernández", "Fútbol", false),
                Deportista("Andrés Iniesta", "Fútbol", true),
                Deportista("Mireia Belmonte", "Natación", true),
                Deportista("Marc Márquez", "Motociclismo", true),
                Deportista("David Villa", "Fútbol", false),
                Deportista("Garbiñe Muguruza", "Tenis", true)
            )
            else -> emptyList()
        }
    }
}
