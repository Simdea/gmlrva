/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec;

/**
 * TODO...
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public abstract class GenericItemDecoration extends RecyclerView.ItemDecoration {

    // TODO!
    protected GenericItemDecoration(@NonNull final SimpleDividerItemDecorationSpec configurationSpec) {
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

    // TODO!
    protected abstract void applySpec(@NonNull final SimpleDividerItemDecorationSpec configurationSpec);

}
