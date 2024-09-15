package com.example.foodattip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNav() {
    val foodAdded = remember {
        mutableStateListOf<FoodModel>()
    }

    val qrans = remember { mutableStateOf("") }

    val clicked = remember { mutableIntStateOf(0) }

    val navController = rememberNavController()
    val currentRoute = remember {
        mutableStateOf(navController.currentDestination)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    onClick = {if (qrans.value.isNotEmpty()) navController.navigate("table")
                              else navController.navigate("main")},
                    icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "")
                    },
                    label = {},
                    selected = currentRoute.value?.route == "main",
                    modifier = Modifier,
                    enabled = true
                )
                NavigationBarItem(
                    onClick = {
                        navController.navigate("profile")
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                    },
                    label = {},
                    selected = currentRoute.value?.route == "profile",
                    modifier = Modifier,
                    enabled = true
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {


            NavHost(navController = navController, startDestination = "main") {


                composable(route = "main") {
                    QRCodeScanner(onQRCodeScanned = {ans->
                        qrans.value = ans
                        navController.navigate("table")
                    })
                }

                composable(route = "table") {
                    FoodScreen(qrans) { id ->
                        clicked.intValue = id
                        navController.navigate("foodMenu")

                    }
                }

                composable(route = "profile") {
                    Profile(list = foodAdded)
                }

                composable(route = "foodMenu") {
                    FoodMenu(id = clicked.intValue) { fooditem ->
                        foodAdded.add(fooditem)
                        navController.navigate("table")
                    }
                }

            }

        }
    }
}