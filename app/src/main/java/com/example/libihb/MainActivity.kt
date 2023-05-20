package com.example.libihb

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libihb.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //create list for rv and make it accessible only in this class
    private val travelMemoriesList = getTravelMemory()
    val adapter = MyAdapter(travelMemoriesList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about_us, R.id.nav_contact_us,R.id.nav_share, R.id.nav_settings, R.id.nav_log_out
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        // find my recycle view
        val recycleView : RecyclerView = findViewById(R.id.home_recycleView)
        // use my custom adapter
        recycleView.adapter = adapter
        // position items ito recycle view
        recycleView.layoutManager = LinearLayoutManager(this)
        // performance optimization
        recycleView.setHasFixedSize(true)


//        // add / edit btns section
//         // add / edit btns
//
//    private val editBtn = findViewById<Button>(R.id.edit_memories)
//    private val addBtn = findViewById<Button>(R.id.add_memories)

//        addBtn.setOnClickListener(View.OnClickListener(){
//            fun onClick(){
//               openDialog()
//            }
//        })
//
//        fun openDialog(){
//
//        }

    }

    fun getTravelMemory() : List<TravelMemories>{
        val tML = mutableListOf<TravelMemories>()
        repeat(10) {
            tML.add(
                TravelMemories(
                    R.drawable.rimetea,
                    "Piatra Secuiului",
                    "Judetul: Alba, Localitate: Rimetea",
                    "01/07/2020"
                )
            )
        }
            return tML
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun editMemory(view: View) {}
    fun addMemory(view: View) {}
}