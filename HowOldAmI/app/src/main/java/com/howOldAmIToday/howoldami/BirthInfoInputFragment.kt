package com.howOldAmIToday.howoldami

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.navigation.findNavController

import com.howOldAmIToday.howoldami.databinding.FragmentBirthInfoInputBinding
import java.util.*
import kotlin.math.abs

class BirthInfoInputFragment : Fragment() {

    private lateinit var binding: FragmentBirthInfoInputBinding
    private lateinit var datePickerFragment: DatePickerFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentBirthInfoInputBinding>(inflater, R.layout.fragment_birth_info_input, container, false)

        binding.imageButtonCalender.setOnClickListener { view: View ->
            datePickerFragment = DatePickerFragment()
            fragmentManager?.let { datePickerFragment.show(it, "DatePicker") }
        }

        binding.buttonAppStart.setOnClickListener {
            setSharedAgeInfo()
            view?.findNavController()?.navigate(R.id.action_birthInfoInputFragment_to_ageDisplayFragment)
        }

        return binding.root
    }

    private fun setSharedAgeInfo() {
        var year = datePickerFragment.currentYear - datePickerFragment.birthYear
        var month = datePickerFragment.currentMonth - datePickerFragment.birthMonth
        var day = datePickerFragment.currentDay - datePickerFragment.birthDay

        val sharedViewModel: SharedViewModel by activityViewModels()
        sharedViewModel.setBirthInfo(year, abs(month), abs(day))
    }
}