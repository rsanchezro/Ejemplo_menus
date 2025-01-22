package com.example.ejemplo_menus

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_menus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mibinding.button.setOnClickListener {
            val miIntent= Intent(this,Menu_Opciones::class.java)
            startActivity(miIntent)
        }
        mibinding.button2.setOnClickListener {
            val miIntent= Intent(this,Menu_Contextual::class.java)
            startActivity(miIntent)
        }
        mibinding.button3.setOnClickListener {
            val miIntent= Intent(this,Menu_AccionContextual::class.java)
            startActivity(miIntent)
        }

    }



}