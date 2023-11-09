package games.consoleloc.ui.gallery

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import games.consoleloc.R

class GalleryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "ITENS DISPONÍVEIS PARA ALUGAR"
    }
    val text: LiveData<String> = _text
}

class GalleryAluguelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_gallery)

        val consoleAtual = findViewById<TextView>(R.id.consoleAtual)
        consoleAtual.text = "Você escolheu Play1."

        // Chame a função setEscolhaConsole aqui se necessário
        setEscolhaConsole("Play1")
    }

    fun setEscolhaConsole(message: String) {
        println("consoleAtual")
    }
}




