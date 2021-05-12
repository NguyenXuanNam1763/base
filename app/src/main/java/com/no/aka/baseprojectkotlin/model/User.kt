/*
 * Copyright (c) 2021/5/10 - 6:31
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbUser")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    val email: String
)