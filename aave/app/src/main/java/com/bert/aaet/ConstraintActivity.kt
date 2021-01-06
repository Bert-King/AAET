package com.bert.aaet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_constraint.*

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
 * ConstraintLayout的设置View元素自身的宽高比：
 * 1. app:layout_constraintDimensionRatio="W,16:6"
 * 2. app:layout_constraintDimensionRatio="H,16:6"
 *
 * ConstraintLayout的Group:
 * 使用ConstraintLayout的目的就是为了减少布局的层级关系，使每个View之间都是平级的关系。这样做在渲染层面确实能带来性能的提升。
 * 但是对于某些需求，让我们统一控制多个View的时候有些棘手。最常见的就是根据业务需要，控制多个View的Visibility。使用ConstraintLayout之后
 * 我们只能逐一对View进行setVisibility进行处理。难道ConstraintLayout这么Low吗？ Too young too simple...。
 * ConstraintLayout为我们提供了Group，让我们避免陷入如此的尴尬之地。
 *
 * (个人经验之谈，使用ConstraintLayout时尽量避免手写XML)
 *
 *
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        /**
         * 体会一下Group的威力
         */
        btn_percent?.setOnClickListener {
            when (style_group?.visibility) {
                View.GONE -> {
                    style_group?.visibility = View.VISIBLE
                }
                else -> {
                    style_group?.visibility = View.GONE
                }
            }
        }
    }
}