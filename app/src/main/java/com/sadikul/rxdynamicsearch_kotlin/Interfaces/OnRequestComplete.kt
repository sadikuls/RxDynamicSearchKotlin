package com.sadikul.rxdynamicsearch_kotlin.Interfaces

import com.sadikul.rxdynamicsearch_kotlin.Model.SearchResult

interface OnRequestComplete {
    fun onRequestComplete(searchResult: SearchResult)
    fun onRequestError(errorMsg: String)
}
