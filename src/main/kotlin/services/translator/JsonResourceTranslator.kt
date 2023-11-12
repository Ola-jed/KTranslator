package services.translator

import core.FileFormat
import core.locale.Locale
import i18nresource.AngularJsonResourceFile
import i18nresource.I18nResourceFile
import services.translation.TranslationService

class AngularResourceTranslator(val translationService: TranslationService) : ResourceTranslator<FileFormat.JSON> {
    override fun translateResourceFile(
        resourceFile: I18nResourceFile<FileFormat.JSON>,
        destinationLocale: Locale
    ): AngularJsonResourceFile {
        TODO()
    }
}