package com.honeykeys.materiatarot.src.data.datasource.local

import com.honeykeys.materiatarot.src.data.model.ReadingLayout

val OC = ReadingLayout(
    numberOfCards = 1,
    description = "A one card reading that illuminates a question or situation",
    positionMeaning = listOf("Situation")
)

val PPF = ReadingLayout(
    numberOfCards = 3,
    description = "A three card reading detailing the past, the present, and the future",
    positionMeaning = listOf("Past", "Present", "Future")
)

val SOO = ReadingLayout(
    numberOfCards = 3,
    description = "A three card reading detailing the situation, the obstacle, and the outcome",
    positionMeaning = listOf("Situation", "Obstacle", "Outcome")
)

val CC = ReadingLayout(
    numberOfCards = 10,
    description = "A ten card reading that deeply describes a situation or question",
    positionMeaning = listOf(
        "Present", "Challenge", "Past", "Future", "Above", "Below",
    "Advice", "External Influence", "Hopes + Fears", "Outcome")
)

val YA = ReadingLayout(
    numberOfCards = 12,
    description = "A twelve card reading that outlines an upcoming year",
    positionMeaning = listOf(
        "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"
    )
)