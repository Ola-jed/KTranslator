package core.parser

import core.FileFormat
import core.document.base.Document
import java.io.File

class XmlParser: Parser<FileFormat.XML> {
    override fun parseString(input: String): Document<FileFormat.XML> {
        TODO("Not yet implemented")
    }

    override fun parseFile(file: File): Document<FileFormat.XML> {
        TODO("Not yet implemented")
    }
}