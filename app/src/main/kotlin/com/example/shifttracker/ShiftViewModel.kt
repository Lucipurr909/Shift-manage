package com.example.shifttracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ShiftViewModel(application: Application) : AndroidViewModel(application) {
    private val database = ShiftDatabase.getDatabase(application)
    private val shiftDao = database.shiftDao()

    val allShifts: Flow<List<ShiftEntity>> = shiftDao.getAllShifts()
    val ongoingShifts: Flow<List<ShiftEntity>> = shiftDao.getOngoingShifts()

    fun insertShift(
        title: String,
        location: String = "",
        notes: String = ""
    ) {
        viewModelScope.launch {
            val now = LocalDateTime.now().toString()
            val shift = ShiftEntity(
                title = title,
                startTime = now,
                endTime = null,
                location = location,
                notes = notes
            )
            shiftDao.insertShift(shift)
        }
    }

    fun endShift(shift: ShiftEntity) {
        viewModelScope.launch {
            val now = LocalDateTime.now().toString()
            val updatedShift = shift.copy(endTime = now)
            shiftDao.updateShift(updatedShift)
        }
    }

    fun deleteShift(shift: ShiftEntity) {
        viewModelScope.launch {
            shiftDao.deleteShift(shift)
        }
    }

    fun updateShift(shift: ShiftEntity) {
        viewModelScope.launch {
            shiftDao.updateShift(shift)
        }
    }

    fun getShiftsByDate(date: String): Flow<List<ShiftEntity>> {
        return shiftDao.getShiftsByDate(date)
    }

    fun formatDateTime(dateTimeString: String): String {
        return try {
            val dateTime = LocalDateTime.parse(dateTimeString)
            val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a")
            dateTime.format(formatter)
        } catch (e: Exception) {
            dateTimeString
        }
    }
}
