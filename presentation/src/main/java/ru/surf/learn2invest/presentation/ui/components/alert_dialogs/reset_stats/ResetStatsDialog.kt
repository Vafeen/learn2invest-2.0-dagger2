package ru.surf.learn2invest.presentation.ui.components.alert_dialogs.reset_stats

import android.content.Context
import androidx.lifecycle.lifecycleScope
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.di.PresentationComponent
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.parent.CustomAlertDialog
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import javax.inject.Inject

/**
 * Диалог для сброса статистики.
 *
 * Этот диалог предоставляет пользователю возможность сбросить статистику (баланс) в приложении.
 * Включает в себя кнопки для подтверждения сброса или отмены действия.
 *
 * @constructor Инициализирует диалог с использованием ViewModel для сброса статистики.
 */

class ResetStatsDialog : CustomAlertDialog() {

    /**
     * Тег диалога, используемый для идентификации.
     */
    override val dialogTag: String = "ResetStatsDialog"

    /**
     * Инициализирует слушателей для кнопок в диалоге.
     *
     * Устанавливает текст для кнопки подтверждения сброса и настраивает обработчики кликов для
     * кнопок "Да, точно" и "Нет". При подтверждении сброса статистики запускается соответствующий
     * процесс через ViewModel, а диалог закрывается.
     */
    override fun initListeners() {
        // Устанавливаем текст для кнопки сброса статистики
        binding.text.text = requireContext().getString(R.string.reset_stats)

        // Обработчик для кнопки "Да, точно" — сбрасывает статистику и закрывает диалог
        binding.yesExactly.setOnClickListener {
            lifecycleScope.launchMAIN {
                // Вызываем функцию сброса статистики из ViewModel
                viewModel.resetStats(requireContext())
                // Закрываем диалог после сброса
                dismiss()
            }
        }

        // Обработчик для кнопки "Нет" — просто закрывает диалог
        binding.no.setOnClickListener {
            dismiss()
        }
    }

    /**
     * ViewModel для работы с логикой сброса статистики.
     */
    @Inject
    lateinit var factory: ResetStatsDialogViewModel.Factory
    private val viewModel: ResetStatsDialogViewModel by viewModelCreator { factory.create() }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as PresentationComponent).inject(this)
    }
}
