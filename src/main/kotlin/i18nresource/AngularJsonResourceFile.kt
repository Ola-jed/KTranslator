package i18nresource

import core.FileFormat
import core.document.base.Document
import core.locale.Locale

class AngularJsonResourceFile(
    override var doNotTranslateRegex: List<Regex>,
    override var internalDocument: Document<FileFormat.JSON>,
    override var locale: Locale,
    override var fileName: String,
    override val type: I18nResourcesType= I18nResourcesType.AngularJson
) : I18nResourceFile<FileFormat.JSON>()