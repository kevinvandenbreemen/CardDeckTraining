package com.vandenbreemen.trainingcardsapp.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author kevin
 */
@Module
class CoroutineContextModule {

    @Provides
    fun getContext(): CoroutineContext {
        return Dispatchers.Default
    }

}