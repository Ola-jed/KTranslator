package core.document.json

import core.FileFormat
import core.document.base.Document

data class JsonDocument(var keyValuePairs: Set<JsonKeyValuePair>): Document<FileFormat.JSON>()