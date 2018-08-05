/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers;

import androidx.annotation.IntRange;
import androidx.recyclerview.widget.RecyclerView;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class is meant to serve as a base {@link RecyclerView.ItemAnimator.ItemHolderInfo}, that preserving the
 * necessary information about the ViewHolder that will be animated.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
public class GenericAnimatedViewHolderInfo extends RecyclerView.ItemAnimator.ItemHolderInfo {

    @Getter
    @IntRange (from = 0)
    private int mUpdateAction;

}
