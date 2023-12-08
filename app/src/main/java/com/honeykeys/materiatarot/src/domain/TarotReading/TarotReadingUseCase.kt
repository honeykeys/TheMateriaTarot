package com.honeykeys.materiatarot.src.domain.TarotReading

import com.honeykeys.materiatarot.src.data.model.ReadingLayout
import com.honeykeys.materiatarot.src.data.model.TarotCard
import com.honeykeys.materiatarot.src.data.repository.CardRepository
import com.honeykeys.materiatarot.src.data.repository.ReadingRepository

class TarotReadingUseCase(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository,
) {
    fun setTarotReading(layoutInput: String, questionInput: String): TarotReading {
        val layout = setLayout(layoutInput)
        val limit = setLimit(layout)

        return TarotReading(generateTarotCards(limit), layout, questionInput)
    }
   suspend fun saveTarotReading(reading: TarotReading) {
        readingRepository.saveNewReading(reading)
    }

    private fun generateTarotCards(limit: Int): List<TarotCard> {
        val cardNumbers = (1..78).shuffled().take(limit)
        return cardNumbers.map { number ->
            cardRepository.getTarotCard(number)
        }
    }
    private fun setLayout(layout: String): ReadingLayout {
        return readingRepository.getLayout(layout)

    }
    private fun setLimit(layout: ReadingLayout): Int {
        return layout.numberOfCards
    }

    private fun setQuestion(question: String): String {
        return question
    }

}