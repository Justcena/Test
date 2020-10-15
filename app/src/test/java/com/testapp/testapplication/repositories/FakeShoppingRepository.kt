package com.testapp.testapplication.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.testapp.testapplication.other.Resource
import com.testapp.testapplication.data.local.ShoppingItem
import com.testapp.testapplication.data.remote.responses.ImageResponse

class FakeShoppingRepository : ShoppingRepository {

    private val shoppingItems = mutableListOf<ShoppingItem>()
    private val obseravableShoppingItem = MutableLiveData<List<ShoppingItem>>(shoppingItems)
    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) { shouldReturnNetworkError = value }

    private fun refreshLiveData() {
        obseravableShoppingItem.postValue(shoppingItems)
        observableTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float?=shoppingItems.sumByDouble { it.price.toDouble() }.toFloat()

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem){shoppingItems.add(shoppingItem)}

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {shoppingItems.remove(shoppingItem)}

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> =observeAllShoppingItems()

    override fun observeTotalPrice(): LiveData<Float> = observeTotalPrice()


    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(ImageResponse(listOf(),0,0))
        }
    }
}