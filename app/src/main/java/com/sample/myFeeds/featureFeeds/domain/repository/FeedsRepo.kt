package com.sample.myFeeds.featureFeeds.domain.repository

import com.sample.myFeeds.featureFeeds.data.remote.ApiResult
import com.sample.myFeeds.featureFeeds.domain.model.CommentRequest
import com.sample.myFeeds.featureFeeds.domain.model.CommentResponse
import com.sample.myFeeds.featureFeeds.domain.model.FeedRequest
import com.sample.myFeeds.featureFeeds.domain.model.FeedsResponse

interface FeedsRepo {

    fun getAllFeeds(): ApiResult<List<FeedsResponse>>

    fun createFeed(feed: FeedRequest): ApiResult<FeedsResponse>

    fun updateFeed(feedId: String, feed: FeedRequest)

    fun getFeed(feedId: String): ApiResult<FeedsResponse>

    fun deleteFeed(feedId: String): ApiResult<Unit>

    fun likeFeed(feedId: String, userId: String): ApiResult<Unit>

    fun getComments(feedId: String): ApiResult<List<CommentResponse>>

    fun createComment(feedId: String, comment: CommentRequest): ApiResult<CommentResponse>

    fun getComment(feedId: String, commentId: String): ApiResult<CommentResponse>

    fun updateComment(feedId: String, commentId: String): ApiResult<CommentResponse>

    fun deleteComment(feedId: String, commentId: String): ApiResult<Unit>
}