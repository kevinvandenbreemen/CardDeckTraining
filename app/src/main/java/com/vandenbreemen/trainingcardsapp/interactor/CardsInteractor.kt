package com.vandenbreemen.trainingcardsapp.interactor

import android.graphics.Color
import com.vandenbreemen.trainingcardsapp.entity.Card
import java.util.*

/**
 *
 * @author kevin
 */
interface CardsInteractor {

    var output: CardsOutputInteractor?

    fun requestCard()

}

/**
 * Some kind of output once the CardsInteractor has successfully gotten a new card
 */
interface CardsOutputInteractor {

    fun sendCard(card: Card)

}

class DefaultCardsInteractor: CardsInteractor {

    override var output: CardsOutputInteractor? = null

    override fun requestCard() {
        output?.run {
            val random = Random(System.nanoTime())
            val red = random.nextInt(255)
            val green = random.nextInt(255)
            val blue = random.nextInt(255)

            val cardColor = Color.valueOf(red.toFloat(), green.toFloat(), blue.toFloat())
            sendCard(Card(cardColor))
        }

    }
}