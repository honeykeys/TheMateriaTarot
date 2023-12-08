package com.honeykeys.materiatarot.src.data.converters

import androidx.room.TypeConverter
import com.honeykeys.materiatarot.src.data.model.TarotCard
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class TarotCardsTypeConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listType = Types.newParameterizedType(List::class.java, TarotCard::class.java)
    private val jsonAdapter = moshi.adapter<List<TarotCard>>(listType)

    @TypeConverter
    fun fromTarotCardList(value: List<TarotCard>): String {
        return jsonAdapter.toJson(value)
    }

    @TypeConverter
    fun toTarotCardList(value: String): List<TarotCard>? {
        return jsonAdapter.fromJson(value)
    }
}