package com.vandenbreemen.trainingcardsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 *
 * @author kevin
 */
class CardStackViewModelFactory @Inject constructor(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardStackViewModel::class.java)) {
            return CardStackViewModel() as T
        }
        throw IllegalArgumentException("I do not support $modelClass")
    }
}