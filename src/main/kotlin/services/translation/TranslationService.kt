package services.translation

import core.document.json.JsonDocument

interface TranslationService {
    fun translate(value: String, sourceLocale: String, destinationLocale: String): String
    fun translateJsonDocument(jsonDocument: JsonDocument, sourceLocale: String, destinationLocale: String, doNotTranslate: List<Regex>): JsonDocument
    fun translateMany(values: List<String>, sourceLocale: String, destinationLocale: String): List<String>
}