package com.ooug.echo.activites

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ooug.echo.R
import com.ooug.echo.adapters.NavigationDrawerAdapter
import com.ooug.echo.fragments.MainScreenFragment

class MainActivity : AppCompatActivity(){

    var navigationdDrawerIconsList :ArrayList<String> = arrayListOf()
    var images_for_navdrawer = intArrayOf(R.drawable.navigation_allsongs,R.drawable.navigation_aboutus
            ,R.drawable.navigation_favorites,R.drawable.navigation_settings)
    object Statified{
        var drawerLayout: DrawerLayout?= null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        MainActivity.Statified.drawerLayout = findViewById(R.id.drawer_layout)

        navigationdDrawerIconsList.add("All Songs")
        navigationdDrawerIconsList.add("Favorites")
        navigationdDrawerIconsList.add("Settings")
        navigationdDrawerIconsList.add("About Us")

        val toggle = ActionBarDrawerToggle(this@MainActivity, MainActivity.Statified.drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        MainActivity.Statified.drawerLayout?.setDrawerListener(toggle)
        toggle.syncState()

        val mainScreenFragment = MainScreenFragment()
        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.details_fragment,mainScreenFragment,"MainScreenFragment")
                .commit()

        var _navigationAdapter = NavigationDrawerAdapter(navigationdDrawerIconsList,images_for_navdrawer,this)
        _navigationAdapter.notifyDataSetChanged()


        var navigation_recycler_view = findViewById<RecyclerView>(R.id.navigation_recycler_view)
        navigation_recycler_view.layoutManager = LinearLayoutManager(this)
        navigation_recycler_view.itemAnimator = DefaultItemAnimator()
        navigation_recycler_view.adapter = _navigationAdapter
        navigation_recycler_view.setHasFixedSize(true)

    }

    override fun onStart() {
        super.onStart()
    }
}
