package com.ahanafrifat.myapplicationborutoapp.di

import android.content.Context
import com.ahanafrifat.myapplicationborutoapp.data.repository.DataStoreOperationsImpl
import com.ahanafrifat.myapplicationborutoapp.data.repository.Repository
import com.ahanafrifat.myapplicationborutoapp.domain.repository.DataStoreOperations
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.UseCases
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.ahanafrifat.myapplicationborutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository)
        )
    }

}