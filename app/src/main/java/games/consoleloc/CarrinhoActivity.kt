package games.consoleloc
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import games.consoleloc.ui.gallery.GalleryAluguelActivity
import games.consoleloc.ui.gallery.GalleryFragment
import games.consoleloc.ui.gallery.GalleryViewModel

class CarrinhoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrinho_compras)
        carregaCarrinho()
    }

    fun carregaCarrinho() {

        val escol = GalleryAluguelActivity()
        var escolta = escol.setEscolhaConsole("")
        carrinhoCheio(escolta.toString())
        val consoleAtual = findViewById<TextView>(R.id.itemAdd1)
        consoleAtual.text = "Você escolheu Play1."
    }
    private fun carrinhoCheio(escolhido: String) {

        return println("voce add: $escolhido")
    }
}


