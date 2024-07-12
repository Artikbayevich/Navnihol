package com.example.uznomhubai.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment(R.layout.fragment_about_us) {

    private var _binding: FragmentAboutUsBinding? = null

    private val binding: FragmentAboutUsBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}