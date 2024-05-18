package com.example.foodapp.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int, // 309
    @SerializedName("cheap")
    val cheap: Boolean, // false
    @SerializedName("dairyFree")
    val dairyFree: Boolean, // true
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>,
    @SerializedName("glutenFree")
    val glutenFree: Boolean, // true
    @SerializedName("id")
    val id: Int, // 782585
    @SerializedName("image")
    val image: String, // https://img.spoonacular.com/recipes/782585-312x231.jpg
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int, // 45
    @SerializedName("sourceName")
    val sourceName: String, // blogspot.com
    @SerializedName("sourceUrl")
    val sourceUrl: String, // http://foodandspice.blogspot.com/2016/05/cannellini-bean-and-asparagus-salad.html
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String, // Cannellini Bean and Asparagus Salad with Mushrooms
    @SerializedName("vegan")
    val vegan: Boolean, // true
    @SerializedName("vegetarian")
    val vegetarian: Boolean, // true
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean, // true
)