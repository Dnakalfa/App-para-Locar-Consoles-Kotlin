package games.consoleloc.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import games.consoleloc.R
import games.consoleloc.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var radioGroup: RadioGroup
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val galleryViewModel: GalleryViewModel =
            ViewModelProvider(requireActivity()).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Initialize the radioGroup and radio button listener
        radioGroup = binding.radioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val message = when (checkedId) {
                R.id.play1 -> "Você escolheu Play1."
                R.id.play2 -> "Você escolheu Play2."
                R.id.play3 -> "Você escolheu Play3."
                R.id.xbox -> "Você escolheu Xbox."
                else -> "Nenhum botão de rádio selecionado."
            }

            // Update the LiveData value with the selected message
            var console =
            //galleryViewModel.setEscolhaConsole(message)

            // Log the message to the console
            print(": $message")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
