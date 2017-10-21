/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Item View Animation Finish Interface.
 *
 * This specification works similarly to a Criteria scheme, where we define how our {@link RecyclerView} item's
 * {@link RecyclerView.ViewHolder} reports if the animation is finished or not.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public interface IAnimationFinished {

    /**
     * Procedure meant to handle the report when the animation for the {@link RecyclerView.ViewHolder} has finished.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param animationFinishedOperation an Integer value representing the animation operation that has finished.
     *                                   See {@link GenericAnimationFinishedOperation} for more details.
     */
    void onAnimationFinished(@NonNull final RecyclerView.ViewHolder holder,
                             @IntRange(from = 0) final int animationFinishedOperation);

}
