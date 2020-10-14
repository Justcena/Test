package com.testapp.testapplication.repositories

import androidx.lifecycle.LiveData
import com.testapp.testapplication.constants.Resource
import com.testapp.testapplication.data.local.ShoppingDao
import com.testapp.testapplication.data.local.ShoppingItem
import com.testapp.testapplication.data.remote.PixabayApi
import com.testapp.testapplication.data.remote.responses.ImageResponse
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayApi: PixabayApi
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) =
        shoppingDao.insertShoppingItem(shoppingItem)

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) =
        shoppingDao.deleteShoppingItem(shoppingItem)

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> =
        shoppingDao.observeAllShoppingItem()

    override fun observeTotalPrice(): LiveData<Float> = shoppingDao.observeTotalPrice()

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayApi.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("", null)
            } else {
                Resource.error("", null)
            }
        } catch (e: Exception) {
            Resource.error("d", null)
        }
    }

}