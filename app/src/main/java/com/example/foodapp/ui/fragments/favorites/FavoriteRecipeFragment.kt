package com.example.foodapp.ui.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteRecipeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

      return inflater.inflate(R.layout.fragment_favorite_recipe, container, false)
    }
}