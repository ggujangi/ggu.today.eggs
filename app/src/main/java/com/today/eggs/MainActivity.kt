package com.today.eggs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.today.eggs.ui.TodayEggsApp
import com.today.eggs.ui.theme.TodayEggsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodayEggsTheme {
                TodayEggsApp()/*
                val adaptiveInfo = currentWindowAdaptiveInfoV2()

                val sizeClass = adaptiveInfo.windowSizeClass
                Log.d("hjTest", "onCreate: $sizeClass")
                val size = when {
                    sizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND) ->
                        // return UI for EXPANDED width size class
                        "EXPANDED"

                    sizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) ->
                        // return UI for MEDIUM width size class
                        "MEDIUM"

                    else -> "COMPACT"
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = size,
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodayEggsTheme {
        Greeting("Android")
    }
}