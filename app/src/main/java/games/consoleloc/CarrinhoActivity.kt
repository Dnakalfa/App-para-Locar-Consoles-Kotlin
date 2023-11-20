package games.consoleloc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import games.consoleloc.R

class CarrinhoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrinho_compras)
        carregaCarrinho()
    }

    fun carregaCarrinho() {
        val escolha = intent.getStringExtra("escolhaConsole")
        val consoleAtual = findViewById<TextView>(R.id.escolhaConsoleTextView)
        consoleAtual.text = "Você escolheu $escolha."

        val escolhaConsoleTextView = findViewById<TextView>(R.id.escolhaConsoleTextView)
        escolhaConsoleTextView.text = "Escolha do Console: $escolha"
    }
}
