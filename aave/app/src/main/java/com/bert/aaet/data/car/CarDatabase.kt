package com.bert.aaet.data.car

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/8 3:51 PM
 * @UpdateAt: 2021/1/8 3:51 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description: 构建Database
 *
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin#7
 *
 *  使用Room的第3步: 使用@Database创建数据库(Database)。
 */
@Database(entities = arrayOf(Car::class),version = 1,exportSchema = false)
public abstract class CarDatabase :RoomDatabase() {
    abstract fun carDao():CarDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CarDatabase? = null

        fun getDatabase(context: Context): CarDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarDatabase::class.java,
                    "car_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}