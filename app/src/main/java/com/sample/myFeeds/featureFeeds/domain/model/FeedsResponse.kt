package com.sample.myFeeds.featureFeeds.domain.model

import com.google.gson.annotations.SerializedName

data class FeedsResponse(

    val id: String,

    @SerializedName("user_id")
    val userId: String,

    val description: String?,

    val comments: List<String>?,

    @SerializedName("image_url")
    val imageUrl: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    val likes: List<String?>?,

    val shares: List<String>?,

    val tags: List<String>?
)