package com.vandenbreemen.trainingcardsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Set up the card stack
        val cardStack = CardStackFragment()
        supportFragmentManager.beginTransaction().
                add(R.id.cardStackContainer, cardStack)
                .commit()

        //  Set up Adding Cards
        val viewModel: CardStackViewModel by viewModels()
        addCard.setOnClickListener { _->
            viewModel.addCard()
        }
    }
}