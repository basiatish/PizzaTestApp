package com.basiatish.domain.usecases

import com.basiatish.domain.repositories.MenuRepository

class GetMenuUseCase(private val menuRepository: MenuRepository) {

    suspend fun invoke() = menuRepository.getMenu()

}