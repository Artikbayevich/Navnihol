package com.example.uznomhubai.screens.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uznomhubai.R
import com.example.uznomhubai.adapter.ObjectNameRecyclerViewAdapter
import com.example.uznomhubai.api.ApiService
import com.example.uznomhubai.databinding.FragmentNameObjectResultBinding
import com.example.uznomhubai.model.request.RequestData
import com.example.uznomhubai.model.response.ResponceNameObjectData
import com.example.uznomhubai.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NameObjectResultFragment : Fragment(R.layout.fragment_name_object_result) {

    private var _binding: FragmentNameObjectResultBinding? = null
    private val binding: FragmentNameObjectResultBinding get() = _binding!!

    private val recyclerViewObjectItemBinding: ObjectNameRecyclerViewAdapter =
        ObjectNameRecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNameObjectResultBinding.bind(view)

        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        setUpRecyclerView()

        val opr = arguments?.getString("opr") ?: ""
        val det = arguments?.getString("det") ?: ""


        val requestData = RequestData(opr, det)

        binding.refreshBtn.setOnClickListener {
            binding.recyclerViewName.visibility = View.INVISIBLE
            binding.progressBarName.visibility = View.VISIBLE
            if (opr == "raz") {

                val okHttpClient = OkHttpClient().newBuilder()
                    .connectTimeout(120,TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(
                        GsonConverterFactory.create()
                    ).build()

                val apiService = retrofit.create(ApiService::class.java)

                apiService.getNameObjects(requestData).enqueue(object : Callback<List<ResponceNameObjectData>> {

                    override fun onResponse(
                        call: Call<List<ResponceNameObjectData>>,
                        response: Response<List<ResponceNameObjectData>>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()
                            data?.let {
                                recyclerViewObjectItemBinding.submitList(data)
                                binding.recyclerViewName.visibility = View.VISIBLE
                                binding.recyclerViewName.adapter = recyclerViewObjectItemBinding
                                binding.progressBarName.visibility = View.INVISIBLE
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<ResponceNameObjectData>>, throwable: Throwable) {
                        Log.d("Misal", "onFailure: ${throwable.message}")
                    }

                })
            }else if (opr == "raz_s") {

                val okHttpClient = OkHttpClient().newBuilder()
                    .connectTimeout(120,TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL2)
                    .client(okHttpClient)
                    .addConverterFactory(
                        GsonConverterFactory.create()
                    ).build()

                val apiService = retrofit.create(ApiService::class.java)

                apiService.getNameObjects(requestData).enqueue(object : Callback<List<ResponceNameObjectData>> {

                    override fun onResponse(
                        call: Call<List<ResponceNameObjectData>>,
                        response: Response<List<ResponceNameObjectData>>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()
                            data?.let {
                                recyclerViewObjectItemBinding.submitList(data)
                                binding.recyclerViewName.adapter = recyclerViewObjectItemBinding
                                binding.progressBarName.visibility = View.INVISIBLE
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<ResponceNameObjectData>>, throwable: Throwable) {
                        Log.d("Misal", "onFailure: ${throwable.message}")
                    }

                })
            }
        }

        if (opr == "raz") {

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(120,TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            val apiService = retrofit.create(ApiService::class.java)

            apiService.getNameObjects(requestData).enqueue(object : Callback<List<ResponceNameObjectData>> {

                override fun onResponse(
                    call: Call<List<ResponceNameObjectData>>,
                    response: Response<List<ResponceNameObjectData>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let {
                            recyclerViewObjectItemBinding.submitList(data)
                            binding.recyclerViewName.adapter = recyclerViewObjectItemBinding
                            binding.progressBarName.visibility = View.INVISIBLE
                        }
                    }
                }

                override fun onFailure(call: Call<List<ResponceNameObjectData>>, throwable: Throwable) {
                    Log.d("Misal", "onFailure: ${throwable.message}")
                }

            })
        }else if (opr == "raz_s") {

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(120,TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL2)
                .client(okHttpClient)
                .addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            val apiService = retrofit.create(ApiService::class.java)

            apiService.getNameObjects(requestData).enqueue(object : Callback<List<ResponceNameObjectData>> {

                override fun onResponse(
                    call: Call<List<ResponceNameObjectData>>,
                    response: Response<List<ResponceNameObjectData>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let {
                            recyclerViewObjectItemBinding.submitList(data)
                            binding.recyclerViewName.adapter = recyclerViewObjectItemBinding
                            binding.progressBarName.visibility = View.INVISIBLE
                        }
                    }
                }

                override fun onFailure(call: Call<List<ResponceNameObjectData>>, throwable: Throwable) {
                    Log.d("Misal", "onFailure: ${throwable.message}")
                }

            })
        }


    }

    private fun setUpRecyclerView() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewName.layoutManager = layoutManager
    }

}