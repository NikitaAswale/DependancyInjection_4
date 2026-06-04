package com.example.dependancyinjection_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dependancyinjection_4.ui.theme.DependancyInjection_4Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DependancyInjection_4Theme {
                NavComponent()
            }
        }
    }
}

@Composable
fun NavComponent() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Screen1") {
        composable("Screen1") {
            PokeDex(navController = navController)
        }


        composable("Screen2/{name}") {backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            ProfileUI(navController = navController, name = name)
        }

    }
}