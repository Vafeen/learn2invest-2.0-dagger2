package ru.surf.learn2invest.presentation.ui.components.screens.fragments.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.databinding.FragmentProfileBinding
import ru.surf.learn2invest.presentation.di.PresentationComponent
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.delete_profile.DeleteProfileDialog
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.reset_stats.ResetStatsDialog
import ru.surf.learn2invest.presentation.utils.setStatusBarColor
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import javax.inject.Inject

/**
 * Фрагмент профиля в [HostActivity][ru.surf.learn2invest.presentation.ui.components.screens.host.HostActivity]
 */
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    @Inject
    lateinit var factory: ProfileFragmentViewModel.Factory
    private val viewModel: ProfileFragmentViewModel by viewModelCreator { factory.create() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        activity?.apply {
            setStatusBarColor(window, this, R.color.white, R.color.main_background_dark)
        }

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        initListeners()
        lifecycleScope.launchMAIN {
            viewModel.profileFlow.collect {
                binding.apply {
                    firstNameLastNameTV.text = it.let { pr -> "${pr.firstName}\n${pr.lastName}" }
                    confirmDealBtnSwitcher.isChecked = it.tradingPasswordHash != null
                    changeTradingPasswordBtn.isVisible = it.tradingPasswordHash != null
                    biometryBtnSwitcher.isChecked = it.biometry
                }
            }
        }
        return binding.root
    }

    private fun initListeners() {
        binding.also { fr ->
            fr.biometryBtn.isVisible =
                viewModel.isBiometricAvailable(activity = activity as AppCompatActivity)
            fr.deleteProfileTV.setOnClickListener {
                DeleteProfileDialog().showDialog(parentFragmentManager)
            }

            fr.resetStatsBtn.setOnClickListener {
                ResetStatsDialog().showDialog(parentFragmentManager)
            }

            fr.biometryBtn.setOnClickListener {
                viewModel.biometryBtnSwitch(activity as AppCompatActivity)
            }

            fr.changeTradingPasswordBtn.setOnClickListener {
                viewModel.changeTradingPassword(requireContext())
            }

            fr.confirmDealBtn.setOnClickListener {
                viewModel.changeTransactionConfirmation(requireContext())
            }

            fr.changePINBtn.setOnClickListener {
                viewModel.changePIN(requireContext())
            }

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as PresentationComponent).inject(this)
    }
}