package com.kei.koken.data.network

import com.kei.koken.models.FoodRecipe
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    //cek structure Gson
    //pastiin Npiont

//    @GET("/recipes")
//    suspend fun getRecipes(
//        @Query("random") apiKey: String?
//    ): Call<FoodRecipe>

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>

    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(
        @QueryMap searchQuery: Map<String, String>
    ): Response<FoodRecipe>
}