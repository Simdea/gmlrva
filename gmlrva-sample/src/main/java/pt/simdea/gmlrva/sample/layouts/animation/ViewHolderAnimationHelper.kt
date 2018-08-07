/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.ADD_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.CHANGE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.REMOVE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstantsVars
import pt.simdea.gmlrva.lib.utilities.ViewUtils

/**
 * Auxiliary class meant to handle the required animations for the [IGenericRecyclerViewLayout] applicable.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class ViewHolderAnimationHelper
/**
 * Instantiates a new ViewHolderAnimationHelper.
 * Private to prevent instantiation.
 */
private constructor() {

    init {
        throw AssertionError(GMLRVAConstantsVars.ASSERTION_ERROR)  // Throw an exception if this *is* ever called
    }

    companion object {

        /**
         * Procedure meant to execute an addition/entry animation for the desired [RecyclerView.ViewHolder].
         * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
         * @param itemView the [RecyclerView.ViewHolder]'s root view.
         * @param listener the [GenericItemAnimator] instance orchestrating the animations.
         */
        fun runTestAddAnimation(holder: RecyclerView.ViewHolder, itemView: View,
                                listener: GenericItemAnimator) {
            val screenHeight = ViewUtils.getDeviceScreenHeight(itemView.context)
            itemView.translationY = screenHeight.toFloat()
            itemView.animate()
                    .translationY(0f)
                    .setInterpolator(DecelerateInterpolator(3f))
                    .setDuration(700)
                    .setListener(object : Animator.AnimatorListener {

                        /** {@inheritDoc}  */
                        override fun onAnimationStart(animation: Animator) {
                            /* Do nothing here */
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationEnd(animation: Animator) {
                            listener.onAnimationFinished(holder, ADD_ANIMATION_FINISHED)
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationCancel(animation: Animator) {
                            /* Do nothing here */
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationRepeat(animation: Animator) {
                            /* Do nothing here */
                        }

                    }).start()
        }

        /**
         * Procedure meant to execute a removal/exit animation for the desired [RecyclerView.ViewHolder].
         * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
         * @param itemView the [RecyclerView.ViewHolder]'s root view.
         * @param listener the [GenericItemAnimator] instance orchestrating the animations.
         */
        fun runTestRemoveAnimation(holder: RecyclerView.ViewHolder,
                                   itemView: View,
                                   listener: GenericItemAnimator) {
            val screenHeight = ViewUtils.getDeviceScreenHeight(itemView.context)
            itemView.translationY = 0f
            itemView.animate()
                    .translationY(screenHeight.toFloat())
                    .setInterpolator(AccelerateInterpolator(3f))
                    .setDuration(700)
                    .setListener(object : Animator.AnimatorListener {

                        /** {@inheritDoc}  */
                        override fun onAnimationStart(animation: Animator) {
                            /* Do nothing here */
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationEnd(animation: Animator) {
                            listener.onAnimationFinished(holder, REMOVE_ANIMATION_FINISHED)
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationCancel(animation: Animator) {
                            /* Do nothing here */
                        }

                        /** {@inheritDoc}  */
                        override fun onAnimationRepeat(animation: Animator) {
                            /* Do nothing here */
                        }

                    }).start()
        }

        /**
         * Procedure meant to execute a change animation for the desired [RecyclerView.ViewHolder].
         * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
         * @param itemView the [RecyclerView.ViewHolder]'s root view.
         * @param listener the [GenericItemAnimator] instance orchestrating the animations.
         * @return the resulting [AnimatorSet] for the [RecyclerView] item's [RecyclerView.ViewHolder].
         */
        fun runTestChangeAnimation(holder: RecyclerView.ViewHolder,
                                   itemView: View,
                                   listener: GenericItemAnimator): AnimatorSet {
            //val oldTextRotate = ObjectAnimator.ofFloat(itemView, View.ROTATION_X, 0, 90)
            //val newTextRotate = ObjectAnimator.ofFloat(itemView, View.ROTATION_X, -90, 0)
            val textAnim = AnimatorSet()

            textAnim.addListener(object : AnimatorListenerAdapter() {

                /** {@inheritDoc}  */
                override fun onAnimationEnd(animation: Animator) {
                    listener.onAnimationFinished(holder, CHANGE_ANIMATION_FINISHED)
                }

            })

            //textAnim.playSequentially(oldTextRotate, newTextRotate)
            return textAnim
        }
    }

}
