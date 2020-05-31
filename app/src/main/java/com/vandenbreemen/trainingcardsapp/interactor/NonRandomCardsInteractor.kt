package com.vandenbreemen.trainingcardsapp.interactor

import android.graphics.Color
import com.vandenbreemen.trainingcardsapp.entity.Card
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

/**
 *
 * @author kevin
 */
class NonRandomCardsInteractor @Inject constructor(private val coroutineContext: CoroutineContext): CardsInteractor {

    private var counter: Int = 0
    override var output: CardsOutputInteractor? = null

    override fun requestCard() {
        CoroutineScope(coroutineContext).launch {
            var num = ++counter
            var red = num+10
            red %= 256

            Card(Color.valueOf(red.toFloat(), 0.0f, 0.0f)).apply {
                output?.let { it.sendCard(this) }
            }
        }
    }
}