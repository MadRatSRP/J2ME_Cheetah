package com.madrat.j2me_cheetah.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.interfaces.AppMVP
import com.madrat.j2me_cheetah.presenter.AppPresenter

class AppActivity : AppCompatActivity(), AppMVP.View {
    private var presenter: AppPresenter? = null
    private var drawerLayout: DrawerLayout? = null
    private var customViewContainer: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        setupMVP()
        setupActivity()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setupMVP() {
        presenter = AppPresenter(this)
    }
    override fun setupActivity() {
        val actionBar: ActionBar? = supportActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        val navController = Navigation.findNavController(this, R.id.navHostFragment)

        drawerLayout = findViewById(R.id.drawerLayout)

        customViewContainer = findViewById(R.id.activityCustomViewContainer)

        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        setSupportActionBar(toolbar)

        NavigationUI.setupWithNavController(navigationView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }
    override fun addCustomViewForToolbar(customView: View) {
        customViewContainer?.addView(customView)
    }
    override fun removeCustomViewFromToolbar(customView: View) {
        customViewContainer?.removeView(customView)
    }
}
