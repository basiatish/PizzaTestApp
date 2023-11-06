package com.basiatish.hammersystemstestapp.ui.menu.di

import com.basiatish.data.api.NetworkModule
import com.basiatish.data.mappers.MenuMapper
import com.basiatish.data.repositories.MenuRemoteSourceImpl
import com.basiatish.data.repositories.MenuRepositoryImpl
import com.basiatish.hammersystemstestapp.BuildConfig
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class MenuRepositoryModule {

    private val menuMapper by lazy {
        MenuMapper()
    }

    private val networkModule by lazy {
        NetworkModule()
    }

    @Volatile
    var menuRepository: MenuRepositoryImpl? = null

    @Provides
    fun provideMenuRepository(): MenuRepositoryImpl {
        return menuRepository ?: createMenuRepository()
    }

    fun createMenuRepository(): MenuRepositoryImpl {
        val repository = MenuRepositoryImpl(
            MenuRemoteSourceImpl(networkModule.createApi(BuildConfig.BASE_API), menuMapper, Dispatchers.IO)
        )
        menuRepository = repository
        return repository
    }

}