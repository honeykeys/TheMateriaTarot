package com.honeykeys.materiatarot.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun localDateToString(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")
    return date.format(formatter)
}