package com.example.shifttracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "shifts")
data class ShiftEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val startTime: String, // ISO 8601 format
    val endTime: String?,  // ISO 8601 format (null if ongoing)
    val location: String = "",
    val notes: String = "",
    val createdAt: String = LocalDateTime.now().toString()
)
