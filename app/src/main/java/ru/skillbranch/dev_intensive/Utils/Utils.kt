package ru.skillbranch.dev_intensive.Utils

/*Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов
имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами
имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал,
если оба аргумента null вернуть null)
Пример:
Utils.toInitials("john" ,"doe") //JD
Utils.toInitials("John", null) //J
Utils.toInitials(null, null) //null
Utils.toInitials(" ", "") //null
*/

object Utils {
    fun parseFullName(fullname:String?):Pair<String?, String?> {
        if (fullname.isNullOrBlank())
            return "null" to "null"
        val firstName : String? = fullname?.split(" ")?.getOrNull(0)?:"null"
        val lastName : String? = fullname?.split(" ")?.getOrNull(1)?:"null"
        return firstName to lastName
    }

    fun toInitials(firstName:String?, lastName:String?) : String {
        val fn:String = "${if(firstName.isNullOrBlank()) "null" else "${firstName.substring(0,1)}"}"
        val ln:String = "${if(lastName.isNullOrBlank()) "null" else "${lastName.substring(0,1)}"}"
        return when{
            fn=="null" && ln=="null" -> "null"
            fn == "null"             -> ln.toUpperCase()
            ln == "null"             -> fn.toUpperCase()
            else                     -> fn.toUpperCase()+ln.toUpperCase()
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
                'ь', 'Ь' ->  result += ""
                'ъ', 'Ъ' ->  result += ""
                'ы', 'Ы' ->  result += "i"
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