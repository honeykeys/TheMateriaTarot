package com.honeykeys.materiatarot.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity (tableName = "reading")
data class Reading(
    @PrimaryKey(autoGenerate = true)
    val readingId: Long = 0,
    val readingDate: LocalDate,
    val readingDeck: List<TarotCard>
    )

