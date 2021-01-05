package com.bert.aaet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * ConstraintLayout的Barrier使用
 *
 * Barrier是一个虚拟视图，主要功能在于其可以对多个View设置约束。
 *
 * Barrier 方便我们在不需要额外创建容器的情况下，约束多个View。
 *
 * 主要有两个属性：
 *  app:barrierDirection="end" 用于指定约束方向
 *  app:constraint_referenced_ids="tv_title,tv_subtitle" 用于指向约束View的ID。多个View用逗号(,)分开
 *
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
    }
}