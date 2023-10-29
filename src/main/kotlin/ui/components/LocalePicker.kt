package ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.locale.Locale

@Composable
fun LocalePicker(
    modifier: Modifier = Modifier,
    currentLocale: Locale,
    onLocaleChosen: (Locale) -> Unit
) {
    var expanded by mutableStateOf(false)

    LazyColumn {
        items(Locale.entries) { item ->
            Text(item.code)
        }
    }
}
