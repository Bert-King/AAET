package com.bert.aaet.data.car


/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/8 5:58 PM
 * @UpdateAt: 2021/1/8 5:58 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description:
 */
interface ICarsDataSource {

    suspend fun getCarById(carId: Long): Car?

    fun getAllCars():List<Car>

    fun getCarsByBranch(branch:String):List<Car>

    fun getCarsByEngineType(engineType: EngineType):List<Car>

    fun getCarsByEngineType(classify: String):List<Car>

    fun getCarsByBranchAndEngine(engineType: EngineType,branch: String):List<Car>

    fun insert(car: Car)

    fun deleteAllCars()

    fun deleteCarById(id: Long)

}