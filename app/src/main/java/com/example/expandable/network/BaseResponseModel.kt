package com.example.expandable.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponseModel {
    @SerializedName("error_cd")
    @Expose
    var code: Int? = 0

    @SerializedName("error_msg")
    @Expose
    var message: String? = ""
}