package com.basiatish.data.mappers

import com.basiatish.data.api.entities.MenuItemRemote
import com.basiatish.domain.entities.MenuItem

class MenuMapper {

    fun toMenuItem(menu: MenuItemRemote): MenuItem {
        return MenuItem(
            title = menu.title,
            description = menu.description,
            photoUrl = menu.photoUrl,
            price = menu.price
        )
    }

}