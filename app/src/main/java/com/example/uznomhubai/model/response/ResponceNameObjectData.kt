package com.example.uznomhubai.model.response

import com.google.gson.annotations.SerializedName

class ResponceNameObjectData(
    @SerializedName("IDN")
    val idn: Int,
    @SerializedName("NAME")
    val name: String
)