package com.example.libihb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity(tableName = "memories")
data class TravelMemories(
//    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo("poza_locatie") var titleImg : Int,
    @ColumnInfo("nume_locatie")var placeName: String,
    @ColumnInfo("locatie")var placeLocation : String,
    @ColumnInfo("data")var dateOfTravel :String)