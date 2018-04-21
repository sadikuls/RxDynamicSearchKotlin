package com.sadikul.rxdynamicsearch_kotlin.Network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.sadikul.rxdynamicsearch_kotlin.Utils.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ASUS on 10-Oct-17.
 */

object RetrofiClient {
    val retrofitClient: Retrofit
        get() = Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    val apiInterface: ApiInterface
        get() = retrofitClient.create(ApiInterface::class.java)
}
