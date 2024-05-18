package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.RecipeRowLayoutBinding
import com.example.foodapp.models.FoodRecipe
import com.example.foodapp.models.Result
import com.example.foodapp.utils.RecipeDiffUtils

class RecipesAdapter: RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    private var recipeList = emptyList<Result>()
    class RecipeViewHolder(private val binding: RecipeRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup):RecipeViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeRowLayoutBinding.inflate(layoutInflater, parent, false)
                return RecipeViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipeList[position]
        holder.bind(currentRecipe)
    }

    fun setData (newData:FoodRecipe) {
        val recipeDiffUtils = RecipeDiffUtils(recipeList, newData.results)
        val diffUtilsResult = DiffUtil.calculateDiff(recipeDiffUtils)
        recipeList = newData.results
        diffUtilsResult.dispatchUpdatesTo(this)
    }
}