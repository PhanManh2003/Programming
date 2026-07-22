package com.example.profilescreen.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.CompareArrows
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Home", Icons.Outlined.Home)
    object Map : BottomNavItem("map", "Map", Icons.Outlined.Map)
    object Transfer : BottomNavItem("transfer", "Transfer", Icons.Outlined.CompareArrows)
    object Settings : BottomNavItem("settings", "Settings", Icons.Outlined.Settings)
    object Profile : BottomNavItem("profile", "Profile", Icons.Outlined.Person)
}