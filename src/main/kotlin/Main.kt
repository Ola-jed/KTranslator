import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.fragments.ResourcesFragment

@Composable
@Preview
fun App() {
    MaterialTheme {
        ResourcesFragment()
    }
}

fun main() = application {
    Window(title = "KTranslator", onCloseRequest = ::exitApplication) {
        App()
    }
}
