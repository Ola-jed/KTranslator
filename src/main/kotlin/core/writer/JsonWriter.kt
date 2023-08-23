package core.writer

import core.FileFormat
import core.document.base.Document

class JsonWriter: Writer<FileFormat.JSON> {
    override fun writeString(document: Document<FileFormat.JSON>): String {
        TODO("Not yet implemented")
    }
}