package com.francescsoftware.navigationsample.two

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val DestinationOneArg = "arg"
private const val DestinationTwoRoot = "two"
private const val DestinationTwoRoute = "$DestinationTwoRoot/{$DestinationOneArg}"

fun buildTwoRoute(argument: String) = "$DestinationTwoRoot/$argument"

fun NavGraphBuilder.addTwoDestination(
    navController: NavController,
) {
    composable(
        route = DestinationTwoRoute,
    ) {
        val viewModel = hiltViewModel<TwoViewModel>()
        val state by viewModel.state
        TwoScreen(
            state = state,
            onBackClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
