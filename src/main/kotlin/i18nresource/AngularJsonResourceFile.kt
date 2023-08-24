package i18nresource

import core.FileFormat
import core.document.base.Document

class AngularJsonResourceFile(
    override var doNotTranslateRegex: List<Regex>,
    override var internalDocument: Document<FileFormat.JSON>,
    override var locale: String,
    override var fileName: String,
    override val type: I18nResourcesType= I18nResourcesType.AngularJson
) : I18nResourceFile<FileFormat.JSON>()