package com.bert.aaet.data.car

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/8 5:11 PM
 * @UpdateAt: 2021/1/8 5:11 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description:
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin#8
 *  使用Room的第4步(非必须项): 创建Repository负责访问数据。
 *  正如官网所言:
 *  The repository is not part of the Architecture Components libraries, but is a suggested best practice for code separation and architecture.
 *  Repository 不是架构组件库的一部分，但是一个代码分离&架构的建议最佳方案。
 */
class CarRepository(private val carDao: CarDao):ICarsDataSource {

    private val processors = Runtime.getRuntime().availableProcessors()

    /**
     * 暂时先用线程池处理数据库的一些操作(TODO 使用Kotlin协程）
     */
    private val executorService:ExecutorService = Executors.newFixedThreadPool(processors/2 + 1)


    override suspend fun getCarById(carId: Long): Car? {
        return executorService.runCatching { carDao.getCarById(carId) }.getOrNull()
    }

    override fun getAllCars(): List<Car> {
        return executorService.runCatching { carDao.getAllCars() }.getOrDefault(emptyList())
    }

    override fun getCarsByBranch(branch: String): List<Car> {
        return executorService.runCatching { carDao.getCarsByBranch(branch) }.getOrDefault(emptyList())
    }

    override fun getCarsByEngineType(engineType: Int): List<Car> {
        return executorService.runCatching { carDao.getCarsByEngineType(engineType) }.getOrDefault(emptyList())
    }

    override fun getCarsByEngineType(classify: String): List<Car> {
        return executorService.runCatching { carDao.getCarsByEngineType(classify) }.getOrDefault(emptyList())
    }

    override fun getCarsByBranchAndEngine(engineType: Int, branch: String): List<Car> {
        return executorService.runCatching { carDao.getCarsByBranchAndEngine(engineType,branch) }.getOrDefault(emptyList())
    }

    override fun insert(car: Car) {
        executorService.execute {
            carDao.insert(car)
        }
    }

    override fun deleteAllCars() {
        executorService.execute {
            carDao.deleteAllCars()
        }
    }

    override fun deleteCarById(id: Long) {
        executorService.execute {
            carDao.deleteCarById(id)
        }
    }

}