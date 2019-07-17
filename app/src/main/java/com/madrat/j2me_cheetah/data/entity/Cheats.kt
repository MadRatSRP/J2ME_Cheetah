package com.madrat.j2me_cheetah.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.madrat.j2me_cheetah.`object`.cheats

@Entity(tableName = cheats.TABLE_NAME)
data class Cheats (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = cheats.COLUMN_NAME_ID)
    var id: Int,

    @ColumnInfo(name = cheats.COLUMN_NAME_TITLE)
    var title: String,
    @ColumnInfo(name = cheats.COLUMN_NAME_DESCRIPTION)
    var description: String
)