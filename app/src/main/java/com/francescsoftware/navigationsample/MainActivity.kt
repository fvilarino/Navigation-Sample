package com.francescsoftware.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.francescsoftware.navigationsample.one.DestinationOneRoute
import com.francescsoftware.navigationsample.one.addOneDestination
import com.francescsoftware.navigationsample.two.addTwoDestination
import com.francescsoftware.navigationsample.ui.theme.NavigationSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = DestinationOneRoute,
                    ) {
                        addOneDestination(navController)
                        addTwoDestination(navController)
                    }
                }
            }
        }
    }
}
