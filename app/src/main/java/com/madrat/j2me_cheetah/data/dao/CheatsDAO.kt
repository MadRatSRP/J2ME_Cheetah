package com.madrat.j2me_cheetah.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.madrat.j2me_cheetah.data.entity.Cheats

@Dao
interface CheatsDAO {
    @Query("SELECT * FROM cheats")
    fun getAll(): List<Cheats>
}