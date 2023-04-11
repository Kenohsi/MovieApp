package com.example.lectureexamples.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.models.ViewModel
import com.example.lectureexamples.screens.AddMovieScreen
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.FavoriteScreen
import com.example.lectureexamples.screens.HomeScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: ViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route){
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        composable(Screen.FavoriteScreen.route) {
            FavoriteScreen(navController = navController, viewModel = viewModel)
        }

        composable(Screen.AddMovieScreen.route) {
            AddMovieScreen(navController = navController, viewModel = viewModel)
        }

        // build a route like: root/detail-screen/id=34
        composable(
            Screen.DetailScreen.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {type = NavType.StringType})
        ) { backStackEntry ->    // backstack contains all information from navhost
            DetailScreen(navController = navController, viewModel = viewModel, movieId = backStackEntry.arguments?.getString(
                DETAIL_ARGUMENT_KEY)
            )
        }
    }
}