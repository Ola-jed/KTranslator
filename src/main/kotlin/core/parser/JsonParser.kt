package core.parser

import core.FileFormat
import core.document.base.Document
import java.io.File

class JsonParser: Parser<FileFormat.JSON> {
    override fun parseString(input: String): Document<FileFormat.JSON> {
        TODO("Not yet implemented")
    }

    override fun parseFile(file: File): Document<FileFormat.JSON> {
        TODO("Not yet implemented")
    }
}