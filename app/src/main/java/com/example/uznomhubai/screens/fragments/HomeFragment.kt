package com.example.uznomhubai.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.FragmentHomeBinding
import com.example.uznomhubai.screens.MainActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        with(binding) {


            nameCvBtn.setOnClickListener {
                navigateTo(NameGeneratorFragment())
                (requireActivity() as MainActivity).hideBottomNavigation()
            }

            objectNameCvBtn.setOnClickListener {
                navigateTo(NameObjectGeneratorFragment())
                (requireActivity() as MainActivity).hideBottomNavigation()
            }

            placeNameCv.setOnClickListener {
                Toast.makeText(requireContext(),"Ushbu bo'lim ustida ish olib borilmoqda !",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navigateTo(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.frame_container, fragment)
            .addToBackStack(null).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}