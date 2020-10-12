package com.testapp.testapplication.data.local

import androidx.lifecycle.LiveData

@Dao
interface ShoppingDao {

    @Insert(onConflict = onConflicStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)


    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)


    @Query("SELECT * FROM shopping_item")
    fun observeAllShoppingItem(): LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount") FROM shopping_item
    fun observeTotalPrice(): LiveData<Float>
}