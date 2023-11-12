package services.translator

import core.FileFormat
import core.locale.Locale
import i18nresource.I18nResourceFile

interface ResourceTranslator<T : FileFormat> {
    fun translateResourceFile(
        resourceFile: I18nResourceFile<T>,
        destinationLocale: Locale
    ): I18nResourceFile<T>
}