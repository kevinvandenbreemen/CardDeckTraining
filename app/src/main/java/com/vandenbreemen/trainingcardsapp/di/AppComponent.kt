package com.vandenbreemen.trainingcardsapp.di

import com.vandenbreemen.CardStackSummaryFragment
import com.vandenbreemen.trainingcardsapp.CardCountFragment
import com.vandenbreemen.trainingcardsapp.CardStackFragment
import com.vandenbreemen.trainingcardsapp.MainActivity
import dagger.Component

/**
 *
 * @author kevin
 */
@Component(modules = [DefaultCardStackViewModelFactoryProvider::class])
interface AppComponent {

    fun inject(main: MainActivity)

    //  Fragments
    fun inject(cardsCountFragment: CardCountFragment)
    fun inject(cardStackFragment: CardStackFragment)
    fun inject(cardStackSummaryFragment: CardStackSummaryFragment)

}