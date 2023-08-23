package core

sealed class FileFormat {
    object JSON: FileFormat();
    object XML: FileFormat()
}