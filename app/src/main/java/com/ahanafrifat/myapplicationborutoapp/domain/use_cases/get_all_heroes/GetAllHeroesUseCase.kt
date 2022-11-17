package com.ahanafrifat.myapplicationborutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.ahanafrifat.myapplicationborutoapp.data.repository.Repository
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase (
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}