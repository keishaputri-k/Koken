package com.kei.koken

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.kei.koken.view.ProfileFragment
import com.kei.koken.view.home.HomeFragment
import com.kei.koken.view.SavedFragment
import com.kei.koken.view.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        fun getLaunchService (from: Context) = Intent(from, MainActivity::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        addFragment(HomeFragment.newInstance())
        bottom_navigation.show(0)
        bottom_navigation.add(MeowBottomNavigation.Model(0,
            R.drawable.ic_home
        ))
        bottom_navigation.add(MeowBottomNavigation.Model(1,
            R.drawable.ic_search
        ))
        bottom_navigation.add(MeowBottomNavigation.Model(2,
            R.drawable.ic_saved
        ))
        bottom_navigation.add(MeowBottomNavigation.Model(3,
            R.drawable.ic_profile
        ))

        bottom_navigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    Toast.makeText(this@MainActivity, "Home Fragment", Toast.LENGTH_SHORT).show()
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    Toast.makeText(this@MainActivity, "Search Fragment", Toast.LENGTH_SHORT).show()
                    replaceFragment(SearchFragment.newInstance())
                }
                2 -> {
                    Toast.makeText(this@MainActivity, "Saved Fragment", Toast.LENGTH_SHORT).show()
                    replaceFragment(SavedFragment.newInstance())
                }
                3 -> {
                    Toast.makeText(this@MainActivity, "Profile Fragment", Toast.LENGTH_SHORT).show()
                    replaceFragment(ProfileFragment.newInstance())
                }
                else -> {
                    Toast.makeText(this@MainActivity, "Profile Fragment", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fragment_container, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment_container, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}


