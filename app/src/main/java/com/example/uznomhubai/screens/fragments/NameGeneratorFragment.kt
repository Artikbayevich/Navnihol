package com.example.uznomhubai.screens.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.get
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.FragmentNameGeneratorBinding
import com.example.uznomhubai.screens.MainActivity

class NameGeneratorFragment : Fragment(R.layout.fragment_name_generator) {

    private var _binding: FragmentNameGeneratorBinding? = null
    private val binding: FragmentNameGeneratorBinding get() = _binding!!

    private var opr: String = "Erkak"
    private var det: String = ""

    override fun onResume() {
        super.onResume()

        val typeName = resources.getStringArray(R.array.ism_tanlash_usuli)
        val arrayAdapterType = ArrayAdapter(requireContext(), R.layout.dropdown_item,typeName)

        with(binding) {
            radioGroupJins.setOnCheckedChangeListener { group, checkedId ->

                when(checkedId) {
                    R.id.radioBtnMale -> {
                        opr = "Erkak"
                    }
                    R.id.radioBtnFemale -> {
                        opr = "Ayol"
                    }
                }

            }
            autoCompleteTypeText.setAdapter(arrayAdapterType)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNameGeneratorBinding.bind(view)



        with(binding) {

            backBtn.setOnClickListener {
                (requireActivity() as MainActivity).showBottomNavigation()
                parentFragmentManager.popBackStack()
            }

            autoCompleteTypeText.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                det = parent.getItemAtPosition(position).toString()
            }

            generateBtn.setOnClickListener {
                val nameGenerateFragment = NameGenerateFragment()
                val nameGeneratorFragmentBundle = Bundle().apply {
                    if (opr == "Ayol") {
                        putString("jins", "Ayol")
                        if (det == "Atoqli nomlarni mazmuniga muvofiq shakllantirish") {
                            putString("opr", "qiz")
                            putString("det", editTextName.text.toString())
                        } else if (det == "Atoqli nomlarni monandlik asosida shakllantirish") {
                            putString("opr", "mon")
                            putString("det", editTextName.text.toString())
                        } else if (det == "Atoqli nomlarni bosh xarflar bo'yicha shakllantirish") {
                            putString("opr", "bosh")
                            putString("det", editTextName.text.toString())
                        }
                    }else if (opr == "Erkak") {
                        putString("jins", "Erkak")
                        if (det == "Atoqli nomlarni mazmuniga muvofiq shakllantirish") {
                            putString("opr", "ul")
                            putString("det", editTextName.text.toString())
                        } else if (det == "Atoqli nomlarni monandlik asosida shakllantirish") {
                            putString("opr", "mon")
                            putString("det", editTextName.text.toString())
                        } else if (det == "Atoqli nomlarni bosh xarflar bo'yicha shakllantirish") {
                            putString("opr", "bosh")
                            putString("det", editTextName.text.toString())
                        }
                    }
                }
                nameGenerateFragment.arguments = nameGeneratorFragmentBundle
                navigateTo(nameGenerateFragment)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (requireActivity() as MainActivity).showBottomNavigation()
                parentFragmentManager.popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private fun navigateTo(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit()
    }

}