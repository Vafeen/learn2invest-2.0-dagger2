package ru.surf.learn2invest.data.animator

import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.domain.animator.CustomAnimator
import javax.inject.Singleton

@Module
internal class AnimatorModule {
    @Provides
    @Singleton
    fun provideAnimator(impl: CustomAnimatorImpl): CustomAnimator = impl
}