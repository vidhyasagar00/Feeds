package com.sample.myFeeds.featureFeeds.domain.model

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    val id: String?,

    @SerializedName("feed_id")
    val feedId: String?,

    @SerializedName("user_id")
    val userId: String,

    val content: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,
)