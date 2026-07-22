package com.example.profilescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.profilescreen.ui.theme.*
import com.example.profilescreen.ui.navigation.BottomNavItem
import com.example.profilescreen.ui.screen.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProfileAppTheme {
                MainScreen()
            }
        }

    }
}

@Composable
fun MainScreen() {
    var selectedRoute by remember { mutableStateOf(BottomNavItem.Profile.route) }

    val navItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Map,
        BottomNavItem.Transfer,
        BottomNavItem.Settings,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = White) {
                navItems.forEach { item ->
                    val isSelected = selectedRoute == item.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { selectedRoute = item.route },
                        icon = {
                            if (item is BottomNavItem.Profile && isSelected) {
                                ProfileNavIcon()
                            } else {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label
                                )
                            }
                        },
                        label = { Text(text = item.label, fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ActiveNavColor,
                            selectedTextColor = ActiveNavColor,
                            unselectedIconColor = InactiveNavColor,
                            unselectedTextColor = InactiveNavColor,
                            indicatorColor = White
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedRoute) {
                BottomNavItem.Home.route -> PlaceholderScreen("Home")
                BottomNavItem.Map.route -> PlaceholderScreen("Map")
                BottomNavItem.Transfer.route -> PlaceholderScreen("Transfer")
                BottomNavItem.Settings.route -> PlaceholderScreen("Settings")
                BottomNavItem.Profile.route -> ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileNavIcon() {
    AsyncImage(
        model = "https://cdn.britannica.com/87/139487-050-98D3449D/Kaka-2009.jpg",
        contentDescription = "Profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(28.dp)
            .clip(CircleShape)
            .border(2.dp, ActiveNavColor, CircleShape)
    )
}

@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name, fontSize = 24.sp, color = TextSecondary)
    }
}