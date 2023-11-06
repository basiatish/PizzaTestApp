package com.basiatish.domain.repositories

import com.basiatish.domain.common.Result
import com.basiatish.domain.entities.MenuItem

interface MenuRepository {
    suspend fun getMenu(): Result<List<MenuItem>>

}