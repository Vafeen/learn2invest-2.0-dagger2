package ru.surf.learn2invest.app

import android.app.Application
import ru.surf.learn2invest.presentation.di.PresentationComponent
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.buy_dialog.BuyDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.delete_profile.DeleteProfileDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.refill_account_dialog.RefillAccountDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.reset_stats.ResetStatsDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.sell_dialog.SellDialog
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.asset_overview.AssetOverviewFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.asset_review.AssetReviewActivity
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.history.HistoryFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.marketreview.MarketReviewFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.portfolio.PortfolioFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.profile.ProfileFragment
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.subhistory.SubHistoryFragment
import ru.surf.learn2invest.presentation.ui.components.screens.sign_in.SignInActivity
import ru.surf.learn2invest.presentation.ui.components.screens.sign_up.SignUpActivity
import ru.surf.learn2invest.presentation.ui.components.screens.trading_password.TradingPasswordActivity
import ru.surf.learn2invest.presentation.ui.main.MainActivity
class App : Application(), PresentationComponent {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

    override fun inject(buyDialog: BuyDialog) = appComponent.inject(buyDialog)
    override fun inject(deleteProfileDialog: DeleteProfileDialog) = appComponent.inject(deleteProfileDialog)
    override fun inject(refillAccountDialog: RefillAccountDialog) = appComponent.inject(refillAccountDialog)
    override fun inject(resetStatsDialog: ResetStatsDialog) = appComponent.inject(resetStatsDialog)
    override fun inject(sellDialog: SellDialog) = appComponent.inject(sellDialog)
    override fun inject(assetOverviewFragment: AssetOverviewFragment) = appComponent.inject(assetOverviewFragment)
    override fun inject(assetReviewActivity: AssetReviewActivity) = appComponent.inject(assetReviewActivity)
    override fun inject(historyFragment: HistoryFragment) = appComponent.inject(historyFragment)
    override fun inject(marketReviewFragment: MarketReviewFragment) = appComponent.inject(marketReviewFragment)
    override fun inject(portfolioFragment: PortfolioFragment) = appComponent.inject(portfolioFragment)
    override fun inject(profileFragment: ProfileFragment) = appComponent.inject(profileFragment)
    override fun inject(subHistoryFragment: SubHistoryFragment) = appComponent.inject(subHistoryFragment)
    override fun inject(signInActivity: SignInActivity) = appComponent.inject(signInActivity)
    override fun inject(signUpActivity: SignUpActivity) = appComponent.inject(signUpActivity)
    override fun inject(tradingPasswordActivity: TradingPasswordActivity) = appComponent.inject(tradingPasswordActivity)
    override fun inject(mainActivity: MainActivity) = appComponent.inject(mainActivity)
}
