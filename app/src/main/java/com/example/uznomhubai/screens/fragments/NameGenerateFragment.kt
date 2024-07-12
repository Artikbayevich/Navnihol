package com.example.uznomhubai.screens.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uznomhubai.R
import com.example.uznomhubai.adapter.RecyclerViewAdapter
import com.example.uznomhubai.api.ApiService
import com.example.uznomhubai.databinding.FragmentNameGenerateBinding
import com.example.uznomhubai.databinding.FragmentNameGeneratorBinding
import com.example.uznomhubai.model.request.RequestData
import com.example.uznomhubai.model.response.ResponseData
import com.example.uznomhubai.screens.MainActivity
import com.example.uznomhubai.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NameGenerateFragment : Fragment(R.layout.fragment_name_generate) {

    private var _binding: FragmentNameGenerateBinding? = null

    private val binding: FragmentNameGenerateBinding get() = _binding!!
    private val recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNameGenerateBinding.bind(view)

        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        setUpRecyclerView()

        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        val apiService = retrofit.create(ApiService::class.java)

        val jins = arguments?.getString("jins") ?: ""
        val opr = arguments?.getString("opr") ?: ""
        val det = arguments?.getString("det") ?: ""

        val requestData = RequestData(opr, det)

        if (jins == "Ayol") {
            apiService.getResponseFemale(requestData).enqueue(object: Callback<List<ResponseData>>{

                override fun onResponse(
                    call: Call<List<ResponseData>>,
                    response: Response<List<ResponseData>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let {
                            recyclerViewAdapter.submitList(data)
                            binding.recyclerViewName.adapter = recyclerViewAdapter
                            binding.progressBarName.visibility = View.INVISIBLE
                        }
                    }
                }

                override fun onFailure(call: Call<List<ResponseData>>, throwable: Throwable) {
                    Log.d("Misal", "onFailure: ${throwable.message}")
                }

            })
        }else if (jins == "Erkak") {
            apiService.getResponseMale(requestData).enqueue(object: Callback<List<ResponseData>>{

                override fun onResponse(
                    call: Call<List<ResponseData>>,
                    response: Response<List<ResponseData>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let {
                            recyclerViewAdapter.submitList(data)
                            binding.recyclerViewName.adapter = recyclerViewAdapter
                            binding.progressBarName.visibility = View.INVISIBLE
                        }
                    }
                }

                override fun onFailure(call: Call<List<ResponseData>>, throwable: Throwable) {
                    Log.d("Misal", "onFailure: ${throwable.message}")
                }

            })
        }

    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.recyclerViewName.layoutManager = layoutManager
    }

}