package com.vandenbreemen.trainingcardsapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModel
import kotlinx.android.synthetic.main.layout_card_count.view.*
import javax.inject.Inject

/**
 *
 * @author kevin
 */
class CardCountFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.layout_card_count, container, false)
        val viewModel: CardStackViewModel by activityViewModels { viewModelFactory }

        viewModel.cardCount.observe(viewLifecycleOwner, Observer { count->
            view.cardCount.text = count.toString()
        })

        return view

    }

    override fun onAttach(context: Context) {

        (context.applicationContext as CardsApp).component.inject(this)

        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}