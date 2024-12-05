package com.example.practica2dimenu

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.practica2dimenu.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        drawerLayout = binding.drawerLayout

        setSupportActionBar(binding.toolbar)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout ,binding.toolbar, R.string.abrir, R.string.cerrar)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

            binding.navegacion.setNavigationItemSelectedListener { item ->
                when (item.itemId) {

                    R.id.parte1 -> {

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }

                    R.id.parte2 -> {

                        val intent = Intent(this, GalleryActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.parte3 -> {

                        val intent = Intent(this, Slideshow::class.java)
                        startActivity(intent)

                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

        }

    }

