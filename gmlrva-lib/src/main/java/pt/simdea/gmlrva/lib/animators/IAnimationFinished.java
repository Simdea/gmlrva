/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animators;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public interface IAnimationFinished {

    /**
     * TODO!
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param animationFinishedOperation TODO...
     */
    void onAnimationFinished(@NonNull final RecyclerView.ViewHolder holder,
                             @IntRange(from = 0) final int animationFinishedOperation);

}
