package com.ysy.wcdbroomx

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Upsert

@Database(
    version = 1,
    entities = [Test::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "db_name"
        ).openHelperFactory(
            WCDBRoomX.createOpenHelperFactory("db_password".toByteArray())
        ).allowMainThreadQueries().build()
    }
}

@Entity
data class Test(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L
)

@Dao
interface TestDao {

    @Upsert
    suspend fun upsert(vararg test: Test): LongArray
}
