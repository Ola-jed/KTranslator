package ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import ui.components.LocalePicker
import viewmodels.ResourceInputViewModel

@Composable
fun ResourceInput(resourceType: I18nResourcesType, onBack: () -> Unit) {
    val vm = remember { ResourceInputViewModel(resourceType) }

    AnimatedVisibility(vm.currentStep == ResourceInputViewModel.INPUT_STEP) {
        Column(modifier = Modifier.fillMaxSize().padding(top = 5.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }

                Text("Paste the content of the resource file", modifier = Modifier.padding(start = 15.dp))
            }

            TextField(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.90f).padding(top = 5.dp),
                value = vm.inputText,
                onValueChange = { vm.inputText = it }
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = { vm.currentStep = ResourceInputViewModel.SETTING_STEP }) {
                    Text("Continue")
                }
            }
        }
    }

    AnimatedVisibility(vm.currentStep == ResourceInputViewModel.SETTING_STEP) {
        Column(modifier = Modifier.fillMaxSize().padding(top = 5.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }

                Text("Give us some details about the file you just copied", modifier = Modifier.padding(start = 15.dp))
            }

            Column(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                    value = vm.fileName,
                    label = { Text("File name") },
                    onValueChange = { vm.fileName = it },
                    maxLines = 1
                )

                LocalePicker(
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    currentLocale = vm.locale,
                    onLocaleChosen = { vm.locale = it }
                )

                // Do not translate


                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        modifier = Modifier.padding(end = 10.dp),
                        onClick = { vm.currentStep = ResourceInputViewModel.INPUT_STEP }
                    ) {
                        Text("Back")
                    }

                    Button(onClick = vm::process) {
                        Text("Continue")
                    }
                }
            }
        }
    }
}