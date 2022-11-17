package com.ahanafrifat.myapplicationborutoapp.domain.use_cases.save_onboarding

import com.ahanafrifat.myapplicationborutoapp.data.repository.Repository

class SaveOnBoardingUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}
