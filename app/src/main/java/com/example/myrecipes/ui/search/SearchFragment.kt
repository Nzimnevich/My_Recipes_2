package com.example.myrecipes.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes.FakeFoodRepository
import com.example.myrecipes.FullRecipeActivity
import com.example.myrecipes.RecipeAdapter
import com.example.myrecipes.databinding.SearchFragmentBinding
import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Meals
import com.example.myrecipes.ui.CustomBottomSheetFragment
import java.io.Serializable

class SearchFragment : Fragment() {

    private lateinit var viewModel: SearchViewModel
    private var _binding: SearchFragmentBinding? = null
    //private val buttonFullRecipe: ImageView by lazy { binding.recipe1Ibtn }
    private var fakeFoodRepository = FakeFoodRepository()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val filtersIbtn: ImageView = binding.filtersIbtn
        val buttonFullRecipe=binding.recipe1Ibtn

        filtersIbtn.setOnClickListener {
            val addPhotoBottomFragmentFragment: CustomBottomSheetFragment =
                CustomBottomSheetFragment.newInstance()

            addPhotoBottomFragmentFragment.show(
                childFragmentManager,
                "add_photo_dialog_fragment"
            )
        }

        val recipesRecycleView = binding.recipesRv
        recipesRecycleView.layoutManager= LinearLayoutManager(activity)

        val  recipes = fakeFoodRepository.returnAllRecipes()
        recipesRecycleView.adapter= RecipeAdapter(recipes) //он уже зашит, как отсюда убрать?



        // We set the listener on the child fragmentManager
        childFragmentManager.setFragmentResultListener(
            "filterChanged",
            viewLifecycleOwner
        ) { key, bundle ->
            val result: FilterHolder =
                bundle.getSerializable("bundleKey") as FilterHolder
            val  recipes = fakeFoodRepository.sortRecipe(result)
            recipesRecycleView.adapter= RecipeAdapter(recipes)


        }

        buttonFullRecipe.setOnClickListener {
            val intent = Intent(context, FullRecipeActivity::class.java)
            intent.putExtra("ID", 1)
            startActivity(intent)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}


class FilterHolder(

    var selectedMeals: String =Meals.BREAKFAST.toString(),
    var selectedDish:String = Dishes.DESSERT.toString(),
    var selectedCountOfMeals: Int =1,
    var selectedTimeToCook:Int=15,
    var selectedCountOfCalories:Int=100,
    var selectedRating:Float=3f

) : Serializable