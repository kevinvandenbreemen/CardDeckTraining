package com.vandenbreemen.trainingcardsapp.di

import androidx.lifecycle.ViewModelProvider
import com.vandenbreemen.trainingcardsapp.viewmodel.CardStackViewModelFactory
import dagger.Binds
import dagger.Module

/**
 *
 * @author kevin
 */
@Module
interface DefaultCardStackViewModelFactoryProvider {

    @Binds
    fun buildDefaultFactory(factory: CardStackViewModelFactory): ViewModelProvider.Factory

}