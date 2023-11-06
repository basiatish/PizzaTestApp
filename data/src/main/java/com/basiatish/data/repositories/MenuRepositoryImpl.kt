package com.basiatish.data.repositories

import com.basiatish.domain.common.Result
import com.basiatish.domain.entities.MenuItem
import com.basiatish.domain.repositories.MenuRepository

class MenuRepositoryImpl(private val menuRemoteSource: MenuRemoteSource) : MenuRepository {

    override suspend fun getMenu(): Result<List<MenuItem>> {
        return menuRemoteSource.getMenu()
    }

}