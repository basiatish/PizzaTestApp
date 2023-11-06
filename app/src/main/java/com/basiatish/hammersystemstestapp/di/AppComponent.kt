package com.basiatish.hammersystemstestapp.di

import com.basiatish.hammersystemstestapp.ui.menu.di.MenuComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubComponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun menuComponent(): MenuComponent.Factory

}