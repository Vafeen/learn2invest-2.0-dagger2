package ru.surf.learn2invest.data.cryptography

import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.domain.cryptography.FingerprintAuthenticator
import ru.surf.learn2invest.domain.cryptography.PasswordHasher
import javax.inject.Singleton

@Module
internal class CryptographyDIModule {

    @Provides
    @Singleton
    fun bindFingerprintAuthenticator(
        impl: FingerprintAuthenticatorImpl
    ): FingerprintAuthenticator = impl

    @Provides
    @Singleton
    fun providePasswordHasher(impl: PasswordHasherImpl): PasswordHasher = impl
}
