package com.niran.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.niran.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.niran.cryptocurrency.presentation.screens.CoinDetailScreen
import com.niran.cryptocurrency.presentation.screens.CoinListScreen
import com.niran.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route,
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{$PARAM_COIN_ID}",
                            arguments = listOf(navArgument(PARAM_COIN_ID) {
                                type = NavType.StringType
                            })
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}