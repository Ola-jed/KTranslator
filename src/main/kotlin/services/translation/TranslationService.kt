package services.translation

interface TranslationService {
    fun translate(value: String, sourceLocale: String, destinationLocale: String): String
    fun translateMany(values: List<String>, sourceLocale: String, destinationLocale: String): List<String>
}