package ru.surf.learn2invest.app

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.surf.learn2invest.data.di.DataModule
import ru.surf.learn2invest.presentation.di.PresentationComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AppComponent : PresentationComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder
    }
}
