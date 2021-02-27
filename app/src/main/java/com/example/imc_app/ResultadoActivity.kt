package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_resultado.*
import java.time.LocalDateTime
import kotlin.collections.ArrayList
import kotlin.random.Random

class ResultadoActivity : AppCompatActivity() {
    private lateinit var imcAdapter: ImcAdapter
    private lateinit var medidas : ArrayList<Medida>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val peso = intent.getDoubleExtra("peso", 72.5)
        val altura = intent.getDoubleExtra("altura", 1.75)

        val imc = peso / (altura * altura)

        Toast.makeText(this, "Tu IMC es: $imc", Toast.LENGTH_LONG).show()
        initRecycler()
    }

    fun initRecycler(){
        medidas = ArrayList<Medida>()
        imcAdapter = ImcAdapter(medidas)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = imcAdapter
        for( i in 0..30){
            val fecha = LocalDateTime.now()
            val peso = String.format( "%.2f" , Random.nextDouble()* 100 ).toDouble()
            val altura = String.format( "%.2f" , 1 + Random.nextDouble() ).toDouble()
            val medida = Medida(fecha.toString(),peso, altura )
            medidas.add( medida)
        }

    }

}