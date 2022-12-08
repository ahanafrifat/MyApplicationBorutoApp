package com.ahanafrifat.myapplicationborutoapp.data.repository

import com.ahanafrifat.myapplicationborutoapp.data.local.BorutoDatabase
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero
import com.ahanafrifat.myapplicationborutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase):LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}