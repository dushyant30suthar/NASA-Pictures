package com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities


import com.google.gson.annotations.SerializedName

/*
* Image is one picture a day. */
data class CosmosImageEntity(

    /*
    * Bound to be a unique. Treating it as an id.*/
    @SerializedName("date")
    val date: String = "",
    @SerializedName("copyright")
    val copyright: String = "",
    @SerializedName("media_type")
    val mediaType: String = "",
    @SerializedName("hdurl")
    val hdUrl: String = "",
    @SerializedName("service_version")
    val serviceVersion: String = "",
    @SerializedName("explanation")
    val explanation: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",

    val id: String = date,


    /*
    * Ignore parsing. */
    val isBookmarked: Boolean
)


