package com.sadikul.rxdynamicsearch_kotlin.Model

import com.google.gson.annotations.SerializedName

class SearchItem {
    @SerializedName("image_link")
    private var imageLink: String? = null

    @SerializedName("pdf_link")
    private var pdfLink: String? = null

    @SerializedName("id")
    private var id: String? = null

    @SerializedName("time")
    private var time: String? = null

    @SerializedName("title")
    private var title: String? = null

    @SerializedName("descript")
    private var descript: String? = null


    fun setImageLink(imageLink: String) {
        this.imageLink = imageLink
    }

    fun getImageLink(): String? {
        return imageLink
    }

    fun setPdfLink(pdfLink: String) {
        this.pdfLink = pdfLink
    }

    fun getPdfLink(): String? {
        return pdfLink
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getId(): String? {
        return id
    }

    fun setTime(time: String) {
        this.time = time
    }

    fun getTime(): String? {
        return time
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getTitle(): String? {
        return title
    }

    fun setDescript(descript: String) {
        this.descript = descript
    }

    fun getDescript(): String? {
        return descript
    }

    override fun toString(): String {
        return "NoticeItem{" +
                "image_link = '" + imageLink + '\''.toString() +
                ",pdf_link = '" + pdfLink + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",time = '" + time + '\''.toString() +
                ",title = '" + title + '\''.toString() +
                ",descript = '" + descript + '\''.toString() +
                "}"
    }

}