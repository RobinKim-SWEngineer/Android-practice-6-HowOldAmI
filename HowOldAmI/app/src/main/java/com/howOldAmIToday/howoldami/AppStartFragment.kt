package com.howOldAmIToday.howoldami

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.howOldAmIToday.howoldami.databinding.FragmentAppStartBinding

class AppStartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentAppStartBinding>(inflater, R.layout.fragment_app_start, container, false)

        binding.buttonAppStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_appStartFragment_to_birthInfoInputFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}