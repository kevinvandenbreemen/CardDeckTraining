package com.vandenbreemen.trainingcardsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vandenbreemen.trainingcardsapp.entity.Card
import com.vandenbreemen.trainingcardsapp.interactor.CardsInteractor
import com.vandenbreemen.trainingcardsapp.interactor.CardsOutputInteractor
import com.vandenbreemen.trainingcardsapp.interactor.DefaultCardsInteractor

/**
 *
 * @author kevin
 */
class CardStackViewModel: ViewModel(), CardsOutputInteractor {

    private val cards: MutableList<Card> = mutableListOf()
    private val interactor: CardsInteractor = DefaultCardsInteractor()

    init {
        interactor.output = this
    }

    val currentCard: MutableLiveData<Card> = MutableLiveData()

    /**
     * Tap the deck, causing the current card to go to the back of the stack
     */
    fun tap() {
        if(cards.size > 1){
            val currentTop = cards.removeAt(0)
            cards.add(currentTop)
            currentCard.value = cards[0]
        }
    }

    override fun sendCard(card: Card) {
        cards.add(0, card)
        currentCard.value = card
    }

    fun addCard() {
        interactor.requestCard()
    }
}