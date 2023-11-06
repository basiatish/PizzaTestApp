package com.basiatish.hammersystemstestapp.ui.menu.di

import com.basiatish.hammersystemstestapp.ui.menu.MenuFragment
import dagger.Subcomponent


@Subcomponent(modules = [MenuRepositoryModule::class, MenuUseCaseModule::class])
interface MenuComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MenuComponent
    }

    fun inject(fragment: MenuFragment)

}