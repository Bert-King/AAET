package com.bert.aaet.data.car

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/8 3:10 PM
 * @UpdateAt: 2021/1/8 3:10 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description: DAO(data access object),you specify SQL queries and associate them with method calls.
 *
 *参考: https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
 *
 * 使用Room的第2步: 使用@Dao制定一些操作。
 */
@Dao
interface CarDao {

    @Query("SELECT * FROM car_table WHERE id = :carId")
    fun getCarById(carId: Long): Car?

    @Query("SELECT * FROM car_table ORDER BY branch ASC")
    fun getAllCars():List<Car>

    @Query("SELECT * FROM car_table WHERE branch = :branch")
    fun getCarsByBranch(branch:String):List<Car>

    @Query("SELECT * FROM car_table WHERE engineType = :engineType")
    fun getCarsByEngineType(engineType: Int):List<Car>

    @Query("SELECT * FROM car_table WHERE classify = :classify")
    fun getCarsByEngineType(classify: String):List<Car>

    @Query("SELECT * FROM car_table WHERE branch = :branch AND engineType =:engineType ")
    fun getCarsByBranchAndEngine(engineType: Int,branch: String):List<Car>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(car: Car)

    @Query("DELETE FROM car_table")
    fun deleteAllCars()

    @Query("DELETE FROM car_table WHERE id = :id")
    fun deleteCarById(id: Long)

}