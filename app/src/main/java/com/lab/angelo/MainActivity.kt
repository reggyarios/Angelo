package com.lab.angelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lab.angelo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding the MainActivity.kt with activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        //binding with the bottom navigation
        binding.bottomNavView.setOnItemSelectedListener{

            //fragment layout option
            when (it.itemId) {
                R.id.home    -> replaceFragment(HomeFragment())
                R.id.payment -> replaceFragment(PaymentFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{}
            }
            true
        }
    }
    //declaring the fragment manager
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragmentTransaction.commit()
    }

}
