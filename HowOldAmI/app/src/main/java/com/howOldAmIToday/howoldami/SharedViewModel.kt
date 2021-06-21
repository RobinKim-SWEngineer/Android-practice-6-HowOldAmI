package com.howOldAmIToday.howoldami

import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class SharedViewModel: ViewModel() {
    var birthYear by Delegates.notNull<String>()
    var birthMonth by Delegates.notNull<String>()
    var birthDay by Delegates.notNull<String>()
    var year = "years"
    var month = "months"
    var day = "days"

    fun setBirthInfo(year: Int, month: Int, day: Int) {
        birthYear = year.toString()
        birthMonth = month.toString()
        birthDay = day.toString()

        setSentence()
    }

    private fun setSentence() {

        if (birthYear == "1") {
            year = "year"
        }

        if (birthYear == "0") {
            birthYear = ""
            year = ""
        }

        if (birthMonth == "1") {
            month = "month"
        }

        if (birthMonth == "0") {
            birthMonth = ""
            month = ""
        }

        if (birthDay == "1") {
            day = "days"
        }

        if (birthDay == "0") {
            birthDay = ""
            day = ""
        }
    }

    fun getBirthInfoFormatted(): String {
        return String.format("Today, you are %s %s %s %s %s %s old", birthYear, year, birthMonth, month, birthDay, day)
    }
}