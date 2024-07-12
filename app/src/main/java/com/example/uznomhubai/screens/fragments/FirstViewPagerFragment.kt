package com.example.uznomhubai.screens.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uznomhubai.R
import com.example.uznomhubai.databinding.FragmentSplashScreenBinding

class FirstViewPagerFragment : Fragment(R.layout.fragment_first_view_pager) {

    private var _binding: FragmentSplashScreenBinding? = null

    private val binding: FragmentSplashScreenBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashScreenBinding.bind(view)
    }

}