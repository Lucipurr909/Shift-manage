package com.example.shifttracker

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShiftDao {
    @Insert
    suspend fun insertShift(shift: ShiftEntity): Long

    @Update
    suspend fun updateShift(shift: ShiftEntity)

    @Delete
    suspend fun deleteShift(shift: ShiftEntity)

    @Query("SELECT * FROM shifts WHERE id = :id")
    suspend fun getShiftById(id: Int): ShiftEntity?

    @Query("SELECT * FROM shifts ORDER BY startTime DESC")
    fun getAllShifts(): Flow<List<ShiftEntity>>

    @Query("SELECT * FROM shifts WHERE startTime LIKE :date || '%' ORDER BY startTime DESC")
    fun getShiftsByDate(date: String): Flow<List<ShiftEntity>>

    @Query("SELECT * FROM shifts WHERE endTime IS NULL")
    fun getOngoingShifts(): Flow<List<ShiftEntity>>

    @Query("DELETE FROM shifts")
    suspend fun deleteAllShifts()
}
