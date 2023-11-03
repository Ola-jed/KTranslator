package ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.locale.Locale

@Composable
fun LocalePicker(
    modifier: Modifier = Modifier,
    currentLocale: Locale,
    onLocaleChosen: (Locale) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        TextField(
            value = currentLocale.code,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Select a locale") },
            modifier = modifier.clickable { expanded = !expanded },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    },
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
        )

        DropdownMenu(
            modifier = Modifier.height(250.dp).align(Alignment.CenterEnd),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Locale.entries.forEach { locale ->
                DropdownMenuItem(
                    onClick = {
                        onLocaleChosen(locale)
                        expanded = false
                    }
                ) {
                    Text(locale.code)
                }
            }
        }
    }
}
