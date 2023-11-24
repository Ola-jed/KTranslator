package core.document.json

sealed class JsonValue {
    // We don't support json arrays since they don't make sense in a translation context
    data class JsonString(var value: String): JsonValue()

    data class JsonObject(var keyValuePairs: List<JsonKeyValuePair>): JsonValue() {
        fun linearize(): List<String> {
            val list = mutableListOf<String>()

            for (keyValuePair in keyValuePairs) {
                if(keyValuePair.value is JsonString) {
                    list.add((keyValuePair.value as JsonString).value)
                } else {
                    list.addAll((keyValuePair.value as JsonObject).linearize())
                }
            }

            return list
        }
    }
}