package core.parser

import core.FileFormat
import core.document.base.Document
import core.document.json.JsonDocument
import core.document.json.JsonKeyValuePair
import core.document.json.JsonValue
import kotlinx.serialization.json.*
import java.io.BufferedReader
import java.io.File

class JsonParser : Parser<FileFormat.JSON> {
    override fun parseString(input: String): Document<FileFormat.JSON> {
        val rootJsonObject: JsonObject = Json.decodeFromString(input)
        return JsonDocument(rootJsonObject.entries.map {
            JsonKeyValuePair(key = it.key, value = readObject(it.value))
        }.toSet())
    }

    override fun parseFile(file: File): Document<FileFormat.JSON> {
        val bufferedReader: BufferedReader = file.bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        return parseString(inputString)
    }

    private fun readObject(jsonElement: JsonElement): JsonValue {
        return when (jsonElement) {
            is JsonArray -> throw IllegalArgumentException("Arrays are not supported")
            is JsonPrimitive -> JsonValue.JsonString(jsonElement.content)
            is JsonObject -> JsonValue.JsonObject(keyValuePairs = jsonElement.entries.map {
                JsonKeyValuePair(it.key, readObject(it.value))
            }.toSet())
        }
    }
}