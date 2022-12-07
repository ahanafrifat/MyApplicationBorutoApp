package com.ahanafrifat.myapplicationborutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.ahanafrifat.myapplicationborutoapp.data.repository.Repository
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}