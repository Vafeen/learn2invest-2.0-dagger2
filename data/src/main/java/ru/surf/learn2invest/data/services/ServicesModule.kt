package ru.surf.learn2invest.data.services

import dagger.Binds
import dagger.Module
import ru.surf.learn2invest.data.services.coin_icon_loader.CoinIconLoaderImpl
import ru.surf.learn2invest.domain.services.ProfileManager
import ru.surf.learn2invest.domain.services.coin_icon_loader.CoinIconLoader

@Module
internal interface ServicesModule {
    @Binds
    fun provideProfileManager(profileManagerImpl: ProfileManagerImpl): ProfileManager

    @Binds
    fun provideCoinIconLoaderImpl(impl: CoinIconLoaderImpl): CoinIconLoader
}