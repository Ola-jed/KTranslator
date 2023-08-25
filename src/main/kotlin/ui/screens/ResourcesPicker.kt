package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import i18nresource.I18nResourcesType
import ui.components.ResourceTypePicker
import viewmodels.ResourcesViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ResourcesPicker(onNavigate: (I18nResourcesType) -> Unit) {
    val vm = remember { ResourcesViewModel() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = "Select the resource file type you want to translate",
            textAlign = TextAlign.Center
        )

        FlowRow(modifier = Modifier.padding(8.dp)) {
            vm.supportedResources.map {
                ResourceTypePicker(
                    image = it.imagePath,
                    label = it.label,
                    onClick = { onNavigate(it.type) }
                )
            }
        }
    }
}
