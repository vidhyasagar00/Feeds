package com.sample.myFeeds.featureFeeds.domain.model

import com.google.gson.annotations.SerializedName

data class CommentRequest(
    @SerializedName("user_id")
    val userId: String,

    val content: String?,
)
