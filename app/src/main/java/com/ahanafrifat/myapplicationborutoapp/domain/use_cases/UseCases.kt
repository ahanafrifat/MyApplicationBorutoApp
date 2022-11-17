package com.ahanafrifat.myapplicationborutoapp.domain.use_cases

import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
