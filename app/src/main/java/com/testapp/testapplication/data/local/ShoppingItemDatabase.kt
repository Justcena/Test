package com.testapp.testapplication.data.local

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
class ShoppingItemDatabase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}