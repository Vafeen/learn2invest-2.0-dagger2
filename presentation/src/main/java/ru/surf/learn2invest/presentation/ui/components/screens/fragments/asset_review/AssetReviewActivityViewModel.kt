package ru.surf.learn2invest.presentation.ui.components.screens.fragments.asset_review

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import ru.surf.learn2invest.domain.services.coin_icon_loader.CoinIconLoader
import ru.surf.learn2invest.domain.services.coin_icon_loader.usecase.LoadCoinIconUseCase
import javax.inject.Inject

/**
 * ViewModel для [AssetReviewActivity], управляющий загрузкой иконки актива.
 * Хранит и управляет запросом на загрузку иконки.
 */
class AssetReviewActivityViewModel @Inject constructor(private val loadCoinIconUseCase: LoadCoinIconUseCase) :
    ViewModel() {

    private var imageLoaderRequest: CoinIconLoader.Request? = null

    /**
     * Загружает иконку актива и отображает её в переданном ImageView.
     */
    fun loadImage(imageView: ImageView, symbol: String) {
        imageLoaderRequest = loadCoinIconUseCase.invoke(imageView, symbol)
    }

    /**
     * Отменяет текущую загрузку иконки.
     */
    fun cancelLoadingImage() {
        imageLoaderRequest?.cancel()
    }
    class Factory @Inject constructor(
        private val loadCoinIconUseCase: LoadCoinIconUseCase
    ) {
        fun create() = AssetReviewActivityViewModel(loadCoinIconUseCase)
    }
}
