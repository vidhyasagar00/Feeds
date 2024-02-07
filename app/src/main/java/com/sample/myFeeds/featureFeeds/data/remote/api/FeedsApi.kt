package com.sample.myFeeds.featureFeeds.data.remote.api

import com.sample.myFeeds.featureFeeds.domain.model.CommentRequest
import com.sample.myFeeds.featureFeeds.domain.model.CommentResponse
import com.sample.myFeeds.featureFeeds.domain.model.FeedRequest
import com.sample.myFeeds.featureFeeds.domain.model.FeedsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface FeedsApi {

    @GET("feeds/")
    fun getAllFeeds(): Response<List<FeedsResponse>>

    @POST("feeds/")
    fun createFeed(
        @Body feed: FeedRequest
    ): Response<FeedsResponse>

    @PUT("feed/{feed_id}/")
    fun updateFeed(
        @Path("feed_id") feedId: String,
        @Body feed: FeedRequest
    )

    @GET("feed/{feed_id}/")
    fun getFeed(
        @Path("feed_id") feedId: String,
    ): Response<FeedsResponse>

    @DELETE("feed/{feed_id}/")
    fun deleteFeed(
        @Path("feed_id") feedId: String,
    ): Response<Unit>

    @PUT("feed/{feed_id}/like/{user_id}")
    fun likeFeed(
        @Path("feed_id") feedId: String,
        @Path("user_id") userId: String
    ): Response<Unit>

    @GET("feed/{feed_id}/comments")
    fun getComments(
        @Path("feed_id") feedId: String
    ): Response<List<CommentResponse>>

    @POST("feed/{feed_id}/comments")
    fun createComment(
        @Path("feed_id") feedId: String,
        @Body comment: CommentRequest
    ): Response<CommentResponse>

    @GET("feed/{feed_id}/comment/{comment_id}")
    fun getComment(
        @Path("feed_id") feedId: String,
        @Path("comment_id") commentId: String
    ): Response<CommentResponse>

    @PUT("feed/{feed_id}/comment/{comment_id}")
    fun updateComment(
        @Path("feed_id") feedId: String,
        @Path("comment_id") commentId: String
    ): Response<CommentResponse>

    @DELETE("feed/{feed_id}/comment/{comment_id}")
    fun deleteComment(
        @Path("feed_id") feedId: String,
        @Path("comment_id") commentId: String
    ): Response<Unit>
}