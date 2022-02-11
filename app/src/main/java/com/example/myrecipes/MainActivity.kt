package com.example.myrecipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myrecipes.databinding.ActivityMainBinding
import com.example.myrecipes.ui.myRecipes.FavoriteFragment
import com.example.myrecipes.ui.profile.ProfileFragment
import com.example.myrecipes.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("This is log for on Create")


        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchFragment())
            .addToBackStack(SearchFragment::class.java.canonicalName)
            .commit()

        val navView: BottomNavigationView = binding.navView

        val listener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search_fragment1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment())
                        .addToBackStack(SearchFragment::class.java.canonicalName)
                        .commit()
                    true
                }
                R.id.my_recipes_fragment2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, FavoriteFragment())
                        .addToBackStack(SearchFragment::class.java.canonicalName)
                        .commit()
                    true
                }
                R.id.profile_fragment3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .addToBackStack(SearchFragment::class.java.canonicalName)
                        .commit()
                    true
                }
                else -> false
            }

        }
        navView.setOnNavigationItemSelectedListener(listener)

    }
}