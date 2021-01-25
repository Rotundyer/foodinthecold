package ru.coffeestudio.foodinthecold.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.coffeestudio.food.db.dao.ProductDao
import ru.coffeestudio.foodinthecold.db.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: AppDB? = null

        fun getDB(context: Context): AppDB {
            val tempInstance = INSTANCE
            if(tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "store_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}