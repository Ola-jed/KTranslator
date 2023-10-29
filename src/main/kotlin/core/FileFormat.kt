package core

sealed class FileFormat {
    data object JSON: FileFormat()
    data object XML: FileFormat()
}