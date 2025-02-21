package com.itson.practica4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        agregarProductos()

        var listView:ListView=findViewById(R.id.listView) as ListView

        var adapter: ProductsAdapter = ProductsAdapter(this,menu)
        listView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun agregarProductos(){
        menu.add(Product("Quesadillas",R.drawable.quesadillas,"Rellenas con su carne" +
                "favorita, servidas con ensalada. Filled with your choice of meat," +
                "served with salad.",5.99))
        menu.add(Product("Huaraches",R.drawable.huaraches,"Tortilla gruesa con" +
                "frijoles, tu carne favorita, lechuga, queso fresco y crema. Big thick tortilla with" +
                "beans, your choice of meat, lettuce, fresh cheese and sour cream.",10.99))
        menu.add(Product("Gringas",R.drawable.gringas,"Tortilla de harina con queso," +
                "carne al pastor y piña. Flour tortilla filled with cheese, marinated pork and pinneaple.",
            7.99))
        menu.add(Product("sincronizada",R.drawable.sincronizadas,"Tortilla de harina" +
                "rellena con queso y jamon. Acompañada de lechuga, crema y guacamole - Two flour " +
                "tortillas filled with jam and cheese. Served with lettuce, sour cream, and guacamole",
            7.99))
        menu.add(Product("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles," +
                " tu carne favorita, lechuga, queso fresco y crema - Big thick tortilla covered with beans," +
                " your choice of meat, lettuce, fresh cheese, and sour cream.",3.79))
        menu.add(Product("Tostadas",R.drawable.tostadas,"Tortilla frita con frijoles," +
                " tu carne favorita, lechuga, queso fresco, crema y jitomate - Fried tortilla with " +
                "beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.",4.59))
    }

    private class ProductsAdapter:BaseAdapter{
        var products=ArrayList<Product>()
        var context: Context?=null

        constructor(context: Context, products: ArrayList<Product>){
            this.products = products
            this.context = context
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=products[position]
            var inflador= LayoutInflater.from(context)
            var vista=inflador.inflate(R.layout.product_view,null)

            var img=vista.findViewById(R.id.producto_img) as ImageView
            var nombre=vista.findViewById(R.id.producto_nombre) as TextView
            var desc=vista.findViewById(R.id.producto_descrp) as TextView
            var precio=vista.findViewById(R.id.producto_precio) as TextView

            img.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista

        }
    }
}