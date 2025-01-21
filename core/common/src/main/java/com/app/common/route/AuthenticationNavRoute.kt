package com.app.common.route

sealed class AuthenticationNavRoute(private var routeId: String, var route: String) {
    data object LoginScreen: AuthenticationNavRoute(routeId = "login_screen", route = "login_screen")
}