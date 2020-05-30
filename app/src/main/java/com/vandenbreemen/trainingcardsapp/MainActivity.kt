package com.vandenbreemen.trainingcardsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        (applicationContext as CardsApp).component.inject(this)
        print(viewModelFactory)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Set up the card stack
        val cardStack = CardStackFragment()
        supportFragmentManager.beginTransaction().
                add(R.id.cardStackContainer, cardStack)
                .commit()

        //  Set up Adding Cards
        val viewModel: CardStackViewModel by viewModels { viewModelFactory }
        addCard.setOnClickListener { _->
            viewModel.addCard()
        }
    }
}