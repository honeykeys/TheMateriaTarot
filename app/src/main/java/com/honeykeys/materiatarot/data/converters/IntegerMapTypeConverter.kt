package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class IntegerMapTypeConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val mapType: Type = Types.newParameterizedType(Map::class.java, Int::class.java, Boolean::class.java)
    private val adapter: JsonAdapter<Map<Int, Boolean>> = moshi.adapter(mapType)
    @TypeConverter
    fun fromJson(value: String): Map<Int, Boolean> {
        return try {
            adapter.fromJson(value) ?: emptyMap() // Use an empty map as a default if adapter.fromJson returns null
        } catch (e: JsonDataException) {
            // Handle parsing exceptions or return an empty map in case of failure to parse JSON
            emptyMap()
        }
    }
    @TypeConverter
    fun toJson(value: Map<Int, Boolean>): String {
        return try {
            adapter.toJson(value) ?: "" // Return an empty string if adapter.toJson returns null
        } catch (e: JsonDataException) {
            // Handle conversion exceptions or return an empty string in case of failure to convert to JSON
            ""
        }
    }
}