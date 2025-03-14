package com.itson.examenuc2_233450

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuOpciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_opciones)

        val btnDetalles:Button=findViewById(R.id.boton_detalles)
        val btnGlobos:Button=findViewById(R.id.boton_globos)
        val btnPeluches:Button=findViewById(R.id.boton_peluches)
        val btnRegalos:Button=findViewById(R.id.boton_regalos)
        val btnTazas:Button=findViewById(R.id.boton_tazas)

        btnDetalles.setOnClickListener{
            var intent: Intent = Intent(this, DetalleOpcion::class.java)
            intent.putExtra("opcion","detalles")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener{
            var intent: Intent = Intent(this, DetalleOpcion::class.java)
            intent.putExtra("opcion","globos")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener{
            var intent: Intent = Intent(this, DetalleOpcion::class.java)
            intent.putExtra("opcion","peluches")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener{
            var intent: Intent = Intent(this, DetalleOpcion::class.java)
            intent.putExtra("opcion","regalos")
            startActivity(intent)
        }
        btnTazas.setOnClickListener{
            var intent: Intent = Intent(this, DetalleOpcion::class.java)
            intent.putExtra("opcion","tazas")
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}