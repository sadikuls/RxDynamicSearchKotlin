package com.sadikul.rxdynamicsearch_kotlin.Model

import com.google.gson.annotations.SerializedName

class SearchResult {

    @SerializedName("notice")
    private var notice: MutableList<SearchItem>? = null


    fun getSearchItems(): MutableList<SearchItem>?{
        return this.notice
    }

    override fun toString(): String {
        return "Notices{" +
                "notice = '" + notice + '\''.toString() +
                "}"
    }
}
