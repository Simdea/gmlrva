/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers;

import android.animation.AnimatorSet;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import pt.simdea.gmlrva.lib.animation.GenericItemAnimator;

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
public interface IAnimatedViewHolder {

    /**
     * Procedure meant to handle addition/entry animations for the RecyclerView ViewHolder.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     */
    void runAddAnimation(@NonNull final GenericItemAnimator listener);

    /**
     * Procedure meant to handle removal/exit animations for the RecyclerView ViewHolder.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     */
    void runRemoveAnimation(@NonNull final GenericItemAnimator listener);

    /**
     * Procedure meant to handle change animations for the RecyclerView ViewHolder.
     * @param listener the {@link GenericItemAnimator} instance orchestrating the animations.
     * @return the resulting {@link AnimatorSet} for the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     */
    @Nullable
    AnimatorSet runChangeAnimation(@NonNull final GenericItemAnimator listener);

}
