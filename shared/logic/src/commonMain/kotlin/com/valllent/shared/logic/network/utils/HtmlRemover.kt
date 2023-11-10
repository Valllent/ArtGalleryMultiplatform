package com.valllent.shared.logic.network.utils

object HtmlRemover {

    private val separator = System.getProperty("line.separator")
    private val REGEXP_LINE_BREAK = Regex("</p>")
    private val REGEXP_REMOVE_HTML = Regex("</?(p|b|em)>")

    fun removeHtml(value: String): String {
        var result = value.replace(
            REGEXP_LINE_BREAK,
            separator
        )
        result = result.removeSuffix(separator).removeSuffix(separator)
        return result.replace(REGEXP_REMOVE_HTML, "")
    }

}
