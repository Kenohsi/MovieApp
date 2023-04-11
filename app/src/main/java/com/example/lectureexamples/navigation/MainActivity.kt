package com.example.lectureexamples.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.lectureexamples.models.ViewModel
import com.example.lectureexamples.ui.theme.LectureExamplesTheme

class MainActivity : ComponentActivity() {
    // Done with Adam Ibragimov,Muhammad Imran, Kenan Husic
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ViewModel by viewModels()
        viewModel.movies
        setContent {
            LectureExamplesTheme {
                Navigation()
            }
        }
    }
}


