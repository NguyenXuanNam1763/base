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
    }

}