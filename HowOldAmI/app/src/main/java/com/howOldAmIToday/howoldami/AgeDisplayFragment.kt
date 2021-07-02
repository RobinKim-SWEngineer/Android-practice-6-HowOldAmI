package com.howOldAmIToday.howoldami

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.howOldAmIToday.howoldami.databinding.FragmentAgeDisplayBinding

class AgeDisplayFragment : Fragment() {

    data class Quotes(var quote: String)

    private val quotes: MutableList<Quotes> = mutableListOf(
        Quotes("Your time is limited, so don't waste it living someone else's life. Have the courage to follow your heart.  - Steve Jobs"),
        Quotes("Human potential, though not always apparent, is there waiting to be discovered and invited forth.  - William W. Purkey"),
        Quotes("There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.  - Albert Einstein"),
        Quotes("It is better to be hated for what you are than to be loved for what you are not.  - Andre Gide"),
        Quotes("Live as if you were to die tomorrow. Learn as if you were to live forever.  - Mahatma Gandhi"),
        Quotes("Yesterday is history, tomorrow is a mystery, today is a gift. That is why we call it the present.  - Bill Keane"),
        Quotes("It is never too late to be what you might have been.  - George Eliot")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAgeDisplayBinding>(inflater, R.layout.fragment_age_display, container, false)

        val sharedViewModel: SharedViewModel by activityViewModels()

        binding.textViewAge.text = sharedViewModel.getBirthInfoFormatted()
        binding.quotes = getQuotes()

        if (savedInstanceState != null) {
            binding.quotes!!.quote = savedInstanceState.getString("quote")!!
        }

        binding.floatingButtonEmail.setOnClickListener {
            ShareCompat.IntentBuilder.from(requireActivity())
                .setType("text/plain")
                .setChooserTitle("")
                .setSubject(binding.textViewAge.text.toString())
                .setText(binding.textViewQuote.text)
                .startChooser()
        }
        return binding.root
    }

    private fun getQuotes(): Quotes {
        quotes.shuffle()
        return quotes[0]
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("quote", quotes[0].quote)
    }
}