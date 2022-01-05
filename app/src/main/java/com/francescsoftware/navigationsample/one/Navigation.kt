package com.francescsoftware.navigationsample.one

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.francescsoftware.navigationsample.two.buildTwoRoute

const val DestinationOneRoute = "one"

fun NavGraphBuilder.addOneDestination(
    navController: NavController,
) {
    composable(
        route = DestinationOneRoute,
    ) {
        OneScreen(
            onNavigate = { argument ->
                navController.navigate(buildTwoRoute(argument))
            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
