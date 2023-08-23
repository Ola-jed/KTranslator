package core.document.json

sealed class JsonValue {
    data class JsonString(var value: String): JsonValue()

    data class JsonObject(var keyValuePairs: Set<JsonKeyValuePair>): JsonValue()
}