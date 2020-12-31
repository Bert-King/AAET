package com.bert.aaet.data

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
    private val name: String = "Test"
    private val score: Double = 0.0
    private val level: PlayerLevel = PlayerLevel.THE_HEROIC_BRONZE


    fun getLevel(score: Double): PlayerLevel {
        return when (score) {
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