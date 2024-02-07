package com.sample.myFeeds.featureFeeds.data.remote.repository

import com.sample.myFeeds.featureFeeds.data.remote.ApiResult
import com.sample.myFeeds.featureFeeds.domain.model.CommentRequest
import com.sample.myFeeds.featureFeeds.domain.model.CommentResponse
import com.sample.myFeeds.featureFeeds.domain.model.FeedRequest
import com.sample.myFeeds.featureFeeds.domain.model.FeedsResponse
import com.sample.myFeeds.featureFeeds.domain.repository.FeedsRepo

class FeedsRepoImpl : FeedsRepo {
    override fun getAllFeeds(): ApiResult<List<FeedsResponse>> {
        TODO("Not yet implemented")
    }

    override fun createFeed(feed: FeedRequest): ApiResult<FeedsResponse> {
        TODO("Not yet implemented")
    }

    override fun updateFeed(feedId: String, feed: FeedRequest) {
        TODO("Not yet implemented")
    }

    override fun getFeed(feedId: String): ApiResult<FeedsResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteFeed(feedId: String): ApiResult<Unit> {
        TODO("Not yet implemented")
    }

    override fun likeFeed(feedId: String, userId: String): ApiResult<Unit> {
        TODO("Not yet implemented")
    }

    override fun getComments(feedId: String): ApiResult<List<CommentResponse>> {
        TODO("Not yet implemented")
    }

    override fun createComment(
        feedId: String,
        comment: CommentRequest
    ): ApiResult<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun getComment(feedId: String, commentId: String): ApiResult<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun updateComment(feedId: String, commentId: String): ApiResult<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteComment(feedId: String, commentId: String): ApiResult<Unit> {
        TODO("Not yet implemented")
    }
}