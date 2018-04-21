package com.sadikul.rxdynamicsearch_kotlin.Network

import com.sadikul.rxdynamicsearch_kotlin.Model.SearchItem
import com.sadikul.rxdynamicsearch_kotlin.Utils.Constants

import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by ASUS on 10-Oct-17.
 */

interface ApiInterface {

    @POST(Constants.search_result_api)
    fun getData(@Query("key") key: String): Observable<SearchItem>

}
