/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.specs

import android.graphics.Color
import android.graphics.Paint
import android.graphics.PathEffect
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.decoration.GenericItemDecoration
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition
import java.io.Serializable

/**
 * Class responsible for defining a [RecyclerView.ItemDecoration].
 * See [GenericItemDecoration] for more information.
 *
 * This class employs Builder Pattern, meaning this class contains all the required fields.
 * It's constructor receives all the required parameters. All optional parameters can be set via this class.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class SimpleDividerItemDecorationSpec(builder: DecorationSpecBuilder) : ItemDecorationSpec, Serializable {

    /** This ItemDecoration's top spacing value  */
    internal val mTopSpacing: Int

    /** This ItemDecoration's bottom spacing value  */
    internal val mBottomSpacing: Int

    /** This ItemDecoration's start spacing value  */
    internal val mStartSpacing: Int

    /** This ItemDecoration's end spacing value  */
    internal val mEndSpacing: Int

    /** This ItemDecoration's divider position value [GenericDecorationDividerPosition]  */
    internal val mDividerPosition: Int

    /** This ItemDecoration's divider resource  */
    internal val mDivider: Drawable?

    /** This ItemDecoration's divider [Paint] resource  */
    internal val mDrawnDivider: Paint?

    init {
        mDividerPosition = builder.mDividerPosition
        mDivider = builder.mDivider
        mDrawnDivider = builder.mDrawnDivider

        mTopSpacing = builder.mTopSpacing
        mBottomSpacing = builder.mBottomSpacing
        mStartSpacing = builder.mStartSpacing
        mEndSpacing = builder.mEndSpacing
    }

    /**
     * SimpleDividerItemDecorationSpec builder class responsible for harboring
     * all the required fields of a [SimpleDividerItemDecorationSpec].
     */
    class DecorationSpecBuilder {

        internal var mDivider: Drawable? = null
        internal var mDrawnDivider: Paint? = null

        internal var mTopSpacing: Int = 0
        internal var mBottomSpacing: Int = 0
        internal var mStartSpacing: Int = 0
        internal var mEndSpacing: Int = 0
        internal var mDividerPosition: Int = 0

        /**
         * Procedure meant to set the value for [.mDrawnDivider] optional parameter.
         * @param color the divider's target [Color] value.
         * See [Paint.setColor] for more information.
         * @param thickness the divider's target line thickness value. This value must be greater or equal than 0.
         * See [Paint.setStrokeWidth] for more information.
         * @param style the divider's target [Paint.Style].
         * See [Paint.setStyle] for more information.
         * @param pathEffect the divider's target [PathEffect].
         * See [Paint.setPathEffect] for more information.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withDrawnDivider(@ColorInt color: Int,
                             @FloatRange(from = 0.0, fromInclusive = false) thickness: Float,
                             style: Paint.Style?,
                             pathEffect: PathEffect?): DecorationSpecBuilder {
            mDrawnDivider = Paint()
            mDrawnDivider!!.color = color
            mDrawnDivider!!.strokeWidth = thickness
            if (style != null) {
                mDrawnDivider!!.style = style
            }
            if (pathEffect != null) {
                mDrawnDivider!!.pathEffect = pathEffect
            }
            return this
        }

        /**
         * Procedure meant to set the value for [.mDivider] optional parameter.
         * @param divider the divider's target [Drawable] value.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withDrawableDivider(divider: Drawable?): DecorationSpecBuilder {
            mDivider = divider
            return this
        }

        /**
         * Procedure meant to set the value for [.mDividerPosition] optional parameter.
         * @param dividerPosition the divider's target position value. This value is ranged.
         * See [GenericDecorationDividerPosition] for more information.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withDividerPosition(@IntRange(from = 0, to = 5) dividerPosition: Int): DecorationSpecBuilder {
            mDividerPosition = dividerPosition
            return this
        }

        /**
         * Procedure meant to set the value for [.mTopSpacing] optional parameter.
         * @param topSpacing the [RecyclerView]'s outer top spacing value.
         * This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withTopSpacing(@IntRange(from = 0) topSpacing: Int): DecorationSpecBuilder {
            mTopSpacing = topSpacing
            return this
        }

        /**
         * Procedure meant to set the value for [.mBottomSpacing] optional parameter.
         * @param bottomSpacing the [RecyclerView]'s outer bottom spacing value.
         * This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withBottomSpacing(@IntRange(from = 0) bottomSpacing: Int): DecorationSpecBuilder {
            mBottomSpacing = bottomSpacing
            return this
        }

        /**
         * Procedure meant to set the value for [.mStartSpacing] optional parameter.
         * @param startSpacing the [RecyclerView]'s outer start / left spacing value.
         * This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withStartSpacing(@IntRange(from = 0) startSpacing: Int): DecorationSpecBuilder {
            mStartSpacing = startSpacing
            return this
        }

        /**
         * Procedure meant to set the value for [.mEndSpacing] optional parameter.
         * @param endSpacing the [RecyclerView]'s outer end / right spacing value.
         * This value must be greater or equal than 0.
         * @return the same object builder object after setting the optional attribute.
         */
        fun withEndSpacing(@IntRange(from = 0) endSpacing: Int): DecorationSpecBuilder {
            mEndSpacing = endSpacing
            return this
        }

        /**
         * Procedure meant to return the desired [SimpleDividerItemDecorationSpec].
         * @return the built SimpleDividerItemDecorationSpec instance.
         */
        fun buildDecorationSpec(): SimpleDividerItemDecorationSpec {
            return SimpleDividerItemDecorationSpec(this)
        }

    }

}
