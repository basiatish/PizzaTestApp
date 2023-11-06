package com.basiatish.data.api.entities

import com.google.gson.annotations.SerializedName

data class MenuItemRemote(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("price") val price: String,
)
