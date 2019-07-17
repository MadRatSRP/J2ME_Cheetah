package com.madrat.j2me_cheetah

import android.app.Application
import com.madrat.j2me_cheetah.data.AppDatabase
import com.huma.room_for_asset.RoomAsset

class MyApplication: Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        database = RoomAsset.databaseBuilder(this,
            AppDatabase::class.java, "cheats.db"
        )
            //.allowMainThreadQueries()
            .build()
    }

    //fun getInstance() = instance

    fun getDatabase(): AppDatabase? {
        return database
    }
}