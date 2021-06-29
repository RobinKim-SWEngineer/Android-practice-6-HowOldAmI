package com.howOldAmIToday.howoldami

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.howOldAmIToday.howoldami.databinding.FragmentBirthInfoInputBinding
import kotlin.math.abs

class BirthInfoInputFragment : Fragment() {

    private lateinit var binding: FragmentBirthInfoInputBinding
    private lateinit var datePickerFragment: DatePickerFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_birth_info_input, container, false)

        binding.imageButtonCalender.setOnClickListener {
            datePickerFragment = DatePickerFragment()
            fragmentManager?.let { datePickerFragment.show(it, "DatePicker") }
        }

        binding.buttonAgeCalculate.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_birthInfoInputFragment_to_ageDisplayFragment)
        }

        if (savedInstanceState != null) {
            when {
                (savedInstanceState.size() > 3) -> {
                    binding.textViewEnterBirth.text = savedInstanceState.getString("key_birthDate")
                    binding.buttonAgeCalculate.visibility = View.VISIBLE
                }
            }
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(binding.buttonAgeCalculate.visibility == View.VISIBLE) {
            outState.putString("key_birthDate", binding.textViewEnterBirth.text.toString())
        }
    }
}