/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers

import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

/**
 * Item View Animation Finish Interface.
 *
 * This specification works similarly to a Criteria scheme, where we define how our [RecyclerView] item's
 * [RecyclerView.ViewHolder] reports if the animation is finished or not.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
interface IAnimationFinished {

    /**
     * Procedure meant to handle the report when the animation for the [RecyclerView.ViewHolder] has finished.
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @param animationFinishedOperation an Integer value representing the animation operation that has finished.
     * See [GenericAnimationFinishedOperation] for more details.
     */
    fun onAnimationFinished(holder: RecyclerView.ViewHolder,
                            @IntRange(from = 0) animationFinishedOperation: Int)

}
