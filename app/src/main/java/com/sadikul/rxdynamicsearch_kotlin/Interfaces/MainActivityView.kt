package com.sadikul.rxdynamicsearch_kotlin.Interfaces

import android.content.Context

import com.sadikul.rxdynamicsearch_kotlin.Model.SearchResult

interface MainActivityView {

    fun showSearchData(searchResult: SearchResult)

    fun startLoading()

    fun stopLoading()

    fun showMessage(msg: String)

    fun getAppContext(): Context{
        return getAppContext()
    }
}
