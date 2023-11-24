package services.translation

import com.deepl.api.Translator
import core.document.json.JsonDocument
import core.document.json.JsonValue

class DeeplTranslationService(private val translator: Translator = Translator("")) : TranslationService {
    override fun translate(value: String, sourceLocale: String, destinationLocale: String): String {
        return translator.translateText(value, sourceLocale, destinationLocale).text
    }

    override fun translateMany(values: List<String>, sourceLocale: String, destinationLocale: String): List<String> {
        return translator.translateText(values, sourceLocale, destinationLocale).map { it.text }
    }

    override fun translateJsonDocument(
        jsonDocument: JsonDocument,
        sourceLocale: String,
        destinationLocale: String,
        doNotTranslate: List<Regex>
    ): JsonDocument {
        val values = mutableListOf<String>()

        for (keyValuePair in jsonDocument.keyValuePairs) {
            if (keyValuePair.value is JsonValue.JsonString) {
                val stringValue = (keyValuePair.value as JsonValue.JsonString).value

                if (!doNotTranslate.any { it.matches(stringValue) }) {
                    values.add(stringValue)
                }
            } else {

                values.addAll(
                    (keyValuePair.value as JsonValue.JsonObject)
                        .linearize()
                        .filter { str -> !doNotTranslate.any { it.matches(str) } }
                )
            }
        }

        val valuesAndTranslations = (values zip translateMany(values, sourceLocale, destinationLocale)).toMap()

        for (keyValuePair in jsonDocument.keyValuePairs) {
            if(keyValuePair.value is JsonValue.JsonString) {
                val valueStr = (keyValuePair.value as JsonValue.JsonString).value
                (keyValuePair.value as JsonValue.JsonString).value = valuesAndTranslations[valueStr]!!
            } else {
                applyJsonObjectsTranslations((keyValuePair.value) as JsonValue.JsonObject, valuesAndTranslations)
            }
        }

        return jsonDocument
    }

    private fun applyJsonObjectsTranslations(
        jsonObject: JsonValue.JsonObject,
        valuesAndTranslations: Map<String, String>
    ) {
        jsonObject.keyValuePairs.forEach {
            if (it.value is JsonValue.JsonString) {
                (it.value as JsonValue.JsonString).value =
                    valuesAndTranslations[(it.value as JsonValue.JsonString).value]!!
            } else {
                applyJsonObjectsTranslations(it.value as JsonValue.JsonObject, valuesAndTranslations)
            }
        }
    }
}