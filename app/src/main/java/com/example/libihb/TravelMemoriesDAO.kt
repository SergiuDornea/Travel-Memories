//package com.example.libihb
//
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.libihb.TravelMemories

@Dao
interface TravelMemoriesDAO {
    @Query("SELECT * FROM memories")
    fun getAll() : List<TravelMemories>
//
//    @Query("SELECT * FROM memories WHERE id = :id")
//    suspend fun get(id: Int) :TravelMemories

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memory: TravelMemories)

    @Delete
    suspend fun delete(memory : TravelMemories)

    @Update
    suspend fun update(memory :TravelMemories)
}