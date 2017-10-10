package pt.simdea.gmlrva.lib.decorators;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString @EqualsAndHashCode public class DecorationSpec implements Serializable {

    /** This ItemDecoration's top spacing value */
    @Getter private int mTopSpacing = 0;

    /** This ItemDecoration's bottom spacing value */
    @Getter private int mBottomSpacing = 0;

    /** This ItemDecoration's start spacing value */
    @Getter private int mStartSpacing = 0;

    /** This ItemDecoration's end spacing value */
    @Getter private int mEndSpacing = 0;

    /** This ItemDecoration's divider resource */
    @Nullable @Getter private Drawable mDivider;

    private DecorationSpec(@NonNull final DecorationSpecBuilder builder) {
        mDivider = builder.mDivider;

        mTopSpacing = builder.mTopSpacing;
        mBottomSpacing = builder.mBottomSpacing;
        mStartSpacing = builder.mStartSpacing;
        mEndSpacing = builder.mEndSpacing;
    }

    /** DecorationSpec builder class responsible for harboring all the required fields of a {@link DecorationSpec}. */
    @NoArgsConstructor public static class DecorationSpecBuilder {

        private Drawable mDivider;

        private int mTopSpacing;
        private int mBottomSpacing;
        private int mStartSpacing;
        private int mEndSpacing;

        /**
         * Procedure meant to set the value for {@link #mTopSpacing} optional parameter.
         * @param divider TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withDrawableDivider(@Nullable final Drawable divider) {
            mDivider = divider;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mTopSpacing} optional parameter.
         * @param topSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withTopSpacing(final int topSpacing) {
            mTopSpacing = topSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mBottomSpacing} optional parameter.
         * @param bottomSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withBottomSpacing(final int bottomSpacing) {
            mBottomSpacing = bottomSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mStartSpacing} optional parameter.
         * @param startSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withStartSpacing(final int startSpacing) {
            mStartSpacing = startSpacing;
            return this;
        }

        /**
         * Procedure meant to set the value for {@link #mEndSpacing} optional parameter.
         * @param endSpacing TODO...
         * @return TODO...
         */
        public DecorationSpecBuilder withEndSpacing(final int endSpacing) {
            mEndSpacing = endSpacing;
            return this;
        }

        /**
         * Procedure meant to return the desired {@link DecorationSpec}
         * @return the built DecorationSpec instance.
         */
        public DecorationSpec buildDecorationSpec() {
            isValidDecorationSpecData(); // TODO
            return new DecorationSpec(this);
        }

        /** Procedure meant to execute basic validation checks on this DecorationSpec's data */
        private boolean isValidDecorationSpecData() {
            /* TODO: Do some basic validations to check */
            return true;
        }

    }

}
