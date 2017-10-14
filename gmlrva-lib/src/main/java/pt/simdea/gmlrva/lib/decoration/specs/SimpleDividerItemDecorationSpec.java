/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.specs;

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
 * TODO...
 *
 * This class employs Builder Pattern, meaning this class contains all the required fields.
 * It's constructor receives all the required parameters. All optional parameters can be set via this class.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@ToString @EqualsAndHashCode public class SimpleDividerItemDecorationSpec implements Serializable {

    /** This ItemDecoration's top spacing value */
    @Getter private int mTopSpacing = 0;

    /** This ItemDecoration's bottom spacing value */
    @Getter private int mBottomSpacing = 0;

    /** This ItemDecoration's start spacing value */
    @Getter private int mStartSpacing = 0;

    /** This ItemDecoration's end spacing value */
    @Getter private int mEndSpacing = 0;

    /** This ItemDecoration's divider position value {@link GenericDecorationDividerPosition} */
    @Getter private int mDividerPosition = 1; // bottom, by default

    /** This ItemDecoration's divider resource */
    @Nullable @Getter private Drawable mDivider;

    /** This ItemDecoration's divider {@link Paint} resource */
    @Nullable @Getter private Paint mDrawnDivider;

    private SimpleDividerItemDecorationSpec(@NonNull final DecorationSpecBuilder builder) {
        mDividerPosition = builder.mDividerPosition;
        mDivider = builder.mDivider;
        mDrawnDivider = builder.mDrawnDivider;

        mTopSpacing = builder.mTopSpacing;
        mBottomSpacing = builder.mBottomSpacing;
        mStartSpacing = builder.mStartSpacing;
        mEndSpacing = builder.mEndSpacing;
    }

    /** SimpleDividerItemDecorationSpec builder class responsible for harboring all the required fields of a {@link SimpleDividerItemDecorationSpec}. */
    @SuppressWarnings("unused") @NoArgsConstructor public static class DecorationSpecBuilder {

        @Nullable private Drawable mDivider;
        @Nullable private Paint mDrawnDivider;

        private int mTopSpacing;
        private int mBottomSpacing;
        private int mStartSpacing;
        private int mEndSpacing;
        private int mDividerPosition;

        /**
         * Procedure meant to TODO...
         * @param color TODO...
         * @param thickness TODO...
         * @return TODO...
         */
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
         * Procedure meant to TODO...
         * @param divider TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withDrawableDivider(@Nullable final Drawable divider) {
            mDivider = divider;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mDividerPosition} optional parameter.
         * @param dividerPosition {@link GenericDecorationDividerPosition} TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withDividerPosition(@IntRange(from = 0, to = 5) final int dividerPosition) {
            mDividerPosition = dividerPosition;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mTopSpacing} optional parameter.
         * @param topSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withTopSpacing(@IntRange(from = 0) final int topSpacing) {
            mTopSpacing = topSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mBottomSpacing} optional parameter.
         * @param bottomSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withBottomSpacing(@IntRange(from = 0) final int bottomSpacing) {
            mBottomSpacing = bottomSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mStartSpacing} optional parameter.
         * @param startSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withStartSpacing(@IntRange(from = 0) final int startSpacing) {
            mStartSpacing = startSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mEndSpacing} optional parameter.
         * @param endSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withEndSpacing(@IntRange(from = 0) final int endSpacing) {
            mEndSpacing = endSpacing;
            return this;
        }

        /**
         * Procedure meant to return the desired {@link SimpleDividerItemDecorationSpec}
         * @return the built SimpleDividerItemDecorationSpec instance.
         */
        public SimpleDividerItemDecorationSpec buildDecorationSpec() {
            isValidDecorationSpecData(); // TODO
            return new SimpleDividerItemDecorationSpec(this);
        }

        /** Procedure meant to execute basic validation checks on this SimpleDividerItemDecorationSpec's data */
        private boolean isValidDecorationSpecData() {
            /* TODO: Do some basic validations to check */
            return true;
        }

    }

}
