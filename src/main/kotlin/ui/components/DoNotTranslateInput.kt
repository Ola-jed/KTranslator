package ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun DoNotTranslateInput(
    modifier: Modifier = Modifier,
    values: List<String>,
    onValuesChange: List<String>
) {
    var inputText by mutableStateOf("")

    Column {
        Row {
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                singleLine = true,
                label = { Text("Key to not translate") }
            )
        }

        LazyColumn {
            items(values) { value ->

            }
        }
    }
}