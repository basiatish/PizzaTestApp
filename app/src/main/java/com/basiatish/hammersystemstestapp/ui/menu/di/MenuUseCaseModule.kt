package com.basiatish.hammersystemstestapp.ui.menu.di

import com.basiatish.data.repositories.MenuRepositoryImpl
import com.basiatish.domain.usecases.GetMenuUseCase
import dagger.Module
import dagger.Provides

@Module
class MenuUseCaseModule {

    @Provides
    fun provideGetMenuUseCase(menuRepository: MenuRepositoryImpl): GetMenuUseCase {
        return GetMenuUseCase(menuRepository)
    }

}