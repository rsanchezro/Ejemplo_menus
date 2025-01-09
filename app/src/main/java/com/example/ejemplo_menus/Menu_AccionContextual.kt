package com.example.ejemplo_menus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu_AccionContextual : AppCompatActivity() {
//1er paso
 var miactionMode: ActionMode?=null
 lateinit var mieditText:EditText
 lateinit var mitextView:TextView
 var textocopiar:String=""
//2º Paso
    private val actionModecallback= object : ActionMode.Callback {
        // Invocado cuando el ActionMode se crea; se invocó a startActionMode()
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            // Aqui es donde inflo el menu
          menuInflater.inflate(R.menu.menu_accioncontextual, menu);
            return true;
        }
        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        /* Se invoca cada vez que el action mode se muestra. Siempre se llama despues de
        onCreateActionMode, pero quizas se llama varias veces si el modo esta invalidado
         */
        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
           //Retornamos false si no hace nada
            return false
        }

        // Se llama cuando el usuario selecciona un elemento del menu de accion contextual
        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {

             return   when(item?.itemId) {

                 R.id.pegar-> {
                     //Aqui pego el texto que tenia guardado en el TextView
                     mitextView.text=textocopiar
                     true
                 }
                 R.id.copiar->
                     {
                     textocopiar=mieditText.text.toString()
                     true
                 }
                 R.id.salir->{//Salgo del menu
                            mode?.finish()
                            true
                 }

                 else ->false



                }

        }
            //Invocado cuando el usuario sale del ActionMode
        override fun onDestroyActionMode(mode: ActionMode?) {
           miactionMode=null
        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_accion_contextual)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Establezco el menu de acción contextual cuando hago pulsación larga sobre el editText
        mieditText=findViewById(R.id.editText)
        mitextView=findViewById(R.id.texto2)
        mieditText.setOnLongClickListener {
            when(miactionMode) {
             null -> {//Abro el menu
                 miactionMode = startSupportActionMode(actionModecallback)
                 true
             }
             else->
                 false

         }
        }

    }
}