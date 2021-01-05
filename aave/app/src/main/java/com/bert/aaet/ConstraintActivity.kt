package com.bert.aaet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * ConstraintLayout的Barrier:
 *
 * Barrier是一个虚拟视图，主要功能在于其可以对多个View设置约束。
 *
 * Barrier 方便我们在不需要额外创建容器的情况下，约束多个View。
 *
 * 主要有两个属性：
 *  app:barrierDirection="end" 用于指定约束方向
 *  app:constraint_referenced_ids="tv_title,tv_subtitle" 用于指向约束View的ID。多个View用逗号(,)分开
 *
 *
 *  ConstraintLayout的Guideline:
 *
 *  Guideline是辅助布局的工具类，可视为『辅助线』，极大地减少了MarginX的出现。另外一个重要的作用是实现PercentLayout的效果。
 *  主要的属性有:
 *  1. android:orientation="vertical"
 *  2. app:layout_constraintGuide_start="200dp"
 *  3. app:layout_constraintGuide_end="200dp"
 *  4. app:layout_constraintGuide_percent="0.6"
 *
 *  Guideline不会显示到界面上(onDraw()没有具体实现)，其内部设置setVisibility(GONE)
 *
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
    }
}