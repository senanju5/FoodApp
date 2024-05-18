package com.example.foodapp.data

import com.example.foodapp.data.network.FoodRecipeApi
import com.example.foodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val foodRecipeApi: FoodRecipeApi
) {

    suspend fun getRecipe (queries:Map<String, String>):Response<FoodRecipe>{
      return foodRecipeApi.getRecipe(queries)
    }
}