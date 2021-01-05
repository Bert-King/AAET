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
 *
 *  ConstrainLayout的Chain: 这个Chain是从意识形态去理解的，这里我们可以参考DS中的双向链表。
 *  需要注意的是，每个子元素组成了整条Chain.而Chain的类型则是由这条View链的第一个元素来设置的。具体可以参考：activity_constraint.xml
 *
 *  链条共有2种类型：
 *  1. 横向：app:layout_constraintHorizontal_chainStyle
 *  2. 竖向：app:layout_constraintVertical_chainStyle
 *  而每种类型又可以细分为3中类型：
 *  1) spread (Default): 都分散
 *  2) spread-inside: Chain的两端固定，其它分散
 *  3) packed:集中到一起
 *
 *  PS: 想要使得Chain的类型生效，则每个元素的相互依赖都要设置。(这个最好熟练掌握拖拽之法为妙)
 *
 *
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
    }
}