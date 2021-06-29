package com.howOldAmIToday.howoldami

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.howOldAmIToday.howoldami.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentContactBinding>(inflater, R.layout.fragment_contact, container, false)
        return binding.root
    }
}