package com.example.uznomhubai.screens.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.FragmentNameGenerateBinding
import com.example.uznomhubai.databinding.FragmentNameObjectGeneratorBinding
import com.example.uznomhubai.screens.MainActivity

class NameObjectGeneratorFragment : Fragment(R.layout.fragment_name_object_generator) {

    private var _binding: FragmentNameObjectGeneratorBinding? = null
    private val binding: FragmentNameObjectGeneratorBinding get() = _binding!!

    private var opr: String = ""
    private var det: String = ""

    override fun onResume() {
        super.onResume()
        val sanoat = resources.getStringArray(R.array.sanoat)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, sanoat)

        val typeName = resources.getStringArray(R.array.sanoat_type)
        val arrayAdapterType = ArrayAdapter(requireContext(), R.layout.dropdown_item, typeName)

        with(binding) {
            autoCompleteText.setAdapter(arrayAdapter)
            autoCompleteTypeText.setAdapter(arrayAdapterType)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNameObjectGeneratorBinding.bind(view)

        with(binding) {

            backBtn.setOnClickListener {
                (requireActivity() as MainActivity).showBottomNavigation()
                parentFragmentManager.popBackStack()
            }

            autoCompleteText.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                opr = parent.getItemAtPosition(position).toString()

                if (opr == "Yo'nalishni tanlash orqali") {
                    typeTxt.visibility = View.VISIBLE
                    typeTxt.text = "Yo'nalishni tanlang:"
                    drowdownType.visibility = View.VISIBLE
                    editTextName.visibility = View.INVISIBLE

                    autoCompleteTypeText.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                        det = parent.getItemAtPosition(position).toString()
                    }

                }else if (opr == "Nom qanday harf yoki so'zdan boshlanishini kiritish orqali") {
                    typeTxt.visibility = View.VISIBLE
                    typeTxt.text = "Nom qanday harfdan yo'ki so'zdan boshlanishini kiriting:"
                    drowdownType.visibility = View.INVISIBLE
                    editTextName.visibility = View.VISIBLE
                }
            }



            generateBtn.setOnClickListener {
                val nameObjectResultFragment = NameObjectResultFragment()
                val nameObjectGeneratorFragment = Bundle().apply {
                    if (opr == "Yo'nalishni tanlash orqali"){
                        putString("opr", "raz")
                        if (det == "Oshxona"){
                            putString("det", "101")
                        }else if (det == "Novvoyxona"){
                            putString("det", "102")
                        }else if (det == "Kiyimlarni tozalash markazi"){
                            putString("det", "103")
                        }else if (det == "Sartaroshxona"){
                            putString("det", "104")
                        }else if (det == "Go‘zallik saloni"){
                            putString("det", "105")
                        }else if (det == "Restoran"){
                            putString("det", "106")
                        }else if (det == "Kafe"){
                            putString("det", "107")
                        }else if (det == "Oziq-ovqat do‘koni"){
                            putString("det", "108")
                        }else if (det == "Poyabzal do'koni"){
                            putString("det", "109")
                        }else if (det == "Kiyim-kechak do‘koni"){
                            putString("det", "110")
                        }else if (det == "Bolalar kiyimlari do‘koni"){
                            putString("det", "111")
                        }else if (det == "O‘yinchoqlar do‘koni"){
                            putString("det", "112")
                        }else if (det == "Dorixona"){
                            putString("det", "113")
                        }else if (det == "Tibbiy xizmat ko'rsatish"){
                            putString("det", "114")
                        }else if (det == "Poyabzal ustaxonasi"){
                            putString("det", "115")
                        }else if (det == "Tikuvchilik ustaxonasi"){
                            putString("det", "116")
                        }else if (det == "Mehmonxona"){
                            putString("det", "117")
                        }else if (det == "Choyxona"){
                            putString("det", "118")
                        }else if (det == "Kabobxona"){
                            putString("det", "119")
                        }else if (det == "Somsaxona"){
                            putString("det", "120")
                        }else if (det == "Ishlab chiqarish"){
                            putString("det", "121")
                        }else if (det == "Choy nomlari"){
                            putString("det", "122")
                        }else if (det == "Muzqaymoq nomlari"){
                            putString("det", "123")
                        }else if (det == "Konfet nomlari"){
                            putString("det", "124")
                        }else if (det == "To‘yxona nomlari"){
                            putString("det", "125")
                        }else if (det == "Fermer xo‘jaliklari nomlari"){
                            putString("det", "126")
                        }else if (det == "Saryog‘ nomlari"){
                            putString("det", "127")
                        }else if (det == "Betaraf so'zlar"){
                            putString("det", "128")
                        }else if (det == "Zaxira nomlar"){
                            putString("det", "129")
                        }else if (det == "Xalqona nomlar"){
                            putString("det", "130")
                        }
                    }else if (opr == "Nom qanday harf yoki so'zdan boshlanishini kiritish orqali"){
                        putString("opr", "raz_s")
                        putString("det", editTextName.text.toString())
                    }
                }
                nameObjectResultFragment.arguments = nameObjectGeneratorFragment
                navigateTo(nameObjectResultFragment)
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