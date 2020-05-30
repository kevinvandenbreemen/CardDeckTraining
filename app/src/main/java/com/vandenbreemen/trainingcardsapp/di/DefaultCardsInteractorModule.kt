package com.vandenbreemen.trainingcardsapp.di

import com.vandenbreemen.trainingcardsapp.interactor.CardsInteractor
import com.vandenbreemen.trainingcardsapp.interactor.DefaultCardsInteractor
import dagger.Binds
import dagger.Module

/**
 *
 * @author kevin
 */
@Module
interface DefaultCardsInteractorModule {

    @Binds
    fun getRandomInteractor(interactor: DefaultCardsInteractor) : CardsInteractor

}