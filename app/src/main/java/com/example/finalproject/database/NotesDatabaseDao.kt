package com.example.finalproject.database
 
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(note: Notes)

    @Delete
      fun delete(note: Notes)

    @Query("Select * from notes_table order by id ASC")
     fun getAllNotes(): LiveData<List<Notes>>
   
//    @Update
//    suspend fun update(note: Notes)

//    @Query("DELETE FROM notes_table")
//    suspend fun deleteAll()
 
}