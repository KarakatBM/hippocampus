package com.example.finalproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KParameter

@Database(entities = arrayOf(Notes::class), version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {


	abstract fun notesDatabaseDao(): NotesDatabaseDao

	private class NotesDatabaseCallback(
		private val scope: CoroutineScope
	) : RoomDatabase.Callback() {

		override fun onCreate(db: SupportSQLiteDatabase) {
			super.onCreate(db)
			INSTANCE?.let { database ->
				scope.launch {
					var notesDao = database.notesDatabaseDao()

					// Delete all content here.
//					notesDao.deleteAll()

					// Add sample words.
					var word = Notes("1","2","23.06")
					notesDao.insert(word)
					word = Notes("World!","k","k")
					notesDao.insert(word)

					// TODO: Add your own words!
					word = Notes("TODO!","desc","time")
					notesDao.insert(word)
				}
			}
		}
	}
	companion object {
		// Singleton prevents multiple instances of database opening at the same time
		@Volatile
		private var INSTANCE: NotesDatabase? = null

//		fun getInstance(context: Context, scope: CoroutineScope): NotesDatabase {
//			synchronized(this) {
//				var instance = INSTANCE
//
//				if (instance == null) {
//					instance = Room.databaseBuilder(
//						context.applicationContext,
//						NotesDatabase::class.java,
//						"notes_database"
//					)
//						.addCallback(NotesDatabaseCallback(scope))
//						.build()
//					INSTANCE = instance
//				}
//				return instance
//			}
//		}

		fun getInstance(context: Context): NotesDatabase {
			// if the INSTANCE is not null, then return it,
			// if it is, then create the database
			return INSTANCE ?: synchronized(this) {
				val instance = Room.databaseBuilder(
					context.applicationContext,
					NotesDatabase::class.java,
					"notes_database"
				).build()
				INSTANCE = instance
				// return instance
				instance
			}
		}
	}
}
