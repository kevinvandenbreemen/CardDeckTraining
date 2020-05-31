package com.vandenbreemen.trainingcardsapp.interactor

import com.vandenbreemen.trainingcardsapp.entity.Card
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * @author kevin
 */
@RunWith(RobolectricTestRunner::class)
class DefaultCardsInteractorTest {

    lateinit var interactor: CardsInteractor

    @Before
    fun setup() {
        interactor = DefaultCardsInteractor()
    }

    @Test
    fun `Generates a Random Card`() {

        //  Arrange
        var receivedCard: Card? = null
        interactor.output = object: CardsOutputInteractor {
            override fun sendCard(card: Card) {
                receivedCard = card
            }
        }

        //  Act
        interactor.requestCard()

        //  Assert
        assertNotNull(receivedCard)

    }

}