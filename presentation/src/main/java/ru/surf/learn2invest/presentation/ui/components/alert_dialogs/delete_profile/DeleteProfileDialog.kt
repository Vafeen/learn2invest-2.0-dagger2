package ru.surf.learn2invest.presentation.ui.components.alert_dialogs.delete_profile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.di.PresentationComponent
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.parent.CustomAlertDialog
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import javax.inject.Inject

/**
 * Диалоговое окно для удаления профиля пользователя.
 * Запрашивает подтверждение перед удалением и очищает базу данных.
 */
class DeleteProfileDialog : CustomAlertDialog() {

    /** Тег диалога для логирования и управления. */
    override val dialogTag: String = "DeleteProfileDialog"

    @Inject
    lateinit var factory: DeleteProfileDialogViewModel.Factory

    /** ViewModel для выполнения удаления профиля. */
    private val viewModel by viewModelCreator { factory.create() }

    /**
     * Инициализирует обработчики нажатий для кнопок подтверждения и отмены.
     */
    override fun initListeners() {
        binding.text.text = requireContext().getString(R.string.asking_to_delete_profile)

        binding.yesExactly.setOnClickListener {
            lifecycleScope.launchMAIN {
                viewModel.deleteProfile(requireActivity() as AppCompatActivity)
                dismiss()
            }
        }

        binding.no.setOnClickListener {
            dismiss()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as PresentationComponent).inject(this)
    }
}