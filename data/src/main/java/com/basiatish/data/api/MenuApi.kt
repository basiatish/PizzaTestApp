package com.basiatish.data.api

import com.basiatish.data.api.entities.MenuItemRemote
import retrofit2.Response
import retrofit2.http.GET

interface MenuApi {

    @GET("menu.json")
    suspend fun getMenuList(): Response<List<MenuItemRemote>>
}