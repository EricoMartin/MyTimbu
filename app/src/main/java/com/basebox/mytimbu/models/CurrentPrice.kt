package com.basebox.mytimbu.models


import com.google.gson.annotations.SerializedName

data class CurrentPrice(
    @SerializedName("NGN")
    val nGN: List<Any>
)