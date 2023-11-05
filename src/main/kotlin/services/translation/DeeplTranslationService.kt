package services.translation

import com.deepl.api.Translator

class DeeplTranslationService(private val translator: Translator = Translator("")): TranslationService {
    override fun translate(value: String, sourceLocale: String, destinationLocale: String): String {
        return translator.translateText(value, sourceLocale, destinationLocale).text
    }

    override fun translateMany(values: List<String>, sourceLocale: String, destinationLocale: String): List<String> {
        return translator.translateText(values, sourceLocale, destinationLocale).map { it.text }
    }
}