package com.bert.aaet.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bert.aaet.R
import com.bert.aaet.data.player.PlayerLevel

/**
 *
 * @Author: bertking
 * @ProjectName: aaet
 * @CreateAt: 2021/1/4 2:06 PM
 * @UpdateAt: 2021/1/4 2:06 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Description:
 */
@BindingAdapter("app:genderIcon")
fun genderIcon(view: ImageView, gender: Boolean) {
    view.setImageDrawable(getGenderDrawable(gender, view.context))
}

private fun getGenderDrawable(gender: Boolean, context: Context): Drawable? {
    return if (gender) {
        ContextCompat.getDrawable(context, R.mipmap.ic_male)
    } else {
        ContextCompat.getDrawable(context, R.mipmap.ic_female)

    }
}


@BindingAdapter("app:levelText")
fun levelText(view: TextView, level: PlayerLevel) {
    view.text = getLevelText(level,view.context)
}

private fun getLevelText(level: PlayerLevel, context: Context): String {
    return when (level) {
        PlayerLevel.THE_HEROIC_BRONZE -> {
            context.getString(R.string.heroic_bronze)
        }

        PlayerLevel.UNYIELDING_SILVER -> {
            context.getString(R.string.unyielding_silver)
        }

        PlayerLevel.THE_GLORY_OF_THE_GOLD -> {
            context.getString(R.string.glory_of_the_gold)
        }

        PlayerLevel.LUXURIOUS_PLATINUM -> {
            context.getString(R.string.luxurious_platinum)

        }

        PlayerLevel.MASTER_CHALLENGER -> {
            context.getString(R.string.master_challenger)
        }

        else -> {
            context.getString(R.string.strongest_king)
        }
    }
}

