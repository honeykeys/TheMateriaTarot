package com.honeykeys.materiatarot.src.util

import com.honeykeys.materiatarot.src.data.datasource.local.CC
import com.honeykeys.materiatarot.src.data.datasource.local.OC
import com.honeykeys.materiatarot.src.data.datasource.local.PPF
import com.honeykeys.materiatarot.src.data.datasource.local.SOO
import com.honeykeys.materiatarot.src.data.datasource.local.YA
import com.honeykeys.materiatarot.src.data.model.ReadingLayout

fun stringToLayout(layout: String): ReadingLayout {
    return when(layout) {
        "single" -> OC
        "time" -> PPF
        "situation" -> SOO
        "cross" -> CC
        "year" -> YA
        else -> OC
    }
}

fun layoutToString(layout: ReadingLayout): String {
    return when(layout) {
        OC -> "single"
        PPF -> "time"
        SOO -> "situation"
        CC -> "cross"
        YA -> "year"
        else -> "single"
    }
}