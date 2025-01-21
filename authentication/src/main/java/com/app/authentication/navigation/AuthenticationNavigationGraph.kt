package com.app.authentication.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.app.authentication.presentation.ui.SignInScreen

@Composable
fun AuthenticationNavigationGraph(navHostController: NavHostController, modifier: Modifier){

    NavHost(
        navController = navHostController,
        startDestination = com.app.common.route.AuthenticationNavRoute.LoginScreen.route,
        modifier = modifier.fillMaxSize()
    ){
        composable(route = com.app.common.route.AuthenticationNavRoute.LoginScreen.route,
            enterTransition = { com.app.common.animation.fadeInTransition() },
            exitTransition = { com.app.common.animation.fadeOutTransition() },
            popEnterTransition = { com.app.common.animation.fadeInTransition() }){

            SignInScreen()

        }
    }
}