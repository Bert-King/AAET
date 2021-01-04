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