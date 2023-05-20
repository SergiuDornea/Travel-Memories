package com.example.libihb

import TravelMemoriesDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[TravelMemories::class], version = 1)
abstract class TravelMemoriesDB : RoomDatabase(){
    abstract fun memoriesDao() : TravelMemoriesDAO

    companion object{
        @Volatile
        private var INSTANCE : TravelMemoriesDB? = null

        fun getDatabase(context : Context) : TravelMemoriesDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TravelMemoriesDB::class.java,
                    "travel_memories_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}