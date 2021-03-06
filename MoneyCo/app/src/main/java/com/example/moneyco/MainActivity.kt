package com.example.moneyco

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.moneyco.model.SearchViewModel
import com.example.moneyco.navigation.nav_graph.SetupNavGraph
import com.example.moneyco.ui.theme.MoneyCoTheme
import kotlinx.coroutines.DelicateCoroutinesApi


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@DelicateCoroutinesApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {
    private val viewModel: SearchViewModel by viewModels()
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MoneyCoTheme {
                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }

    }
}




