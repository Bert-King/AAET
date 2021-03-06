package com.bert.aaet.data.car

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/8 11:52 AM
 * @UpdateAt: 2021/1/8 11:52 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description: https://developer.android.com/codelabs/android-room-with-a-view-kotlin#4
 * 使用Room的第1步: 使用@Entity 创建 表。
 *
 */
@Entity(tableName = "car_table")
data class Car(val branch:String,
               val classify:String,// suv , mpv and so on.
               val engineType: Int,
               val carColor:String,
               val price:Double,
               val discountPrice:Double,
               val years:Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
