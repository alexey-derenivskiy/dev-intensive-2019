package ru.skillbranch.devintensive.utils

/*Реализуй метод utils.toInitials(firstName lastName) принимающий в качестве аргументов
имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами
имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал,
если оба аргумента null вернуть null)
Пример:
utils.toInitials("john" ,"doe") //JD
utils.toInitials("John", null) //J
utils.toInitials(null, null) //null
utils.toInitials(" ", "") //null
*/

object Utils {
    fun parseFullName(fullname:String?):Pair<String?, String?> {
        if (fullname.isNullOrBlank()) return null to null
        var list : List<String>? = fullname?.trim()?.split(" ", ignoreCase = true, limit = 2)
        var fn: String? = list?.getOrNull(0)?.trim()
        var ln: String? = list?.getOrNull(1)?.trim()
        return fn to ln
    }

    fun toInitials(firstName:String?, lastName:String?) : String? {
        val fn:String? = when{
            firstName.isNullOrBlank() -> null
            else -> "${firstName?.substring(0,1)}"
        }

        val ln:String? = when{
            lastName.isNullOrBlank() -> null
            else -> "${lastName?.substring(0,1)}"
        }

        return when{
            fn==null && ln==null    -> null
            fn == null              -> ln?.toUpperCase()
            ln == null              -> fn?.toUpperCase()
            else                    -> fn?.toUpperCase()+ln?.toUpperCase()
        }
    }

    fun transliteration(payload: String, divider:String=" "): String {
        var result: String = ""
        for (s in payload){
            when(s) {
                'а' ->  result += "a"
                'А' ->  result += "A"
                'Б' ->  result += "B"
                'б' ->  result += "b"
                'В' ->  result += "V"
                'в' ->  result += "v"
                'г' ->  result += "g"
                'Г' ->  result += "G"
                'д' ->  result += "d"
                'Д' ->  result += "D"
                'е' ->  result += "e"
                'Е' ->  result += "E"
                'ё' ->  result += "yo"
                'Ё' ->  result += "Yo"
                'ж' ->  result += "zh"
                'Ж' ->  result += "Zh"
                'з' ->  result += "z"
                'З' ->  result += "Z"
                'и', 'й' ->  result += "i"
                'И', 'Й' ->  result += "I"
                'к' ->  result += "k"
                'К' ->  result += "K"
                'л' ->  result += "l"
                'Л' ->  result += "L"
                'м' ->  result += "m"
                'М' ->  result += "M"
                'н' ->  result += "n"
                'Н' ->  result += "N"
                'о' ->  result += "o"
                'О' ->  result += "O"
                'п' ->  result += "p"
                'П' ->  result += "P"
                'р' ->  result += "r"
                'Р' ->  result += "R"
                'с' ->  result += "s"
                'С' ->  result += "S"
                'т' ->  result += "t"
                'Т' ->  result += "T"
                'у' ->  result += "u"
                'У' ->  result += "U"
                'ф' ->  result += "f"
                'Ф' ->  result += "F"
                'х' ->  result += "h"
                'Х' ->  result += "H"
                'ц' ->  result += "ts"
                'Ц' ->  result += "Ts"
                'ч' ->  result += "ch"
                'Ч' ->  result += "Ch"
                'ш' ->  result += "sh"
                'Ш' ->  result += "Sh"
                'щ' ->  result += "sh'"
                'Щ' ->  result += "Sh'"
                'ь', 'Ь', 'ъ', 'Ъ' ->  result += ""
                'ы' ->  result += "i"
                'Ы' ->  result += "I"
                'э' ->  result += "e"
                'Э' ->  result += "E"
                'ю' ->  result += "yu"
                'Ю' ->  result += "Yu"
                'я' ->  result += "ya"
                'Я' ->  result += "Ya"
                ' ' ->  result += divider
                else -> result += s
            }
        }
        return result
    }
}