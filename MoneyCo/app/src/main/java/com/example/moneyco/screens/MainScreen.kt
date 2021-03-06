package com.example.moneyco.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.moneyco.model.SearchViewModel
import com.example.moneyco.navigation.BottomBarScreen
import com.example.moneyco.navigation.nav_graph.BottomNavGraph
import kotlinx.coroutines.DelicateCoroutinesApi

@ExperimentalComposeUiApi
@DelicateCoroutinesApi
@ExperimentalCoilApi
@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(
    viewModel: SearchViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController, viewModel = viewModel)
    }
}

@ExperimentalAnimationApi
@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Transaction,
        BottomBarScreen.Profil,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    if (currentDestination?.route in arrayListOf(
            BottomBarScreen.Home.route,
            BottomBarScreen.Transaction.route,
            BottomBarScreen.Profil.route,
        )
    ) {
        Row(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp
//                25.dp
                    )
                )
                .background(MaterialTheme.colors.primaryVariant)
                .padding(7.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            screens.forEach { screen ->
                CustomBottomNavigationItem(
                    screen = screen,
                    isSelected = screen.route == currentDestination?.route,
                    navController = navController as NavHostController
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    isSelected: Boolean
) {

    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.5f) else Color.Transparent
    val contentColor =
        if (isSelected) Color(0xffEEEEEE) else Color(0xff311B92)
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = screen.icon,
                contentDescription = null,
                tint = contentColor
            )
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = screen.title,
                    color = Color.White
                )
            }
        }
    }
}