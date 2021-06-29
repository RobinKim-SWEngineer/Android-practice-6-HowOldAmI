package com.howOldAmIToday.howoldami

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import java.util.*
import kotlin.math.abs
import kotlin.properties.Delegates

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener  {

    var currentYear by Delegates.notNull<Int>()
    var currentMonth by Delegates.notNull<Int>()
    var currentDay by Delegates.notNull<Int>()

    var birthYear by Delegates.notNull<Int>()
    var birthMonth by Delegates.notNull<Int>()
    var birthDay by Delegates.notNull<Int>()

    private lateinit var button: Button
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance()

        currentYear = calender.get(Calendar.YEAR)
        currentMonth = calender.get(Calendar.MONTH)
        currentDay = calender.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, currentYear, currentMonth, currentDay)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        birthYear = year
        birthMonth = month
        birthDay = dayOfMonth

        var button = parentFragment?.view?.findViewById<Button>(R.id.button_ageCalculate)
        var text = parentFragment?.view?.findViewById<TextView>(R.id.textView_enterBirth)

        if (button != null && text != null) {
            button.visibility = View.VISIBLE
            text.text = String.format("%d / %d / %d",year, month + 1, dayOfMonth)

            val sharedViewModel: SharedViewModel by activityViewModels()
            setSharedAgeInfo(sharedViewModel)
        }
    }

    private fun setSharedAgeInfo(viewModel: SharedViewModel) {
        val year = currentYear - birthYear
        val month = currentMonth - birthMonth
        val day = currentDay - birthDay

        viewModel.setBirthInfo(year, abs(month), abs(day))
    }
}