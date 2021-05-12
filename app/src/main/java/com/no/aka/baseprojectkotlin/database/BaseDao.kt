/*
 * Copyright (c) 2021/5/10 - 6:59
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.database

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntity(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntities(entities: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEntity(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEntities(entities: List<T>)

    @Delete
    suspend fun deleteEntity(entity: T)

    @Delete
    suspend fun deleteEntities(entities: List<T>)


}