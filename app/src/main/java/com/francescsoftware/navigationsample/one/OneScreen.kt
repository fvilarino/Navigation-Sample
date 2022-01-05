package com.francescsoftware.navigationsample.one

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.francescsoftware.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun OneScreen(
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = "Screen One",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.align(Alignment.TopCenter),
        )
        val textState = remember { mutableStateOf(TextFieldValue()) }
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = {
                    Text(
                        text = "Enter any value"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(.6f)
                    .padding(vertical = 8.dp),
            )
            Button(
                onClick = {
                    onNavigate(textState.value.text)
                },
                modifier = Modifier.padding(vertical = 8.dp),
                enabled = textState.value.text.isNotEmpty(),
            ) {
                Text(
                    text = "Navigate to 2nd screen"
                )
            }
        }
    }
}

@Preview(widthDp = 360)
@Composable
private fun PreviewOneScreen() {
    NavigationSampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            OneScreen(
                onNavigate = {},
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
