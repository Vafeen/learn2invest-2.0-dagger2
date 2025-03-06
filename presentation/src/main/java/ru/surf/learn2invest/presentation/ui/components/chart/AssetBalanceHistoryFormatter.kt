package ru.surf.learn2invest.presentation.ui.components.chart

import com.github.mikephil.charting.charts.LineChart
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Класс для отображения дат для графика в зависимости от количества точек
 */
internal class AssetBalanceHistoryFormatter(private val dates: List<Date>) : CustomDateValueFormatter {
    private val dateFormatter = SimpleDateFormat("dd MMM", Locale.getDefault())

    override fun getFormattedValue(value: Float, chart: LineChart): String {
        val index = value.toInt()
        return if (index in dates.indices) {
            dateFormatter.format(dates[index])
        } else {
            ""
        }
    }
}