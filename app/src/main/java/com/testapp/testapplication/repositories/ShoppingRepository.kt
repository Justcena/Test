package com.testapp.testapplication.repositories

import androidx.lifecycle.LiveData
import com.testapp.testapplication.other.Resource
import com.testapp.testapplication.data.local.ShoppingItem
import com.testapp.testapplication.data.remote.responses.ImageResponse

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>


}