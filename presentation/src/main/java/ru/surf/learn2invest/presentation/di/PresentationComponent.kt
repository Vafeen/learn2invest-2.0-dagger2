package ru.surf.learn2invest.presentation.di

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

interface PresentationComponent {
    fun inject(buyDialog: BuyDialog)
    fun inject(deleteProfileDialog: DeleteProfileDialog)
    fun inject(refillAccountDialog: RefillAccountDialog)
    fun inject(resetStatsDialog: ResetStatsDialog)
    fun inject(sellDialog: SellDialog)
    fun inject(assetOverviewFragment: AssetOverviewFragment)
    fun inject(assetReviewActivity: AssetReviewActivity)
    fun inject(historyFragment: HistoryFragment)
    fun inject(marketReviewFragment: MarketReviewFragment)
    fun inject(portfolioFragment: PortfolioFragment)
    fun inject(profileFragment: ProfileFragment)
    fun inject(subHistoryFragment: SubHistoryFragment)
    fun inject(signInActivity: SignInActivity)
    fun inject(signUpActivity: SignUpActivity)
    fun inject(tradingPasswordActivity: TradingPasswordActivity)
    fun inject(mainActivity: MainActivity)
}