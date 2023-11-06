package com.basiatish.data.repositories

import com.basiatish.data.api.MenuApi
import com.basiatish.data.mappers.MenuMapper
import com.basiatish.domain.common.Result
import com.basiatish.domain.entities.MenuItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MenuRemoteSourceImpl(
    private val service: MenuApi,
    private val mapper: MenuMapper,
    private val dispatcher: CoroutineDispatcher
) : MenuRemoteSource {

    override suspend fun getMenu(): Result<List<MenuItem>> =
        withContext(dispatcher) {
            try {
                val response = service.getMenuList()
                if (response.isSuccessful) {
                    return@withContext Result.Success(
                        response.body()!!.map { mapper.toMenuItem(it) })
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }

}