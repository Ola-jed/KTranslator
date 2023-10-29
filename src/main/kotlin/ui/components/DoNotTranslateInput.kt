package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DoNotTranslateInput(
    modifier: Modifier = Modifier,
    values: List<String>,
    onValuesChange: (List<String>) -> Unit
) {
    var inputText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = inputText,
                onValueChange = { inputText = it },
                singleLine = true,
                label = { Text("Key to not translate") },
                trailingIcon = {
                    IconButton(onClick = {
                        if (inputText.isNotBlank()) {
                            onValuesChange(values + inputText)
                            inputText = ""
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }
            )
        }

        if (values.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 0.dp, max = 300.dp)
                    .padding(top = 5.dp)
                    .background(Color(0xFF008080), shape = RoundedCornerShape(5.dp))
            ) {
                val state = rememberLazyListState()

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    state
                ) {
                    items(values) { value ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(modifier = Modifier.padding(start = 5.dp), text = value)

                            IconButton(onClick = {
                                onValuesChange(values.filter { it != value })
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.Red
                                )
                            }
                        }
                    }
                }

                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    adapter = rememberScrollbarAdapter(scrollState = state)
                )
            }
        }
    }
}