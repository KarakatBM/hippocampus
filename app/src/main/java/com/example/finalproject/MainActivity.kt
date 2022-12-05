package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.example.finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}