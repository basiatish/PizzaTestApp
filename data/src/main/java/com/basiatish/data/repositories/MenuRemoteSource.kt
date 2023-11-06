package com.basiatish.data.repositories

import com.basiatish.domain.common.Result
import com.basiatish.domain.entities.MenuItem

interface MenuRemoteSource {

    suspend fun getMenu(): Result<List<MenuItem>>

}