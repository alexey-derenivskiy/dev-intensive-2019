package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date{
    var time = this.time
    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String{
    var diff = this.time.minus(Date().time)
    return when(diff){
        in 360* DAY..Long.MAX_VALUE  ->  "более чем через год"
        in 26* HOUR..360* DAY -> "через ${formatResult(
            diff,
            TimeUnits.DAY
        )}"
        in 22* HOUR..26* HOUR -> "завтра"
        in 75* MINUTE..22* HOUR -> "через ${formatResult(
            diff,
            TimeUnits.HOUR
        )}"
        in 45* MINUTE..75* MINUTE -> "через час"
        in 75* SECOND..45* MINUTE -> "через ${formatResult(
            diff,
            TimeUnits.MINUTE
        )}"
        in 45* SECOND..75* SECOND -> "через минуту"
        in SECOND..45* SECOND -> "через несколько секунд"
        in 0..SECOND -> "несколько секунд назад"

        in -SECOND..0               -> "только что"
        in -45* SECOND..-1* SECOND -> "несколько секунд назад"
        in -75* SECOND..-45* SECOND -> "минуту назад"
        in -45* MINUTE..-75* SECOND -> "${formatResult(
            diff,
            TimeUnits.MINUTE
        )} назад"
        in -75* MINUTE..-45* MINUTE -> "час назад"
        in -22* HOUR..-75* MINUTE -> "${formatResult(
            diff,
            TimeUnits.HOUR
        )} назад"
        in -26* HOUR..-22* HOUR -> "день назад"
        in -360* DAY..-26* HOUR -> "${formatResult(
            diff,
            TimeUnits.DAY
        )} назад"
        in Long.MIN_VALUE..-360* DAY -> "более года назад"
        else -> "!!!!!!!!время задано неверно!!!!!!"
    }
}

fun formatResult(value:Long, mark: TimeUnits): String{
    var number: Int = when(mark) {
        TimeUnits.DAY -> "${(value / DAY)}".toInt()
        TimeUnits.HOUR -> "${(value / HOUR)}".toInt()
        TimeUnits.MINUTE -> "${(value / MINUTE)}".toInt()
        TimeUnits.SECOND -> "${(value / SECOND)}".toInt()
    }
    var remainder: Int = number % 20
    number = abs(number)
    remainder = abs(remainder)
    var resultWord = when(remainder){
        0, in 5..20 -> "${if(mark== TimeUnits.DAY) "дней"
                else if(mark== TimeUnits.HOUR) "часов"
                else if(mark== TimeUnits.MINUTE) "минут"
                else if(mark== TimeUnits.SECOND) "секунд"
                else "incorrect time"}"
        1 -> "${if(mark== TimeUnits.DAY) "день"
                else if(mark== TimeUnits.HOUR) "час"
                else if(mark== TimeUnits.MINUTE) "минуту"
                else if(mark== TimeUnits.SECOND) "секунду"
                else "incorrect time"}"
        in 2..4 -> "${if(mark== TimeUnits.DAY) "дня"
                else if(mark== TimeUnits.HOUR) "часа"
                else if(mark== TimeUnits.MINUTE) "минуты"
                else if(mark== TimeUnits.SECOND) "секунды"
                else "incorrect time"}"
        else -> "так не бывает"
    }
    return "$number $resultWord"
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}