package com.vandenbreemen.trainingcardsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vandenbreemen.trainingcardsapp.entity.Card
import com.vandenbreemen.trainingcardsapp.interactor.CardsInteractor
import com.vandenbreemen.trainingcardsapp.interactor.CardsOutputInteractor
import java.util.*
import javax.inject.Inject

/**
 *
 * @author kevin
 */
class CardStackViewModel @Inject constructor(private val interactor: CardsInteractor): ViewModel(), CardsOutputInteractor {

    private val cards: MutableList<Card> = mutableListOf()

    init {
        interactor.output = this
    }

    val currentCard: MutableLiveData<Card> = MutableLiveData()
    val cardCount: MutableLiveData<Int> = MutableLiveData()

    /**
     * The raw list of cards for displaying summaries of the cards etc
     */
    val cardsList: MutableLiveData<List<Card>> = MutableLiveData()

    /**
     * Tap the deck, causing the current card to go to the back of the stack
     */
    fun tap() {
        if(cards.size > 1){
            val currentTop = cards.removeAt(0)
            cards.add(currentTop)

            cardsList.value = Collections.unmodifiableList(cards)
            currentCard.value = cards[0]
        }
    }

    override fun sendCard(card: Card) {
        cards.add(0, card)
        currentCard.value = card
        cardCount.value = cards.size
        cardsList.value = Collections.unmodifiableList(cards)
    }

    fun addCard() {
        interactor.requestCard()
    }
}