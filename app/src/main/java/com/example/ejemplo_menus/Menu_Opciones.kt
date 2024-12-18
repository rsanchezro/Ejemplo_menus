package com.example.ejemplo_menus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu_Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_opciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Para establecer el toolbar
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_opciones,menu)
        return true
    }
   public fun pulsa_opcion1(m:MenuItem)
    {
        var mialertBuilder=AlertDialog.Builder(this)
        mialertBuilder.setMessage("Has pulsado la opcion ${m.title}")
            .setTitle("Mensaje")
            .setPositiveButton("Ok"){d,w->
                //No se hace nada
            }
        val dialog=mialertBuilder.create()
        dialog.show()
    }
}