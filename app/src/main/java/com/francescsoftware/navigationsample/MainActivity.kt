package com.francescsoftware.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.francescsoftware.navigationsample.ui.theme.NavigationSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = "one",
                    ) {
                        composable("one") {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                val textState = remember { mutableStateOf(TextFieldValue()) }
                                Column {
                                    OutlinedTextField(
                                        value = textState.value,
                                        onValueChange = { textState.value = it },
                                        modifier = Modifier
                                            .fillMaxWidth(.6f)
                                            .padding(vertical = 8.dp),
                                    )
                                    Button(
                                        onClick = {
                                            navController.navigate("two/${textState.value.text}")
                                        },
                                        modifier = Modifier.padding(vertical = 8.dp),
                                    ) {
                                        Text(
                                            text = "Navigate to 2nd screen"
                                        )
                                    }
                                }
                            }
                        }
                        composable("two/{two_arg}") {
                            val viewModel = hiltViewModel<TwoViewModel>()
                            TwoScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TwoScreen(
    viewModel: TwoViewModel,
) {
    val state by viewModel.state

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(text = "You entered:", modifier = Modifier.padding(vertical = 8.dp))
            Text(text = state.value, modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationSampleTheme {
        Greeting("Android")
    }
}