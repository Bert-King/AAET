package com.bert.aaet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2020/12/31 5:05 PM
 * @UpdateAt: 2020/12/31 5:05 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description:
 *
 * 通过这里，我们可以知道：LiveData 和 MutableLiveData 只是作用范围不一样。
 * 在概念上来讲，两者是一样的
 * 1. MutableLiveData 继承自LiveData
 * 2. LiveData在实体类中可以通知指定某个字段的数据更新
 * 3. MutableLiveData 则是整个字段or数据类型变化后才通知，不会细化到某个字段。
 *
 * 简而言之：MutableLiveData 只有整体变化才进行通知，而LiveData更加敏感，有变化就会通知。
 *
 */
class PlayerViewModel : ViewModel() {
    private val _name = MutableLiveData<String>("Test")
    private val _nickName = MutableLiveData<String>("电脑玩家")
    private val _gender = MutableLiveData<Boolean>(true)
    private val _score = MutableLiveData<Double>(0.0)

    val name: LiveData<String> = _name
    val nickName: LiveData<String> = _nickName
    val gender:LiveData<Boolean> = _gender // true : Male ; false :Female
    val score:LiveData<Double> = _score




    fun updateScore() {
        _score.value = (_score.value ?: 0.0) + 10.0
    }

    val level: LiveData<PlayerLevel> = Transformations.map(_score) {
        when (it) {
            in 1.0..20.0 -> {
                PlayerLevel.THE_HEROIC_BRONZE
            }

            in 20.0..40.0 -> {
                PlayerLevel.UNYIELDING_SILVER
            }

            in 40.0..60.0 -> {
                PlayerLevel.THE_GLORY_OF_THE_GOLD
            }

            in 60.0..80.0 -> {
                PlayerLevel.LUXURIOUS_PLATINUM
            }

            in 80.0..100.0 -> {
                PlayerLevel.MASTER_CHALLENGER
            }

            else -> {
                PlayerLevel.THE_STRONGEST_KING
            }
        }
    }

}