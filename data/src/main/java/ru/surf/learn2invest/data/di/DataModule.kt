package ru.surf.learn2invest.data.di

import dagger.Module
import ru.surf.learn2invest.data.animator.AnimatorModule
import ru.surf.learn2invest.data.cryptography.CryptographyDIModule
import ru.surf.learn2invest.data.database_components.DatabaseDIModule
import ru.surf.learn2invest.data.network_components.NetworkDIModule
import ru.surf.learn2invest.data.services.ServicesModule

@Module(
    includes = [AnimatorModule::class,
        CryptographyDIModule::class,
        DatabaseDIModule::class,
        NetworkDIModule::class,
        ServicesModule::class]
)
class DataModule