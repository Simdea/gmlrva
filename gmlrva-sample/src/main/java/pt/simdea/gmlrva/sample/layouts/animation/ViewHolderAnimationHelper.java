/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;
import pt.simdea.gmlrva.lib.utilities.ViewUtils;

import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED;

/**
 * Auxiliary class meant to handle the required animations for the {@link IGenericRecyclerViewLayout} applicable.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public final class ViewHolderAnimationHelper {

    /**
     * Instantiates a new ViewHolderAnimationHelper.
     * Private to prevent instantiation.
     */
    private ViewHolderAnimationHelper() {
        throw new AssertionError(GMLRVAConstants.ASSERTION_ERROR);  // Throw an exception if this *is* ever called
    }

    /**
     * Procedure meant to execute an addition/entry animation for the desired {@link RecyclerView.ViewHolder}.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param itemView the {@link RecyclerView.ViewHolder}'s root view.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     */
    public static void runTestAddAnimation(@NonNull final RecyclerView.ViewHolder holder, @NonNull final View itemView,
                                           @NonNull final GenericItemAnimator listener) {
        final int screenHeight = ViewUtils.Companion.getDeviceScreenHeight(itemView.getContext());
        itemView.setTranslationY(screenHeight);
        itemView.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(700)
                .setListener(new Animator.AnimatorListener() {

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationStart(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationEnd(@NonNull final Animator animation) {
                        listener.onAnimationFinished(holder, ADD_ANIMATION_FINISHED);
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationCancel(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationRepeat(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                }).start();
    }

    /**
     * Procedure meant to execute a removal/exit animation for the desired {@link RecyclerView.ViewHolder}.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param itemView the {@link RecyclerView.ViewHolder}'s root view.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     */
    public static void runTestRemoveAnimation(@NonNull final RecyclerView.ViewHolder holder,
                                              @NonNull final View itemView,
                                              @NonNull final GenericItemAnimator listener) {
        final int screenHeight = ViewUtils.Companion.getDeviceScreenHeight(itemView.getContext());
        itemView.setTranslationY(0);
        itemView.animate()
                .translationY(screenHeight)
                .setInterpolator(new AccelerateInterpolator(3.f))
                .setDuration(700)
                .setListener(new Animator.AnimatorListener() {

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationStart(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationEnd(@NonNull final Animator animation) {
                        listener.onAnimationFinished(holder, REMOVE_ANIMATION_FINISHED);
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationCancel(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    /** {@inheritDoc} */
                    @Override
                    public void onAnimationRepeat(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                }).start();
    }

    /**
     * Procedure meant to execute a change animation for the desired {@link RecyclerView.ViewHolder}.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param itemView the {@link RecyclerView.ViewHolder}'s root view.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     * @return the resulting {@link AnimatorSet} for the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     */
    public static AnimatorSet runTestChangeAnimation(@NonNull final RecyclerView.ViewHolder holder,
                                              @NonNull final View itemView,
                                              @NonNull final GenericItemAnimator listener) {
        final ObjectAnimator oldTextRotate = ObjectAnimator.ofFloat(itemView, View.ROTATION_X, 0, 90);
        final ObjectAnimator newTextRotate = ObjectAnimator.ofFloat(itemView, View.ROTATION_X, -90, 0);
        final AnimatorSet textAnim = new AnimatorSet();

        textAnim.addListener(new AnimatorListenerAdapter() {

            /** {@inheritDoc} */
            @Override
            public void onAnimationEnd(@NonNull final Animator animation) {
                listener.onAnimationFinished(holder, CHANGE_ANIMATION_FINISHED);
            }

        });

        textAnim.playSequentially(oldTextRotate, newTextRotate);
        return textAnim;
    }

}
