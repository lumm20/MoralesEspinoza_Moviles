package com.itson.examenuc2_233450

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleOpcion : AppCompatActivity() {
    var menu: ArrayList<Producto> = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_opcion)

        var categoria:TextView=findViewById(R.id.tv_categoria)
        val bundle=intent.extras
        if(bundle!= null){
            when(bundle.getString("opcion")){
                "detalles"->{
                    agregarDetalles()
                    categoria.setText("Detalles")
                }
                "globos"->{
                    agregarGlobos()
                    categoria.setText("Globos")
                }
                "peluches"->{
                    agregarPeluches()
                    categoria.setText("Peluches")
                }
                "regalos"->{
                    agregarRegalos()
                    categoria.setText("Regalos")
                }
                "tazas"->{
                    agregarTazas()
                    categoria.setText("Tazas")
                }
            }
        }
        var listView: ListView =findViewById(R.id.lista)

        var adapter: MenuAdapter = MenuAdapter(this,menu)
        listView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun agregarDetalles(){
        menu.add(Producto(R.drawable.cumplebotanas,240.0))
        menu.add(Producto(R.drawable.cumplecheve,280.0))
        menu.add(Producto(R.drawable.cumpleescolar,260.0))
        menu.add(Producto(R.drawable.cumplepaletas,760.0))
        menu.add(Producto(R.drawable.cumplesnack,450.0))
        menu.add(Producto(R.drawable.cumplevinos,240.0))
    }
    fun agregarGlobos(){
        menu.add(Producto(R.drawable.globoamor,280.0))
        menu.add(Producto(R.drawable.globocumple,320.0))
        menu.add(Producto(R.drawable.globofestejo,330.0))
        menu.add(Producto(R.drawable.globonum,190.0))
        menu.add(Producto(R.drawable.globoregalo,150.0))
        menu.add(Producto(R.drawable.globos,370.0))
    }
    fun agregarPeluches(){
        menu.add(Producto(R.drawable.peluchemario,320.0))
        menu.add(Producto(R.drawable.pelucheminecraft,320.0))
        menu.add(Producto(R.drawable.peluchepeppa,290.0))
        menu.add(Producto(R.drawable.peluches,190.0))
        menu.add(Producto(R.drawable.peluchesony,330.0))
        menu.add(Producto(R.drawable.peluchestich,280.0))
        menu.add(Producto(R.drawable.peluchevarios,195.0))
    }
    fun agregarRegalos(){
        menu.add(Producto(R.drawable.regaloazul,80.0))
        menu.add(Producto(R.drawable.regalobebe,290.0))
        menu.add(Producto(R.drawable.regalocajas,140.0))
        menu.add(Producto(R.drawable.regalocolores,85.0))
        menu.add(Producto(R.drawable.regalos,200.0))
        menu.add(Producto(R.drawable.regalovarios,75.0))
    }
    fun agregarTazas(){
        menu.add(Producto(R.drawable.tazaabuela,120.0))
        menu.add(Producto(R.drawable.tazalove,120.0))
        menu.add(Producto(R.drawable.tazaquiero,260.0))
        menu.add(Producto(R.drawable.tazas,280.0))
    }
}