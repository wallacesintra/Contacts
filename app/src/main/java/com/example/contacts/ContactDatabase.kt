package com.example.contacts

import androidx.room.Database

@Database(
    entities = [Contact :: class],
    version = 1
)
abstract class ContactDatabase {
    abstract fun contactDao(): ContactDao
}