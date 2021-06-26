package com.howOldAmIToday.howoldami

import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class SharedViewModel: ViewModel() {
    private var birthYear by Delegates.notNull<Int>()
    private var birthMonth by Delegates.notNull<Int>()
    private var birthDay by Delegates.notNull<Int>()

    private lateinit var yearSuffix: String
    private lateinit var monthSuffix: String
    private lateinit var daySuffix: String

    fun setBirthInfo(year: Int, month: Int, day: Int) {
        birthYear = year
        birthMonth = month
        birthDay = day

        setSentence()
    }

    private fun setSentence() {

        yearSuffix = when(birthYear) {
            1 -> "year"
            else -> "years"
        }

        monthSuffix = when(birthMonth) {
            1 -> "month"
            else -> "months"
        }

        daySuffix = when(birthDay) {
            1 -> "day"
            else -> "days"
        }
    }

    fun getBirthInfoFormatted(): String {
        return when {

            isZero(birthYear) && isZero(birthMonth) && isZero(birthDay)-> "Today, you are born."

            isZero(birthYear) && isZero(birthMonth) -> "Today, you are $birthDay $daySuffix old"

            isZero(birthMonth) && isZero(birthDay) -> "Today, you are $birthYear $yearSuffix old"

            isZero(birthYear) && isZero(birthDay) -> "Today, you are $birthMonth $monthSuffix old"

            isZero(birthYear) -> "Today, you are $birthMonth $monthSuffix $birthDay $daySuffix old"

            isZero(birthMonth) -> "Today, you are $birthYear $yearSuffix $birthDay $daySuffix old"

            isZero(birthDay) -> "Today, you are $birthYear $yearSuffix $birthMonth $monthSuffix old"

            else -> "Today, you are $birthYear $yearSuffix $birthMonth $monthSuffix $birthDay $daySuffix old"
        }
    }

    private fun isZero(number: Int): Boolean {
        return number == 0
    }
}