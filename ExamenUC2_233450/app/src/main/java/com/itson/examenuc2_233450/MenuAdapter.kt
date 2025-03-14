package com.itson.examenuc2_233450

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MenuAdapter(private val context: Context, private val opciones: Array<String>): BaseAdapter() {


    override fun getCount(): Int {
        return opciones.size
    }

    override fun getItem(position: Int): Any {
        return opciones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista = convertView ?: LayoutInflater.from(context).inflate(R.layout.opcion, parent, false)
        val textView:TextView = vista.findViewById(R.id.titulo_opcion)
        textView.text = opciones[position]

        textView.setOnClickListener (){
            val intento = Intent(context, detalle_pelicula::class.java)
        }
        return textView
    }
}