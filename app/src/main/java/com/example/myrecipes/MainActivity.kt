package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.example.myrecipes.databinding.ActivityMainBinding
import com.example.myrecipes.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val buttonFullRecipe: ImageView by lazy { binding.recipe1Ibtn }
//    private val buttonFilters: ImageView by lazy { binding.filtersIbtn }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("This is log for on Create")


        supportFragmentManager.beginTransaction()
            .replace(R.id.container,SearchFragment())
            .addToBackStack(SearchFragment::class.java.canonicalName)
            .commit()

//        val navView: BottomNavigationView = binding.naviView
//
//        val listener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.search_fragment1 -> {
//                    true
//                }
//                R.id.my_recipes_fragment2 -> {
//                    true
//                }
//                R.id.profile_fragment3 -> {
//                    true
//                }
//                else -> false
//            }
//
//        }
//        navView.setOnNavigationItemSelectedListener(listener)

//        buttonFullRecipe.setOnClickListener {
//            val intent = Intent(this, FullRecipeActivity::class.java)
//            startActivity(intent)
//        }
//
//        buttonFilters.setOnClickListener {
//            val intent = Intent(this, FilterActivity::class.java)
//            startActivity(intent)
//        }
    }
}