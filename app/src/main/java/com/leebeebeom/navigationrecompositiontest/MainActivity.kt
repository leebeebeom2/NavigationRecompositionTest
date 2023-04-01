package com.leebeebeom.navigationrecompositiontest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leebeebeom.navigationrecompositiontest.ui.theme.NavigationRecompositionTestTheme

private const val Screen1Route = "screen 1"
private const val Screen2Route = "screen 2"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationRecompositionTestTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen1Route) {
                    composable(Screen1Route) { Screen1 { navController.navigate(Screen2Route) } }
                    composable(Screen2Route) { Screen2 { navController.navigate(Screen1Route) } }
                }

            }
        }
    }
}

@Composable
fun Screen1(navigate: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Log.d("태그", "Screen1: 리컴포지션")
        Button(onClick = navigate) {

        }
    }
}

@Composable
fun Screen2(navigate: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Log.d("태그", "Screen2: 리컴포지션")
        Button(onClick = navigate) {

        }
    }
}
