/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers

import android.animation.AnimatorSet
import androidx.recyclerview.widget.RecyclerView

import pt.simdea.gmlrva.lib.animation.GenericItemAnimator

/**
 * Animated RecyclerView ViewHolder Specification Interface.
 *
 * This specification works similarly to a Criteria scheme, where we define how our RecyclerView ViewHolder
 * animations work.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
interface IAnimatedViewHolder {

    /**
     * Procedure meant to handle addition/entry animations for the RecyclerView ViewHolder.
     * @param listener the [GenericItemAnimator] instance orchestrating the animations.
     */
    fun runAddAnimation(listener: GenericItemAnimator)

    /**
     * Procedure meant to handle removal/exit animations for the RecyclerView ViewHolder.
     * @param listener the [GenericItemAnimator] instance orchestrating the animations.
     */
    fun runRemoveAnimation(listener: GenericItemAnimator)

    /**
     * Procedure meant to handle change animations for the RecyclerView ViewHolder.
     * @param listener the [GenericItemAnimator] instance orchestrating the animations.
     * @return the resulting [AnimatorSet] for the [RecyclerView] item's [RecyclerView.ViewHolder].
     */
    fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet?

}
