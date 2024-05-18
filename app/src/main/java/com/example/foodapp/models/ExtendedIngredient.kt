package com.example.foodapp.models


import com.google.gson.annotations.SerializedName

data class ExtendedIngredient(

    @SerializedName("amount")
    val amount: Double, // 3.75
    @SerializedName("consistency")
    val consistency: String, // SOLID
    @SerializedName("image")
    val image: String, // dry-cannellini-beans.jpg
    @SerializedName("name")
    val name: String, // cannellini beans
    @SerializedName("original")
    val original: String, // 1 1/4 cups dried cannellini (white kidney) beans (3 3/4 cups cooked)
    @SerializedName("unit")
    val unit: String // cups
)