/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.specs;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pt.simdea.gmlrva.lib.decoration.GenericItemDecoration;
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition;

/**
 * Class responsible for defining a {@link RecyclerView.ItemDecoration}.
 * See {@link GenericItemDecoration} for more information.
 *
 * This class employs Builder Pattern, meaning this class contains all the required fields.
 * It's constructor receives all the required parameters. All optional parameters can be set via this class.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
@ToString
@EqualsAndHashCode
public final class SimpleDividerItemDecorationSpec implements ItemDecorationSpec, Serializable {

    /** This ItemDecoration's top spacing value */
    @Getter
    private final int mTopSpacing;

    /** This ItemDecoration's bottom spacing value */
    @Getter
    private final int mBottomSpacing;

    /** This ItemDecoration's start spacing value */
    @Getter
    private final int mStartSpacing;

    /** This ItemDecoration's end spacing value */
    @Getter
    private final int mEndSpacing;

    /** This ItemDecoration's divider position value {@link GenericDecorationDividerPosition} */
    @Getter
    private final int mDividerPosition;

    /** This ItemDecoration's divider resource */
    @Nullable
    @Getter
    private final Drawable mDivider;

    /** This ItemDecoration's divider {@link Paint} resource */
    @Nullable
    @Getter
    private final Paint mDrawnDivider;

    /**
     * Instantiates a new SimpleDividerItemDecorationSpec.
     * Private to prevent instantiation.
     * @param builder the builder object responsible for harboring
     *                all the required fields of a {@link SimpleDividerItemDecorationSpec}.
     */
    SimpleDividerItemDecorationSpec(@NonNull final DecorationSpecBuilder builder) {
        mDividerPosition = builder.mDividerPosition;
        mDivider = builder.mDivider;
        mDrawnDivider = builder.mDrawnDivider;

        mTopSpacing = builder.mTopSpacing;
        mBottomSpacing = builder.mBottomSpacing;
        mStartSpacing = builder.mStartSpacing;
        mEndSpacing = builder.mEndSpacing;
    }

    /**
     * SimpleDividerItemDecorationSpec builder class responsible for harboring
     * all the required fields of a {@link SimpleDividerItemDecorationSpec}.
     */
    @SuppressWarnings("unused")
    @NoArgsConstructor
    public static final class DecorationSpecBuilder {

        @Nullable
        private Drawable mDivider;
        @Nullable
        private Paint mDrawnDivider;

        private int mTopSpacing;
        private int mBottomSpacing;
        private int mStartSpacing;
        private int mEndSpacing;
        private int mDividerPosition;

        /**
         * Procedure meant to set the value for {@link #mDrawnDivider} optional parameter.
         * @param color the divider's target {@link Color} value.
         *              See {@link Paint#setColor(int)} for more information.
         * @param thickness the divider's target line thickness value. This value must be greater or equal than 0.
         *                  See {@link Paint#setStrokeWidth(float)} for more information.
         * @param style the divider's target {@link Paint.Style}.
         *              See {@link Paint#setStyle(Paint.Style)} for more information.
         * @param pathEffect the divider's target {@link PathEffect}.
         *                   See {@link Paint#setPathEffect(PathEffect)} for more information.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withDrawnDivider(@ColorInt int color,
                                                      @FloatRange(from = 0, fromInclusive = false) float thickness,
                                                      @Nullable final Paint.Style style,
                                                      @Nullable final PathEffect pathEffect) {
            mDrawnDivider = new Paint();
            mDrawnDivider.setColor(color);
            mDrawnDivider.setStrokeWidth(thickness);
            if (style != null) {
                mDrawnDivider.setStyle(style);
            }
            if (pathEffect != null) {
                mDrawnDivider.setPathEffect(pathEffect);
            }
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mDivider} optional parameter.
         * @param divider the divider's target {@link Drawable} value.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withDrawableDivider(@Nullable final Drawable divider) {
            mDivider = divider;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mDividerPosition} optional parameter.
         * @param dividerPosition the divider's target position value. This value is ranged.
         *                        See {@link GenericDecorationDividerPosition} for more information.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withDividerPosition(@IntRange(from = 0, to = 5) final int dividerPosition) {
            mDividerPosition = dividerPosition;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mTopSpacing} optional parameter.
         * @param topSpacing the {@link RecyclerView}'s outer top spacing value.
         *                   This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withTopSpacing(@IntRange(from = 0) final int topSpacing) {
            mTopSpacing = topSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mBottomSpacing} optional parameter.
         * @param bottomSpacing the {@link RecyclerView}'s outer bottom spacing value.
         *                      This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withBottomSpacing(@IntRange(from = 0) final int bottomSpacing) {
            mBottomSpacing = bottomSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mStartSpacing} optional parameter.
         * @param startSpacing the {@link RecyclerView}'s outer start / left spacing value.
         *                     This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withStartSpacing(@IntRange(from = 0) final int startSpacing) {
            mStartSpacing = startSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mEndSpacing} optional parameter.
         * @param endSpacing the {@link RecyclerView}'s outer end / right spacing value.
         *                   This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        @NonNull
        public DecorationSpecBuilder withEndSpacing(@IntRange(from = 0) final int endSpacing) {
            mEndSpacing = endSpacing;
            return this;
        }

        /**
         * Procedure meant to return the desired {@link SimpleDividerItemDecorationSpec}.
         * @return the built SimpleDividerItemDecorationSpec instance.
         */
        @NonNull
        public SimpleDividerItemDecorationSpec buildDecorationSpec() {
            return new SimpleDividerItemDecorationSpec(this);
        }

    }

}
