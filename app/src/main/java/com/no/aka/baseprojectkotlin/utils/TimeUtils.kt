package com.no.aka.baseprojectkotlin.utils

class TimeUtils {
    companion object {
        fun formatsMilliSeconds(milliseconds: Long): String {
            var finalTimerString = ""
            var secondsString = ""

            // Convert total duration into time
            val hours = (milliseconds / (1000 * 60 * 60)).toInt()
            val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
            val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()

            // Add hours if there
            if (hours > 0) {
                finalTimerString = "$hours:"
            }

            // Prepending 0 to seconds if it is one digit
            secondsString = if (seconds < 10) {
                "0$seconds"
            } else {
                "" + seconds
            }
            finalTimerString = "$finalTimerString$minutes:$secondsString"

            //      return  String.format("%02d Min, %02d Sec",
            //                TimeUnit.MILLISECONDS.toMinutes(milliseconds),
            //                TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
            //                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));

            // return timer string
            return finalTimerString
        }

        fun formatMillisecondToDay(milliseconds: Long): String {
            val timeCurrent = System.currentTimeMillis()
            val timeCalculator = milliseconds - timeCurrent

            var hours = (timeCalculator / (1000 * 60 * 60)).toInt()
            val minutes = (timeCalculator % (1000 * 60 * 60)).toInt() / (1000 * 60)
            val seconds = (timeCalculator % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()


            if (hours < 24) {
                return formatsMilliSeconds(timeCalculator)
            }
            val dayTamp = (hours / 24)
            val day = if (dayTamp < 10) "0$dayTamp" else "$dayTamp" + " Day"
            hours -= (dayTamp * 24)

            val hourString = if (hours < 10) "0$hours" else "$hours"
            val minuteString = if (minutes < 10) "0$minutes" else "$minutes"
            val secondString = if (seconds < 10) "0$seconds" else "$seconds"

            return "$day - $hourString:$minuteString:$secondString"
        }
    }

}