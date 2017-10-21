package pt.simdea.gmlrva.lib.animation;

import android.support.annotation.NonNull;

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

}
