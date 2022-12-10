package com.example.finalproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.finalproject.database.Notes
import com.example.finalproject.database.NotesApplication
import com.example.finalproject.database.NotesDatabase
import com.example.finalproject.database.NotesDatabaseDao
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.fragments.AddNoteFragment
import com.example.finalproject.viewmodel.AddNoteViewModel
import com.example.finalproject.viewmodel.AddNoteViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val noteViewModel: AddNoteViewModel by viewModels {
        AddNoteViewModelFactory((application as NotesApplication).repository)
    }
    private lateinit var notesDao: NotesDatabaseDao
    private lateinit var db: NotesDatabase
    private val newNoteActivityRequestCode = 1
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        binding.bottomMenu2.setOnItemSelectedListener {
            onNavDestinationSelected(it, this.findNavController(R.id.myNavHostFragment))
                    || super.onOptionsItemSelected(it)
        }

        val navController = this.findNavController(R.id.myNavHostFragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.homePageFragment) {

                binding.bottomMenu2.visibility = View.GONE
            } else {

                binding.bottomMenu2.visibility = View.VISIBLE
            }
        }
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
        createDb()
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newNoteActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringArrayListExtra(AddNoteFragment.EXTRA_REPLY)?.let { reply ->
                val note = Notes(0,reply[0],reply[1],generateDate())
                noteViewModel.insert(note)
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Not Saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    private  fun generateDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        return currentDate
    }
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, NotesDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        notesDao = db.notesDatabaseDao()
    }

}