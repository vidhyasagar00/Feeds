package com.sample.myFeeds.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.myFeeds.core.navigations.Screens
import com.sample.myFeeds.core.presentation.theme.FeedsTheme
import com.sample.myFeeds.featureFeeds.presentation.feedsScreen.FeedsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedsTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.FeedsScreen.route
                    ) {
                        composable(Screens.FeedsScreen.route) {
                            FeedsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}