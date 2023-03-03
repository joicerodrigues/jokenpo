package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecionaPedra(view: View?) {
        opcaoSelecionada("pedra")
    }

    fun selecionaTesoura(view: View?) {
        opcaoSelecionada("tesoura")
    }

    fun selecionaPapel(view: View?) {
        opcaoSelecionada("papel")
    }

    fun selecionaFerro(view: View?) {
        opcaoSelecionada("ferro")
    }

    fun opcaoSelecionada(escolhaUsuario: String) {
        val imagemResultado = findViewById<ImageView>(R.id.resultado)
        val textoResultado = findViewById<TextView>(R.id.txtresultado)
        val numero = Random().nextInt(4)
        val opcoes = arrayOf("pedra", "tesoura", "papel", "ferro")
        val escolhaApp = opcoes[numero]
        when (escolhaApp) {
            "pedra" -> imagemResultado.setImageResource(R.drawable.pedra)
            "tesoura" -> imagemResultado.setImageResource(R.drawable.tesoura)
            "papel" -> imagemResultado.setImageResource(R.drawable.papel)
            "ferro" -> imagemResultado.setImageResource(R.drawable.ferro)
        }
        if (escolhaApp == "tesoura" && escolhaUsuario == "papel" || escolhaApp == "papel" && escolhaUsuario == "pedra" || escolhaApp == "ferro" && escolhaUsuario == "tesoura" || escolhaApp == "pedra" && escolhaUsuario == "tesoura") {
            textoResultado.setText("O Aplicativo Ganhou")
        } else if (escolhaUsuario == "tesoura" && escolhaApp == "papel" || escolhaUsuario == "papel" && escolhaApp == "pedra" || escolhaUsuario == "ferro" && escolhaApp == "tesoura" || escolhaUsuario == "pedra" && escolhaApp == "tesoura") {
            textoResultado.setText("Você Venceu")
        } else {
            textoResultado.setText("Empate")
        }
    }
}