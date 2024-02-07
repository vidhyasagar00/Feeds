package com.sample.myFeeds.featureFeeds.domain.model

import com.google.gson.annotations.SerializedName

data class FeedRequest(
    @SerializedName("user_id")
    val userId: String,

    val description: String?,

    @SerializedName("image_url")
    val imageUrl: String?,
)
