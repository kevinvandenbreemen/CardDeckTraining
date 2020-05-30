package com.vandenbreemen.trainingcardsapp.interactor

import android.graphics.Color
import com.vandenbreemen.trainingcardsapp.entity.Card
import javax.inject.Inject

/**
 *
 * @author kevin
 */
class NonRandomCardsInteractor @Inject constructor(): CardsInteractor {

    private var counter: Int = 0
    override var output: CardsOutputInteractor? = null



    override fun requestCard() {
        var num = ++counter
        var red = num+10
        red %= 256

        Card(Color.valueOf(red.toFloat(), 0.0f, 0.0f)).apply {
            output?.let { it.sendCard(this) }
        }
    }
}