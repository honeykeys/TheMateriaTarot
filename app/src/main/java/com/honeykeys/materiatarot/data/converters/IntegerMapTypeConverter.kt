package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class IntegerMapTypeConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val mapType: Type = Types.newParameterizedType(Map::class.java, Int::class.java, Int::class.java)
    private val adapter: JsonAdapter<Map<Int, Int>> = moshi.adapter(mapType)
    @TypeConverter
    fun fromJson(value: String?): Map<Int, Int>? =
        value?.let { adapter.fromJson(it) }
    @TypeConverter
    fun toJson(value: Map<Int, Int>?): String? =
        value?.let { adapter.toJson(it) }
}