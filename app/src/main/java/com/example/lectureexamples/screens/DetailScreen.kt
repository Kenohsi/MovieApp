@file:Suppress("UNUSED_PARAMETER")

package com.example.lectureexamples.screens



import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.ViewModel
import com.example.lectureexamples.widgets.HorizontalScrollableImageView
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar

@Composable
fun DetailScreen(navController: NavController, movieId:String?, viewModel: ViewModel) {

    movieId?.let {
        val movie = viewModel.allMovies.filter { it.id == movieId }[0]


        val scaffoldState = rememberScaffoldState()

        Scaffold(scaffoldState = scaffoldState,
            topBar = {
                SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
                    Text(text = movie.title)
                }
            },
        ) { padding ->
            MainContent(Modifier.padding(padding), movie, viewModel = viewModel)
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier, movie: Movie, viewModel: ViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            MovieRow(movie = movie) { movieId -> viewModel.toggleFavorite(movieId) }

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = "Movie Images", style = MaterialTheme.typography.h5)

            HorizontalScrollableImageView(movie = movie)
        }
    }
}
