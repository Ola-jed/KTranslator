package core.document.json

sealed class JsonValue {
    // We don't support json arrays since they don't make sense in a translation context
    data class JsonString(var value: String): JsonValue()

    data class JsonObject(var keyValuePairs: Set<JsonKeyValuePair>): JsonValue()
}