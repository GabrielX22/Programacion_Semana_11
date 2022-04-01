package com.example.programacionsemana11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var contador = 3
        imagenogirar.visibility = View.GONE
        imagedecision.visibility = View.GONE
        imagegirar.setOnClickListener {

            if(contador == 0){
                imagegirar.visibility = View.GONE
                imagenogirar.visibility = View.VISIBLE
                imagedecision.setImageResource(R.drawable.perdido)
                imagedecision.visibility = View.VISIBLE
            }
            else{
                val numeros = mutableListOf("1","2","3","4","5","6","7","8","9")
                txt1.text = (numeros.random())
                txt2.text = (numeros.random())
                txt3.text = (numeros.random())
                txtintentos.setText("Intentos: "+ --contador)
            }
            if(txt1.text.equals("7") && txt2.text.equals("7") && txt3.text.equals("7") ){
                imagedecision.setImageResource(R.drawable.ganado)
                imagedecision.visibility = View.VISIBLE
                imagegirar.visibility = View.GONE
                imagenogirar.visibility = View.VISIBLE
            }
        }
        imagereiniciar.setOnClickListener {
            contador = 3
            txtintentos.setText("Intentos: 3")
            imagedecision.visibility = View.GONE
            imagenogirar.visibility = View.GONE
            imagegirar.visibility = View.VISIBLE
        }
        imagecreador.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}