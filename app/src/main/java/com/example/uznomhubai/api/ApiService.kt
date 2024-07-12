package com.example.uznomhubai.api

import com.example.uznomhubai.model.request.RequestData
import com.example.uznomhubai.model.response.ResponceNameObjectData
import com.example.uznomhubai.model.response.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("qiz_nom")
    fun getResponseFemale(@Body requestData: RequestData) : Call<List<ResponseData>>

    @POST("ul_nom")
    fun getResponseMale(@Body requestData: RequestData) : Call<List<ResponseData>>

    @POST("obj_nom")
    fun getNameObjects(@Body requestData: RequestData) : Call<List<ResponceNameObjectData>>

}