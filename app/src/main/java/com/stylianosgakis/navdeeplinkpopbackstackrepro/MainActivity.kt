package com.stylianosgakis.navdeeplinkpopbackstackrepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.stylianosgakis.navdeeplinkpopbackstackrepro.ui.theme.NavdeeplinkpopbackstackreproTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      NavdeeplinkpopbackstackreproTheme {
        App()
      }
    }
  }
}

@Composable
fun App() {
  Surface(Modifier.fillMaxSize()) {
    val localUriHandler = LocalUriHandler.current
    val navController = rememberNavController()
    NavHost(
      navController = navController,
      "A"
    ) {
      composable("A") {
        Box(
          Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center,
        ) {
          IconButton(onClick = { localUriHandler.openUri("https://repro.link/graph") }) {
            Icon(Icons.AutoMirrored.Default.ArrowForward, "Start screen")
          }
        }
      }
      navigation(startDestination = "B", route = "graphRoute") {
        composable(
          "B",
          deepLinks = listOf(navDeepLink { uriPattern = "https://repro.link/graph" })
        ) {
          Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
          ) {
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,
            ) {
              IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.AutoMirrored.Default.ArrowBack, "navigate up")
              }
              Text("Above does navigateUp()")
              Text("Below does popBackstack()")
              Button(onClick = { navController.popBackStack() }) {
                Text("Pop backstack")
              }
            }
          }
        }
      }
    }
  }
}