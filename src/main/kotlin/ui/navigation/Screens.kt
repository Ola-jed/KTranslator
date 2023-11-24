package ui.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import i18nresource.I18nResourceFile
import i18nresource.I18nResourcesType

sealed class Screen: Parcelable {
    @Parcelize
    data object ResourcePicker : Screen() {
        private fun readResolve(): Any = ResourcePicker
    }

    @Parcelize
    data class ResourceInput(val resourceType: I18nResourcesType) : Screen()

    @Parcelize
    data class ResourceOutput(val resourceFile: I18nResourceFile<*>): Screen()
}