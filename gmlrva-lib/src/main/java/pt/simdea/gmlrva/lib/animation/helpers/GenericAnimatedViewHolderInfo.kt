/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers

import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

/**
 * This class is meant to serve as a base [RecyclerView.ItemAnimator.ItemHolderInfo], that preserving the
 * necessary information about the ViewHolder that will be animated.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class GenericAnimatedViewHolderInfo(
        @IntRange(from = 0) internal val mUpdateAction: Int = 0
) : RecyclerView.ItemAnimator.ItemHolderInfo()
