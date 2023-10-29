package viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import core.locale.Locale
import core.parser.JsonParser
import i18nresource.I18nResourceFile
import i18nresource.I18nResourcesType

class ResourceInputViewModel(val resourceType: I18nResourcesType) {
    var currentStep by mutableStateOf(INPUT_STEP)
    var inputText by mutableStateOf("")
    var fileName by mutableStateOf("")
    var locale by mutableStateOf(Locale.ENGLISH)
    var doNotTranslate by mutableStateOf(listOf<String>())

    fun process() {
        val parser = JsonParser()
        val jsonDocument = parser.parseString(inputText)
        println(jsonDocument)
    }

    fun buildResourceFile(): I18nResourceFile<*> {
        TODO()
    }

    companion object {
        const val INPUT_STEP = 0
        const val SETTING_STEP = 1
    }
}