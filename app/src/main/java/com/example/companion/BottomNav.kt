package com.example.companion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController) {
    BottomAppBar(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.13f),
        cutoutShape = RoundedCornerShape(12.dp),
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        BottomNavigationItem(
            selected = currentDestination?.route == Destinations.Home.route,
            onClick = {
                navController.navigate(Destinations.Home.route) {
                    popUpTo(Destinations.Home.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home_white),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                        .background(
                            if (currentDestination?.route == Destinations.Home.route) Color(
                                0xFFFFA622
                            ) else Color.Transparent
                        )
                        .padding(8.dp),
                    tint = if (currentDestination?.route == Destinations.Home.route) Color.White else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = currentDestination?.route == Destinations.Map.route,
            onClick = {
                navController.navigate(Destinations.Map.route) {
                    popUpTo(Destinations.Map.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_map_black),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                        .background(
                            if (currentDestination?.route == Destinations.Map.route) Color(
                                0xFFFFA622
                            ) else Color.Transparent
                        )
                        .padding(8.dp),
                    tint = (if (currentDestination?.route == Destinations.Map.route) Color.White else Color.Black)
                )
            }
        )
        BottomNavigationItem(
            selected = currentDestination?.route == Destinations.Hotels.route,
            onClick = {
                navController.navigate(Destinations.Hotels.route) {
                    popUpTo(Destinations.Hotels.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bed),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                        .background(
                            if (currentDestination?.route == Destinations.Hotels.route) Color(
                                0xFFFFA622
                            ) else Color.Transparent
                        )
                        .padding(8.dp),
                    tint = (if (currentDestination?.route == Destinations.Hotels.route) Color.White else Color.Black)
                )
            }
        )
        BottomNavigationItem(
            selected = currentDestination?.route == Destinations.Guides.route,
            onClick = {
                navController.navigate(Destinations.Guides.route) {
                    popUpTo(Destinations.Guides.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_guides),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .fillMaxHeight(.6f)
                        .background(
                            if (currentDestination?.route == Destinations.Guides.route) Color(
                                0xFFFFA622
                            ) else Color.Transparent
                        )
                        .padding(6.dp),
                    tint = if (currentDestination?.route == Destinations.Guides.route) Color.White else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = currentDestination?.route == Destinations.Flights.route,
            onClick = {
                navController.navigate(Destinations.Flights.route) {
                    popUpTo(Destinations.Flights.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plain_black),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                        .background(
                            if (currentDestination?.route == Destinations.Flights.route) Color(
                                0xFFFFA622
                            ) else Color.Transparent
                        )
                        .padding(8.dp),
                    tint = (if (currentDestination?.route == Destinations.Flights.route) Color.White else Color.Black)
                )
            }
        )
    }
}
