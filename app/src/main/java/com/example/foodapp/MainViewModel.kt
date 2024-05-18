package com.example.foodapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.models.FoodRecipe
import com.example.foodapp.usecase.RecipeUsecase
import com.example.foodapp.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val recipeUsecase: RecipeUsecase,
    application: Application
) : AndroidViewModel(application) {
    var recipesResponse: MutableLiveData<NetworkResults<FoodRecipe>> = MutableLiveData()
    fun getRecipes(queries: Map<String, String>) = viewModelScope.launch {
        getRecipesSafeCall(queries)
    }

    private suspend fun getRecipesSafeCall(queries: Map<String, String>) {
        recipesResponse.value = NetworkResults.Loading()
        if (hasInternetConnection()) {
            try {
                val response = recipeUsecase.getRecipe(queries)
                recipesResponse.value = handleFoodRecipeResponse(response)!!
            } catch (e: Exception) {
                recipesResponse.value = NetworkResults.Error("Recipes Not Found")
            }
        } else {
            recipesResponse.value = NetworkResults.Error(" No Internet Connection")
        }
    }

    private fun handleFoodRecipeResponse(response: Response<FoodRecipe>): NetworkResults<FoodRecipe>? {

        when {
            response.message().contains("timeout") -> {
                return NetworkResults.Error("TimeOut")
            }

            response.code() == 402 -> {
                return NetworkResults.Error("Api key Limited")
            }

            response.body()!!.results.isEmpty() -> {
                return NetworkResults.Error("Recipes Not Found")
            }

            response.isSuccessful -> {
                val foodRecipe = response.body()
                return NetworkResults.Success(foodRecipe!!)
            }

            else -> {
                return NetworkResults.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}