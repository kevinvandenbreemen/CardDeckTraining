package com.vandenbreemen.trainingcardsapp.di

import com.vandenbreemen.trainingcardsapp.interactor.CardsInteractor
import com.vandenbreemen.trainingcardsapp.interactor.NonRandomCardsInteractor
import dagger.Binds
import dagger.Module

/**
 *
 * @author kevin
 */
@Module
interface NonRandomCardsInteractorModule {

    @Binds
    fun getInteractor(interactor: NonRandomCardsInteractor): CardsInteractor

}