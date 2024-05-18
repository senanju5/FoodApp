package com.example.foodapp.usercase

import com.example.foodapp.data.Repository
import com.example.foodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject


class RecipeUsecase @Inject constructor(private val repository: Repository,
) {
    suspend fun getRecipe(queries: Map<String, String>): Response<FoodRecipe> {
       return repository.remote.getRecipe(queries)
    }

}