package id.my.labsi.myapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.my.labsi.myapp.R

class FirstFragment : Fragment() {
    private var dataString: String? = null
    private var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dataString = it.getString("data")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text = view.findViewById(R.id.text)
    }

    override fun onResume() {
        super.onResume()
        text?.text = dataString
    }

    companion object {
        @JvmStatic
        fun sendData(dataString: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString("data", dataString)
                }
            }
    }
}