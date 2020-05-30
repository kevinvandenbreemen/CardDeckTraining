package com.vandenbreemen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vandenbreemen.trainingcardsapp.CardsApp
import com.vandenbreemen.trainingcardsapp.R
import com.vandenbreemen.trainingcardsapp.entity.Card
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModel
import kotlinx.android.synthetic.main.layout_card_stack_display.view.*
import kotlinx.android.synthetic.main.layout_card_stack_item.view.*
import javax.inject.Inject

class CardItemViewHolder(val group: ViewGroup): RecyclerView.ViewHolder(group)

class CardStackSummaryAdapter(private val dataSet: List<Card>): RecyclerView.Adapter<CardItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_card_stack_item, parent, false)
                as ViewGroup
        return CardItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        val view = holder.group
        dataSet[position].apply {
            view.cardColoring.setBackgroundColor(color.toArgb())
        }

    }
}

/**
 *
 * @author kevin
 */
class CardStackSummaryFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: CardStackSummaryAdapter
    private lateinit var cardsList: MutableList<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cardsList = mutableListOf()
        adapter = CardStackSummaryAdapter(cardsList)
    }

    override fun onAttach(context: Context) {

        (context.applicationContext as CardsApp).component.inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutManager = LinearLayoutManager(context)

        val view = inflater.inflate(R.layout.layout_card_stack_display, container, false)
        view.cardStackRecyclerView.apply {
            layoutManager = this@CardStackSummaryFragment.layoutManager
            adapter = this@CardStackSummaryFragment.adapter
        }

        val viewModel: CardStackViewModel by activityViewModels { viewModelFactory }
        viewModel.apply {
            cardsList.observe(viewLifecycleOwner, Observer { cards->
                this@CardStackSummaryFragment.cardsList.clear()
                this@CardStackSummaryFragment.cardsList.addAll(cards)
                adapter.notifyDataSetChanged()
            })
        }

        return view

    }

}