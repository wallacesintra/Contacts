package com.example.contacts

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName")
    suspend fun orderByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName")
    suspend fun orderByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber")
    suspend fun orderByPhoneNumber(): Flow<List<Contact>>
}
