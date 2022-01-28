package com.example.myrecipes.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myrecipes.FullRecipeActivity
import com.example.myrecipes.databinding.SearchFragmentBinding
import com.example.myrecipes.ui.CustomBottomSheetFragment

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: SearchFragmentBinding
    private val buttonFullRecipe: ImageView by lazy { binding.recipe1Ibtn }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val filtersIbtn: ImageView = binding.filtersIbtn

        filtersIbtn.setOnClickListener {
            val addPhotoBottomFragmentFragment: CustomBottomSheetFragment =
                CustomBottomSheetFragment.newInstance()

            addPhotoBottomFragmentFragment.show(
                childFragmentManager,
                "add_photo_dialog_fragment"
            )
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

}