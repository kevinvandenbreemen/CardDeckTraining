package com.vandenbreemen.trainingcardsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CardStackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardStackFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ret = inflater.inflate(R.layout.fragment_card_stack, container, false)

        val viewModel: CardStackViewModel by activityViewModels()
        viewModel.currentCard.observe(viewLifecycleOwner, Observer {card ->
            ret.setBackgroundColor(card.color.toArgb())
        })

        ret.setOnClickListener { _->
            viewModel.tap()
        }

        return ret
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment CardStackFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CardStackFragment().apply {

            }
    }
}