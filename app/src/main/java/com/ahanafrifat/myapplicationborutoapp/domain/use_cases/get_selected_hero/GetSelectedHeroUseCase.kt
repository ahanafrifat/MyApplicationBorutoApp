package com.ahanafrifat.myapplicationborutoapp.domain.use_cases.get_selected_hero

import com.ahanafrifat.myapplicationborutoapp.data.repository.Repository
import com.ahanafrifat.myapplicationborutoapp.domain.model.Hero

class GetSelectedHeroUseCase(private val repository: Repository) {
    suspend operator fun invoke(heroId:Int):Hero{
        return repository.getSelectedHero(heroId = heroId)
    }
}