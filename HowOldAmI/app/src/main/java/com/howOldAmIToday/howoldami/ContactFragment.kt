package com.howOldAmIToday.howoldami

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.howOldAmIToday.howoldami.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    data class Hint(val name: String, val mail: String, val content: String)
    var hintObj = Hint("Your name", "Your e-mail", "Any comment on your mind")
    lateinit var binding: FragmentContactBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)
        setContactHints()

        binding.materialButtonSend.setOnClickListener {
            showMessage("Thank you for your time!")
            clearContents()
            clearEditTextFocus()
        }

        return binding.root
    }

    private fun showMessage(message: String) {
        val toast = Toast.makeText(activity,  message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }

    private fun setContactHints() {
        binding.hint = hintObj
    }

    private fun clearContents() {
        binding.apply {
            this.editTextContacContent.setText("")
            this.editTextContactEmail.setText("")
            this.editTextContactName.setText("")
        }
    }

    private fun clearEditTextFocus() {
        this.view?.findFocus()?.clearFocus()
    }
}