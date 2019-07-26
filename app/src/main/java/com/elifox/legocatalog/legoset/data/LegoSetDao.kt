package com.elifox.legocatalog.legoset.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the LegoSet class.
 */
@Dao
interface LegoSetDao {

    @Query("SELECT * FROM sets WHERE themeId = :themeId ORDER BY name")
    fun getLegoSets(themeId: Int): LiveData<List<LegoSet>>

    // TODO filtered
    //@Query("SELECT * FROM sets WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    //fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): LiveData<List<LegoSet>>

    @Query("SELECT * FROM sets WHERE id = :id")
    fun getLegoSet(id: String): LiveData<LegoSet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<LegoSet>)
}