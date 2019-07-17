package com.madrat.j2me_cheetah.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madrat.j2me_cheetah.data.dao.CheatsDAO
import com.madrat.j2me_cheetah.data.entity.Cheats

@Database(entities = arrayOf(Cheats::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cheatsDao(): CheatsDAO
}