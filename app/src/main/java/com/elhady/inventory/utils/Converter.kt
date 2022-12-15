package com.elhady.inventory.utils

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(value: Int?): String {
        return value?.toString() ?: ""
        // Converts int to String.
    }

    @JvmStatic
    fun stringToInt(value: String): Int? {
        return if (value.isNotEmpty()) {
            value.toInt()
        } else {
            0
        }
        // Converts string to int.
    }
}