package games.consoleloc.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import games.consoleloc.CarrinhoActivity
import games.consoleloc.R

class GalleryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "ITENS DISPONÍVEIS PARA ALUGAR"
    }
    val text: LiveData<String> = _text
}

class GalleryAluguelActivity : AppCompatActivity() {

    private lateinit var viewModel: GalleryViewModel
    private val mapaDeConsoles = hashMapOf(
        R.id.play3 to "PlayStation 3",
        R.id.play1 to "PlayStation 1",
        R.id.play2 to "PlayStation 2",
        R.id.xbox to "Xbox"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_gallery)

        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        val textViewGallery = findViewById<TextView>(R.id.text_gallery)

        setEscolhaConsole(textViewGallery)
    }

    private fun setEscolhaConsole(textView: TextView) {
        val consoleAtual = findViewById<RadioGroup>(R.id.radioGroup)
        consoleAtual.setOnCheckedChangeListener { _, checkedId: Int ->
            val radioButton = findViewById<RadioButton>(checkedId)

            if (mapaDeConsoles.containsKey(checkedId)) {
                val escolhaDoConsole = mapaDeConsoles[checkedId]

                textView.text = "O console selecionado é: ${escolhaDoConsole ?: "Escolha não encontrada"}"

                Log.d("Opcao", escolhaDoConsole ?: "Escolha não encontrada")

                val intent = Intent(this, CarrinhoActivity::class.java)
                intent.putExtra("escolhaConsole", escolhaDoConsole)
                startActivity(intent)
            } else {
                Log.e("Opcao", "ID do RadioButton não está mapeado para nenhum console.")
            }
        }
    }
}




