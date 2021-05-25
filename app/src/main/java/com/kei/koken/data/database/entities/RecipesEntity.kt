package com.kei.koken.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kei.koken.models.FoodRecipe
import com.kei.koken.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
