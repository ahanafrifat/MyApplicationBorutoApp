package com.ahanafrifat.myapplicationborutoapp.domain.repository

import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId:Int):Hero
}