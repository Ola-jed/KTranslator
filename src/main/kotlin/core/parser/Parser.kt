package core.parser

import core.FileFormat
import core.document.base.Document
import java.io.File

interface Parser<T: FileFormat> {
    fun parseString(input: String) : Document<T>
    fun parseFile(file: File) : Document<T>
}