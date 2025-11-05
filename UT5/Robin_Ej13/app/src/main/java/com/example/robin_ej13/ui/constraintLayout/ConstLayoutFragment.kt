package com.example.robin_ej13.ui.constraintLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.robin_ej13.databinding.FragmentConstlayoutBinding

class ConstLayoutFragment : Fragment() {

    private var _binding: FragmentConstlayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val constLayoutViewModel =
            ViewModelProvider(this).get(ConstLayoutViewModel::class.java)

        _binding = FragmentConstlayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}