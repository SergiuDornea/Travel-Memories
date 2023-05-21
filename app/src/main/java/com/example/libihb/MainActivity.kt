package com.example.libihb

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.ColumnInfo
import com.example.libihb.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import java.sql.BatchUpdateException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //create list for rv and make it accessible only in this class
    private val travelMemoriesList = getTravelMemory()
    val adapter = MyAdapter(travelMemoriesList)


    var ig: ImageView? = null
    var fb: ImageView? = null
    var yt: ImageView? = null

    private lateinit var addBtn: FloatingActionButton

    // var for date picker
    private lateinit var tvDatePicker : TextView
    private lateinit var btnDatePicker : Button

// var for DB
    private lateinit var appD : TravelMemoriesDB

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
                R.id.nav_home,
                R.id.nav_about_us,
                R.id.nav_contact_us,
                R.id.nav_share,
                R.id.nav_settings,
                R.id.nav_log_out
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        // find my recycle view
        val recycleView: RecyclerView = findViewById(R.id.home_recycleView)
        // use my custom adapter
        recycleView.adapter = adapter
        // position items ito recycle view
        recycleView.layoutManager = LinearLayoutManager(this)
        // performance optimization
        recycleView.setHasFixedSize(true)


        // contact us btns
        ig = findViewById(R.id.id_insta)
        fb = findViewById(R.id.id_facebook)
        yt = findViewById(R.id.id_youtube)
//        allClickListener()


        // add  btn section
        // add float button in main
        addBtn = findViewById<FloatingActionButton>(R.id.add_memories)
        // btns in add dialog
        val addAddBtn = findViewById<Button>(R.id.add_add_btn)
        val addCancelBtn = findViewById<Button>(R.id.add_cancel_btn)
//        // et in add dialog
        val placeName = findViewById<EditText>(R.id.et_place_name)
        val placeLocation = findViewById<EditText>(R.id.et_place_location)
//        val placeDate = findViewById<TextView>(R.id.et_place_date)


        addBtn.setOnClickListener {
            // inflate the dialog with my custom view
            val myDialogView = LayoutInflater.from(this).inflate(R.layout.layout_add_memory, null)

//             alert dialog builder
            val myBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Add memory")
//
            // show dialog
            val myAlertDialog = myBuilder.show()

            // TODO make cancel and add btn work

////          cancel btn onclick of custom layout
//            addCancelBtn.setOnClickListener() {
//                myAlertDialog.dismiss()
//            }

//            // add memory btn onclick of custom layout
//            addAddBtn.setOnClickListener {
//                // dismiss dialog
//                myAlertDialog.dismiss()
//                // get text from et
//                // place name
//                val name = placeName.text.toString()
//                // place location
//                val location = placeLocation.text.toString()
//                // place date
//                val date = placeDate.text.toString()
//                // @TODO add values to DB
//            }

        }


        // @TODO make DATE PICKER functionality work
//        btnDatePicker = findViewById(R.id.tv_place_date)
//        tvDatePicker = findViewById(R.id.et_place_date)
//
//        val myCalendar = Calendar.getInstance()
//        val datePicker = DatePickerDialog.OnDateSetListener{
//            view, year, month, dayOfMonth ->
//            myCalendar.set(Calendar.YEAR, year)
//            myCalendar.set(Calendar.MONTH, month)
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//            updateLable(myCalendar)
//        }
//
//        btnDatePicker.setOnClickListener{
//            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH) ).show()
//        }
//
//    }
//
//    private fun updateLable(myCalendar: Calendar) {
//        val myFormat = "dd-MM-yyyy"
//        val sdf = SimpleDateFormat(myFormat, Locale.ITALY)
//        tvDatePicker.setText(sdf.format(myCalendar.time))
//    }


// @TODO make CONTACT_US btns functionality work

//    // fun for setting contact_us
//    private fun allClickListener() {
//        ig?.setOnClickListener(View.OnClickListener() {
//            fun onClick(){
//                sharingToSocialMedia()
//            }
//        })
//
//        fb?.setOnClickListener(View.OnClickListener() {
//            sharingToSocialMedia()
//        })
//
//        yt?.setOnClickListener(View.OnClickListener() {
//            sharingToSocialMedia()
//        })
//
//    }
//
//    private fun sharingToSocialMedia(application: String, linkopen : String ){
//        val intent : Intent = Intent()
//        intent.setAction(Intent.ACTION_SEND)
//        intent.setType("text/plain")
//        intent.putExtra(Intent.EXTRA_TEXT, linkopen)
//        val instaled : Boolean = checkAppInstal(application)
//        // check if app is instaled
//        if(instaled){
//            intent.setPackage(application)
//            startActivity(intent)
//        }else{
//            Toast.makeText(applicationContext,"Install app first", Toast.LENGTH_SHORT).show()
//        }
//
//
//    }
//
//    private fun checkAppInstal(uri: String): Boolean {
//        val pm : PackageManager = packageManager
//        try {
//            pm.getPackageInfo(uri,PackageManager.GET_ACTIVITIES)
//            return true
//        }catch (PackageManager.NameNotFound){
//
//        }
//        return false
//    }
        addAddBtn.setOnClickListener{
            writeData()
        }

    }

    // TODO implement DATABASE functionality
    private fun writeData(){
        val placeName = findViewById<TextView>(R.id.et_place_name).text.toString()
        val placeLocation = findViewById<TextView>(R.id.et_place_location).text.toString()
        val dateOfTravel = findViewById<TextView>(R.id.et_place_date).text.toString()

        // check that fields are not empty
        if(placeName.isNotEmpty() && placeLocation.isNotEmpty() && dateOfTravel.isNotEmpty()){
            val travelMemory : TravelMemories = TravelMemories(null, )
        }


    }
    private fun readData(){}

    fun getTravelMemory(): List<TravelMemories> {
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


}