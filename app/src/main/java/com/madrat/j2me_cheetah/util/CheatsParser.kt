package com.madrat.j2me_cheetah.util

import com.madrat.j2me_cheetah.model.Cheat
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi


class CheatsParser(moshi: Moshi) {
    private val cheatsAdapter: JsonAdapter<Cheat> = moshi.adapter(Cheat::class.java)

    fun parse(reader: JsonReader): List<Cheat> {
        return reader.readArrayToList {
            cheatsAdapter.fromJson(reader)
        }
    }
}