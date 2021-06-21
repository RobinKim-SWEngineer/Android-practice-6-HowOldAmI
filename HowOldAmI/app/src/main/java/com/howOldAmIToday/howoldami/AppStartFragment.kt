package com.howOldAmIToday.howoldami

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.howOldAmIToday.howoldami.databinding.FragmentAppStartBinding

class AppStartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentAppStartBinding>(inflater, R.layout.fragment_app_start, container, false)

        binding.buttonAppStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_appStartFragment_to_birthInfoInputFragment)
        }

        return binding.root
    }
}