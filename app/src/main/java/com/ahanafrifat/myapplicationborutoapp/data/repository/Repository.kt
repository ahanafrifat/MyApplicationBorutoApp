package com.ahanafrifat.myapplicationborutoapp.data.repository

import androidx.paging.PagingData
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import com.ahanafrifat.myapplicationborutoapp.domain.repository.DataStoreOperations
import com.ahanafrifat.myapplicationborutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}