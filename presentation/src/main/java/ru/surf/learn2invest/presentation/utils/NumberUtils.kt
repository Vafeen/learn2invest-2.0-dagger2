package ru.surf.learn2invest.presentation.utils

import kotlin.math.roundToInt

fun Float.round(): Float = ((this * 100).roundToInt() / 100.0).toFloat()




