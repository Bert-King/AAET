package com.bert.aaet.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bert.aaet.R

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
