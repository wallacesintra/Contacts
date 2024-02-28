package com.example.contacts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey val id: Int,
    val firstName: String?,
    val lastName: String?,
    val phoneNumber: String
)
