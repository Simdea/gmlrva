/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.animators

import android.animation.AnimatorSet
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimatedViewHolderInfo
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder

/**
 * This class serves as an extension of RecyclerView's ItemAnimator.
 * For this use case, this animator acts as a test animator, that knows how to handle test custom animations.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class ExampleItemAnimator : GenericItemAnimator() {

    /** {@inheritDoc}  */
    override fun handleCustomAnimation(holderInfo: GenericAnimatedViewHolderInfo,
                                       holder: IAnimatedViewHolder): AnimatorSet? {
        when (holderInfo.getUpdateAction()) {
            0 -> return holder.runChangeAnimation(this)
            else -> throw UnsupportedOperationException(Companion.getUNSUPPORTED_ERROR())
        }
    }

}
