package com.example.expandable.network


import com.msgp.data.network.model.GetFilterResponse
import io.reactivex.rxjava3.core.Single

import okhttp3.MultipartBody
import retrofit2.http.*


interface Api {
    @POST("GetFilter")
    fun getData(): Single<GetFilterResponse?>?
}