package com.example.module2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.module2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //initialising action toggle bar globally
    lateinit var toggle:ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Module2)
        setContentView(binding.root)


        val drawerLayout = binding.drawerLayout
        val navView= binding.navView

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener{ it ->
            when (it.itemId){
                R.id.item1-> Intent(this,ItemActivity1::class.java).also{startActivity(it)}
                R.id.item2-> Intent(this,ItemActivity2::class.java).also{startActivity(it)}
                R.id.item3-> Intent(this,ItemActivity3::class.java).also{startActivity(it)}
            }
           true
        }
    }

    override fun onOptionsItemSelected(item:MenuItem):Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true

        }
        return super.onOptionsItemSelected(item)
    }

}