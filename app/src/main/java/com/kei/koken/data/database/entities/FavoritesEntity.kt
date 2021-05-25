package com.kei.koken.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kei.koken.models.Result
import com.kei.koken.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    //primary key dapat diartikan sebagai kolom yang berisi nilai unik,
    //berfungsi sebagai identitas untuk membedakan setiap record yang ada pada tabel.
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)