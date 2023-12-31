package i18nresource

import core.FileFormat
import core.document.base.Document
import core.document.base.EmptyDocument
import core.locale.Locale

sealed class I18nResourceFile<T : FileFormat> {
    abstract var doNotTranslateRegex: List<Regex>
    abstract var internalDocument: Document<T>
    abstract var locale: Locale
    abstract var fileName: String
    abstract val type: I18nResourcesType

    data object Empty: I18nResourceFile<Nothing>() {
        override var doNotTranslateRegex: List<Regex>
            get() = listOf()
            set(value) {}
        override var internalDocument: Document<Nothing>
            get() = EmptyDocument
            set(value) {}
        override var locale: Locale
            get() = Locale.ENGLISH
            set(value) {}
        override var fileName: String
            get() = ""
            set(value) {}
        override val type: I18nResourcesType
            get() = I18nResourcesType.AngularJson
    }
}