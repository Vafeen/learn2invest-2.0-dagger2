package ru.surf.learn2invest.data.network_components

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.surf.learn2invest.domain.network.NetworkRepository
import ru.surf.learn2invest.domain.network.RetrofitLinks
import javax.inject.Singleton


@Module
internal class NetworkDIModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(RetrofitLinks.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build()
        ).build()

    @Provides
    @Singleton
    fun provideImageLoader(context: Context): ImageLoader =
        ImageLoader.Builder(context = context).components {
            add(SvgDecoder.Factory())
        }.build()

    @Provides
    @Singleton
    fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository =
        networkRepositoryImpl

    @Provides
    @Singleton
    fun provideCoinAPIService(retrofit: Retrofit): CoinAPIService = retrofit.create(
        CoinAPIService::class.java
    )
}