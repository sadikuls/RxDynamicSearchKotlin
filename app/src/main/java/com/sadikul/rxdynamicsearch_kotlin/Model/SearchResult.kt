package com.sadikul.rxdynamicsearch_kotlin.Model

import com.google.gson.annotations.SerializedName

class SearchResult {

    @SerializedName("notice")
    var notice: List<SearchItem>? = null


    override fun toString(): String {
        return "Notices{" +
                "notice = '" + notice + '\''.toString() +
                "}"
    }
}
