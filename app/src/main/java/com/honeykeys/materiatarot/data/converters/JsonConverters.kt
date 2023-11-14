package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import com.honeykeys.materiatarot.data.TarotCard
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory



class JsonConverters {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val listJsonAdapter: JsonAdapter<List<*>>? = moshi.adapter(
        List::class.java
    )
    @TypeConverter
    fun fromJson(json: String): List<TarotCard>? {
        val listType = Types.newParameterizedType(List::class.java, TarotCard::class.java)
        val adapter: JsonAdapter<List<TarotCard>> = moshi.adapter(listType)
        return adapter.fromJson(json)
    }
    @TypeConverter
    fun toJson(deck: List<TarotCard>?): String {
        val listType = Types.newParameterizedType(List::class.java, TarotCard::class.java)
        val adapter: JsonAdapter<List<TarotCard>> = moshi.adapter(listType)
        return adapter.toJson(deck)
    }
}