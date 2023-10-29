package core.writer

import core.FileFormat
import core.document.base.Document

interface Writer<T: FileFormat> {
    fun writeString(document: Document<T>): String
}