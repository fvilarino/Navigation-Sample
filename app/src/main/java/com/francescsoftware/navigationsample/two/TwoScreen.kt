package com.francescsoftware.navigationsample.two

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.francescsoftware.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun TwoScreen(
    state: TwoState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = "Screen Two",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.align(Alignment.TopCenter),
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "You entered:",
                modifier = Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.h5,
            )
            Text(
                text = state.value,
                modifier = Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.h4,
            )
        }
        Button(
            onClick = onBackClick,
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            Text(
                text = "Go back"
            )
        }
    }
}

@Preview(widthDp = 360)
@Composable
private fun PreviewTwoScreen() {
    NavigationSampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            TwoScreen(
                state = TwoState(value = "Two Value"),
                onBackClick = { },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
