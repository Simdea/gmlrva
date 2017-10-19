/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pt.simdea.gmlrva.lib.decoration.specs.ItemDecorationSpec;

/**
 * This class is meant to apply any generic implementation of an {@link ItemDecorationSpec} to a {@link RecyclerView}.
 *
 * @param <T> an instance of {@link ItemDecorationSpec}.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public abstract class GenericItemDecoration<T extends ItemDecorationSpec> extends RecyclerView.ItemDecoration {

    /**
     * Instantiates a new GenericItemDecoration.
     * @param configurationSpec a valid {@link ItemDecorationSpec} containing this item decoration specification.
     */
    protected GenericItemDecoration(@NonNull final T configurationSpec) {
        super();
        applySpec(configurationSpec);
    }

    /** {@inheritDoc} */
    @Override
    public abstract void getItemOffsets(@NonNull final Rect outRect, @NonNull final View view,
                                        @NonNull final RecyclerView parent, @NonNull final RecyclerView.State state);

    /** {@inheritDoc} */
    @Override
    public abstract void onDrawOver(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                    @NonNull final RecyclerView.State state);

    /**
     * Procedure meant to apply a given {@link ItemDecorationSpec} to this item decoration.
     * @param configurationSpec the valid {@link ItemDecorationSpec} containing this item decoration specification.
     */
    protected abstract void applySpec(@NonNull final T configurationSpec);

}
