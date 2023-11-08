package task1

fun main() {
    val userSecondsOnlineAgo = 12*60*60
    println(agoToText(userSecondsOnlineAgo))
}

fun agoToText(seconds: Int): String =
    when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..60*60 -> "был(а) в сети ${seconds/60} ${endingOfMinutes(seconds/60)} назад"
        in 60*60+1..24*60*60 -> "был(а) в сети ${seconds/60/60} ${endingOfHours(seconds/60/60)} назад"
        in 24*60*60+1..2*24*60*60 -> "был(а) вчера"
        in 2*24*60*60+1..3*24*60*60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }

fun endingOfMinutes(minutes: Int) : String =
    if (!"""[1]{1}[1-4]${'$'}""".toRegex().containsMatchIn(minutes.toString())) {
        val lastChar = minutes.toString()[minutes.toString().lastIndex]
        when (lastChar) {
            '1' -> "минуту"
            '2', '3', '4' -> "минуты"
            else -> "минут"
        }
    }
    else
        "минут"

fun endingOfHours(hours: Int) : String =
    if ((!"""[1]{1}[1-4]${'$'}""".toRegex().containsMatchIn(hours.toString())) ) {
        val lastChar = hours.toString()[hours.toString().lastIndex]
        when (lastChar) {
            '1' -> "час"
            '2', '3', '4' -> "часа"
            else -> "часов"
        }
    }
    else
        "часов"