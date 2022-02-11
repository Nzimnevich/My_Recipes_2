package com.example.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.annotation.Nullable
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.myrecipes.databinding.FragmentCustomBottomSheetBinding
import com.example.myrecipes.ui.search.FilterHolder
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class CustomBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCustomBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomBottomSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val applyBtn = binding.applyBtn
        applyBtn.setOnClickListener {
            this.dismiss()
        }


        val data = FilterHolder()

        val chipGroup: ChipGroup = binding.meals1Cg
        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip = chipGroup.findViewById(checkedId)
            data.selectedMeals = chip.text.toString()
           //  setFragmentResult("filterChanged", bundleOf("bundleKey" to data))
        }

        val chipGroupDCG: ChipGroup = binding.dishes1Cg
        chipGroupDCG.setOnCheckedChangeListener { group, checkedId ->
            val chip1: Chip = chipGroupDCG.findViewById(checkedId)
            data.selectedDish = chip1.text.toString()
             setFragmentResult("filterChanged", bundleOf("bundleKey" to data))//если оставить тут, то ничего не приезжает

        }

        val countOfMeals = binding.countOfMealsSb
        data.selectedCountOfMeals = countOfMeals.progress


        val timeToCook = binding.timeToCookSb
        data.selectedTimeToCook = timeToCook.progress

        val timeToCookValueTV = binding.timeToCookValueTv

        timeToCook.setOnSeekBarChangeListener(object :OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                timeToCookValueTV.text= progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })


            val calories = binding.caloriesSb
        data.selectedCountOfCalories = calories.progress

        val rating = binding.ratingSb
        data.selectedRating = rating.progress.toFloat()



     //   setFragmentResult("filterChanged", bundleOf("bundleKey" to data)) //если оставить тут, то приезжает дефолтно 2 рецепта

        return root
    }


    companion object {
        fun newInstance(): CustomBottomSheetFragment {
            return CustomBottomSheetFragment()
        }
    }

}