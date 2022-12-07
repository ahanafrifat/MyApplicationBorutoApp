package com.ahanafrifat.myapplicationborutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ahanafrifat.myapplicationborutoapp.data.local.BorutoDatabase
import com.ahanafrifat.myapplicationborutoapp.data.paging_source.HeroRemoteMediator
import com.ahanafrifat.myapplicationborutoapp.data.paging_source.SearchHeroesSource
import com.ahanafrifat.myapplicationborutoapp.data.remote.BorutoApi
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import com.ahanafrifat.myapplicationborutoapp.domain.repository.RemoteDataSource
import com.ahanafrifat.myapplicationborutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi = borutoApi, query = query)
            }
        ).flow
    }
}