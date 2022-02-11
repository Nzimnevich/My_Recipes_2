package com.example.myrecipes.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.example.myrecipes.MainActivity
import com.example.myrecipes.databinding.FragmentCustomBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


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
            val intent = Intent(context, MainActivity::class.java)
            this.dismiss()
            startActivity(intent)

        }

        return root
    }


    companion object {
        fun newInstance(): CustomBottomSheetFragment {
            return CustomBottomSheetFragment()
        }
    }

}