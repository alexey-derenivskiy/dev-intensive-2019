package ru.skillbranch.devintensive.extensions

import java.util.regex.Pattern

fun String.truncate(number: Int = 16): String {
    /*  "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
      "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
      "A     ".truncate(3) //A*/
    var str: String
    val max_len = this.trim().length

    if (max_len > number)
        str = this.trim().substring(0, number)
    else
        return this.trim()

    val lastSymbol = str.get(str.length - 1)
    when {
        lastSymbol.isLetterOrDigit() -> str += "..."
        else -> str = str.trim() + "..."
    }
    return str
}

fun String.stripHtml(): String? {
    var regex = """<.+?>|(&amp;)|(&lt;)|(&gt;)|(&#39;)|(&quot;)""".toRegex()
    var temp: String
    temp = regex.replace(this, "")
    regex = """( )+""".toRegex()
    temp = regex.replace(temp, " ")
    return temp
}
