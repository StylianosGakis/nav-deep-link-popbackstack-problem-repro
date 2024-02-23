package com.stylianosgakis.navdeeplinkpopbackstackrepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
  Box(Modifier.fillMaxSize()) {

  }
}