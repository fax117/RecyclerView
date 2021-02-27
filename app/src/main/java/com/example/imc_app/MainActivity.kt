package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicia()
    }

    fun inicia(){
        calcula.setOnClickListener {
            val peso_ = peso.text.toString().toDouble()
            val altura_ = altura.text.toString().toDouble()
            val intento = Intent(this, ResultadoActivity::class.java)
            intento.putExtra("peso", peso_)
            intento.putExtra("altura", altura_)
            startActivity(intento)
        }
    }

}

