package com.example.myrecipes.ui.myRecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myrecipes.FakeFoodRepository
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.example.myrecipes.RecipeAdapter
import com.example.myrecipes.databinding.FragmentFavoriteBinding
import timber.log.Timber

class FavoriteFragment : Fragment() {

    private lateinit var binding:FragmentFavoriteBinding
    private var fakeFoodRepository = FakeFoodRepository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        val root:View=binding.root

        val recipesRecycleView = binding.recipesRv
        recipesRecycleView.layoutManager= LinearLayoutManager(activity)

        val  recipes = fakeFoodRepository.returnAllRecipes()

        recipesRecycleView.adapter=RecipeAdapter(recipes) //он уже зашит, как отсюда убрать?
        return root
    }


}