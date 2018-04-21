package com.sadikul.rxdynamicsearch_kotlin.Presenter

import com.sadikul.rxdynamicsearch_kotlin.Interfaces.MainActivityView
import com.sadikul.rxdynamicsearch_kotlin.Interfaces.OnRequestComplete
import com.sadikul.rxdynamicsearch_kotlin.Interfaces.SearchApi
import com.sadikul.rxdynamicsearch_kotlin.Model.SearchResult

/**
 * Created by ASUS on 11-Oct-17.
 */

class Presenter(internal var view: MainActivityView) {

    fun getSearchResult(query: String) {
        SearchApi(view.getAppContext(), query, object: OnRequestComplete {
            override fun onRequestComplete(o: SearchResult) {
                view.stopLoading()
                view.showSearchData(o)
            }

            override fun onRequestError(errorMsg: String) {
                view.stopLoading()
                view.showMessage(errorMsg)
            }
        })
    }

}
