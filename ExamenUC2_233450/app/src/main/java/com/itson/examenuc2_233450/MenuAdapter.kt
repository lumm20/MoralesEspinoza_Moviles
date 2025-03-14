package com.itson.examenuc2_233450

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MenuAdapter(private val context: Context, private val productos: ArrayList<Producto>): BaseAdapter() {


    override fun getCount(): Int {
        return productos.size
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista = convertView ?: LayoutInflater.from(context).inflate(R.layout.opcion, parent, false)
        var producto=productos[position]
        val precio:TextView = vista.findViewById(R.id.producto_precio)
        val img:ImageView = vista.findViewById(R.id.producto_img)
        img.setImageResource(producto.imagen)
        precio.setText("$${producto.precio}")

        return vista
    }
}