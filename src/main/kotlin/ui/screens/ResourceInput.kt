package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import i18nresource.I18nResourcesType
import viewmodels.ResourceInputViewModel

@Composable
fun ResourceInput(resourceType: I18nResourcesType, onBack: () -> Unit) {
    val vm = remember { ResourceInputViewModel() }

    Column(modifier = Modifier.fillMaxSize().padding(top = 5.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text("Paste the content of the resource file", modifier = Modifier.padding(start = 15.dp))
        }

        TextField(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.90f).padding(top = 5.dp),
            value = vm.text,
            onValueChange = { vm.text = it }
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {}) {
                Text("Continue")
            }
        }
    }
}