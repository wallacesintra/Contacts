package com.example.contacts

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName")
    fun orderByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName")
    fun orderByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber")
    fun orderByPhoneNumber(): Flow<List<Contact>>
}
