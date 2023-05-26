package com.example.crashreport

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crashreport.ui.theme.CrashReportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrashReportTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val exceptionHandler = SimpleExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
        throw RuntimeException("Whoops!")
    }
}

class SimpleExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, exc: Throwable) {
        // TODO generate a diagnostic report
        Log.e("Supriya", "Caught Exceptions!!!!")
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
    CrashReportTheme {
        Greeting("Android")
    }
}