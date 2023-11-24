package services.translator

import core.FileFormat
import core.document.json.JsonDocument
import core.locale.Locale
import i18nresource.AngularJsonResourceFile
import i18nresource.I18nResourceFile
import services.translation.TranslationService

class AngularResourceTranslator(private val translationService: TranslationService) : ResourceTranslator<FileFormat.JSON> {
    override fun translateResourceFile(
        resourceFile: I18nResourceFile<FileFormat.JSON>,
        destinationLocale: Locale
    ): AngularJsonResourceFile {
        return AngularJsonResourceFile(
            doNotTranslateRegex = resourceFile.doNotTranslateRegex,
            internalDocument = translationService.translateJsonDocument(
                resourceFile.internalDocument as JsonDocument,
                resourceFile.locale.code,
                destinationLocale.code,
                resourceFile.doNotTranslateRegex
            ),
            locale = destinationLocale,
            fileName = "${destinationLocale.code}.json"
        )
    }
}