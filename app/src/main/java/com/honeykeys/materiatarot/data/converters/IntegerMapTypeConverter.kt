package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class IntegerMapTypeConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val mapType: Type = Types.newParameterizedType(Map::class.java, Int::class.java, Boolean::class.java)
    private val adapter: JsonAdapter<Map<Int, Boolean>> = moshi.adapter(mapType)
    @TypeConverter
    fun fromJson(value: String?): Map<Int, Boolean>? =
        value?.let { adapter.fromJson(it) }
    @TypeConverter
    fun toJson(value: Map<Int, Boolean>?): String? =
        value?.let { adapter.toJson(it) }
}