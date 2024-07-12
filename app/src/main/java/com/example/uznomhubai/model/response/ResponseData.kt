package com.example.uznomhubai.model.response

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("IDN")
    val idn: Int,
    @SerializedName("NAME")
    val name: String,
    @SerializedName("DET")
    val det: String
)
