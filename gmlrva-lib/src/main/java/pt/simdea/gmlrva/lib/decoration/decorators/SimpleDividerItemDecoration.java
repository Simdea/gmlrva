/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.decorators;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pt.simdea.gmlrva.lib.decoration.GenericItemDecoration;
import pt.simdea.gmlrva.lib.decoration.helpers.DecoratorDrawOverManager;
import pt.simdea.gmlrva.lib.decoration.specs.ItemDecorationSpec;
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec;

/**
 * This class is meant to apply both outer spacing and dividers to a {@link RecyclerView}.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public class SimpleDividerItemDecoration extends GenericItemDecoration<SimpleDividerItemDecorationSpec> {

    @NonNull
    private final DecoratorDrawOverManager mDrawOverManager = new DecoratorDrawOverManager();

    @IntRange(from = 0)
    private int mTopSpacing;
    @IntRange(from = 0)
    private int mBottomSpacing;
    @IntRange(from = 0)
    private int mStartSpacing;
    @IntRange(from = 0)
    private int mEndSpacing;
    @IntRange(from = 0, to = 5)
    private int mDividerPosition;

    @Nullable
    private Drawable mDivider;
    @Nullable
    private Paint mDrawnDivider;

    /**
     * Instantiates a new SimpleDividerItemDecoration.
     * @param configurationSpec a valid {@link ItemDecorationSpec} containing this item decoration specification.
     */
    public SimpleDividerItemDecoration(@NonNull final SimpleDividerItemDecorationSpec configurationSpec) {
        super(configurationSpec);
    }

    /** {@inheritDoc} */
    @Override
    public void getItemOffsets(@NonNull final Rect outRect, @NonNull final View view,
                               @NonNull final RecyclerView parent, @NonNull final RecyclerView.State state) {
        outRect.top = mTopSpacing;
        outRect.bottom = mBottomSpacing;
        outRect.left = mStartSpacing;
        outRect.right = mEndSpacing;
    }

    /** {@inheritDoc} */
    @Override
    public void onDrawOver(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                           @NonNull final RecyclerView.State state) {
        if (mDivider != null) {
            mDrawOverManager.applyDrawableDivider(canvas, parent, mDivider, mDividerPosition);
        } else if (mDrawnDivider != null) {
            mDrawOverManager.applyDrawnDivider(canvas, parent, state, mDrawnDivider, mDividerPosition);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void applySpec(@NonNull final SimpleDividerItemDecorationSpec configurationSpec) {
        /* Get Spacing Rules */
        mTopSpacing = configurationSpec.getTopSpacing();
        mBottomSpacing = configurationSpec.getBottomSpacing();
        mStartSpacing = configurationSpec.getStartSpacing();
        mEndSpacing = configurationSpec.getEndSpacing();

        /* Get Divider Rules */
        mDivider = configurationSpec.getDivider();
        mDividerPosition = configurationSpec.getDividerPosition();
        mDrawnDivider = configurationSpec.getDrawnDivider();
    }

}
