package i18nresource

import core.FileFormat
import core.document.base.Document

sealed class I18nResourceFile<T : FileFormat> {
    abstract var doNotTranslateRegex: List<Regex>
    abstract var internalDocument: Document<T>
    abstract var locale: String
    abstract var fileName: String
    abstract val type: I18nResourcesType
}