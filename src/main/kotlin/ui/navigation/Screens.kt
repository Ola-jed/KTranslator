package ui.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import i18nresource.I18nResourcesType

sealed class Screen: Parcelable {
    @Parcelize
    object ResourcePicker : Screen()

    @Parcelize
    data class ResourceInput(val resourceType: I18nResourcesType) : Screen()
}