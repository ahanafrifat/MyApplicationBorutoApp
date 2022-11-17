package com.ahanafrifat.myapplicationborutoapp.domain.repository

import androidx.paging.PagingData
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}