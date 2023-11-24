package core.document.json

import core.FileFormat
import core.document.base.Document

data class JsonDocument(var keyValuePairs: List<JsonKeyValuePair>): Document<FileFormat.JSON>() {
    companion object {
        fun linearize() {
            val list = mutableListOf<String>()
        }
    }
}