package viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import i18nresource.I18nResourcesType

class ResourcesViewModel {
    var supportedResources by mutableStateOf(
        listOf(
            SupportedResourceDescription(I18nResourcesType.AngularJson, "angular.png", "Angular json i18n assets files"),
            SupportedResourceDescription(I18nResourcesType.DotnetResX, "dotnet.png", "Dotnet resx file"),
            SupportedResourceDescription(I18nResourcesType.LaravelJson, "laravel.png", "Laravel i18n json file"),
        )
    )

}


data class SupportedResourceDescription(val type: I18nResourcesType, val imagePath: String, val label: String)
