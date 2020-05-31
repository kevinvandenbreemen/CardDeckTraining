package com.vandenbreemen.trainingcardsapp.interactor

import com.vandenbreemen.trainingcardsapp.entity.Card
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * @author kevin
 */
@RunWith(RobolectricTestRunner::class)
class NonRandomCardsInteractorTest {

    lateinit var interactor: CardsInteractor

    @Before
    fun setUp() {
        interactor = NonRandomCardsInteractor()
    }

    @Test
    fun `Generates a new Card That is Not Random`() {

        //  Arrange
        var generatedCard: Card? = null
        var card1: Card? = null
        var card2: Card? = null

        interactor.output = object: CardsOutputInteractor {

            override fun sendCard(card: Card) {
                generatedCard = card
            }
        }

        //  Act
        interactor.requestCard()
        card1 = generatedCard
        interactor.requestCard()
        card2 = generatedCard

        //  Assert
        assertNotNull(card1)
        assertNotNull(card2)

        assertTrue(card2!!.color.red() == card1!!.color.red()+1.0f)
    }
}