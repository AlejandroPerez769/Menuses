package com.example.practica2dimenu


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2dimenu.R
import com.example.practica2dimenu.databinding.ActivityMainBinding
import com.example.practica2dimenu.databinding.GalleryActivityBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: GalleryActivityBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private val imagesList = listOf(
        R.drawable.image1, R.drawable.image2, R.drawable.image4,
        R.drawable.image5, R.drawable.image6, R.drawable.image7,
        R.drawable.image8, R.drawable.image9
    )

    val cardItems = listOf(
        CardItem("Título 1"),
        CardItem("Título 2"),
        CardItem("Título 3"),
        CardItem("Título 4"),
        CardItem("Título 5"),
        CardItem("Título 6"),
        CardItem("Título 7"),
        CardItem("Título 8"),
        CardItem("Título 9")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_activity)

        binding = GalleryActivityBinding.inflate(layoutInflater)
        drawerLayout = binding.drawerLayout
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        imageAdapter = ImageAdapter( cardItems,imagesList,this)
        recyclerView.adapter = imageAdapter

        setSupportActionBar(binding.toolbar)
        registerForContextMenu(recyclerView)

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.abrir,
            R.string.cerrar
        )
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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.edit -> {
                val position = item.groupId // Recuperar la posición del elemento seleccionado
                Toast.makeText(this, "Opción 1 seleccionada en posición $position", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.delete -> {
                val position = item.groupId
                Toast.makeText(this, "Opción 2 seleccionada en posición $position", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.share -> {
                val position = item.groupId
                Toast.makeText(this, "Opción 2 seleccionada en posición $position", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }



}





