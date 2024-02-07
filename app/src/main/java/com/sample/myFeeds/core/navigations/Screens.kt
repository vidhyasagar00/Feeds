package com.sample.myFeeds.core.navigations

sealed class Screens(val route: String) {
    data object FeedsScreen : Screens("feeds")
}