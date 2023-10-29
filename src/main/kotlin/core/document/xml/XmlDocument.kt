package core.document.xml

import core.FileFormat
import core.document.base.Document

data class XmlDocument(var placeholder: Unit = Unit): Document<FileFormat.XML>()