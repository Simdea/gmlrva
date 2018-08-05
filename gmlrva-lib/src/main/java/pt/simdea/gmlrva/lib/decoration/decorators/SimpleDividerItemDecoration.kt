/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.decorators

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.decoration.GenericItemDecoration
import pt.simdea.gmlrva.lib.decoration.helpers.DecoratorDrawOverManager
import pt.simdea.gmlrva.lib.decoration.specs.ItemDecorationSpec
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec

/**
 * This class is meant to apply both outer spacing and dividers to a [RecyclerView].
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class SimpleDividerItemDecoration
/**
 * Instantiates a new SimpleDividerItemDecoration.
 * @param configurationSpec a valid [ItemDecorationSpec] containing this item decoration specification.
 */
(configurationSpec: SimpleDividerItemDecorationSpec) : GenericItemDecoration<SimpleDividerItemDecorationSpec>(configurationSpec) {

    private val mDrawOverManager = DecoratorDrawOverManager()

    @IntRange(from = 0)
    private var mTopSpacing: Int = 0
    @IntRange(from = 0)
    private var mBottomSpacing: Int = 0
    @IntRange(from = 0)
    private var mStartSpacing: Int = 0
    @IntRange(from = 0)
    private var mEndSpacing: Int = 0
    @IntRange(from = 0, to = 5)
    private var mDividerPosition: Int = 0

    private var mDivider: Drawable? = null
    private var mDrawnDivider: Paint? = null

    /** {@inheritDoc}  */
    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = mTopSpacing
        outRect.bottom = mBottomSpacing
        outRect.left = mStartSpacing
        outRect.right = mEndSpacing
    }

    /** {@inheritDoc}  */
    override fun onDrawOver(canvas: Canvas, parent: RecyclerView,
                            state: RecyclerView.State) {
        if (mDivider != null) {
            mDrawOverManager.applyDrawableDivider(canvas, parent, mDivider!!, mDividerPosition)
        } else if (mDrawnDivider != null) {
            mDrawOverManager.applyDrawnDivider(canvas, parent, state, mDrawnDivider!!, mDividerPosition)
        }
    }

    /** {@inheritDoc}  */
    override fun applySpec(configurationSpec: SimpleDividerItemDecorationSpec) {
        /* Get Spacing Rules */
        mTopSpacing = configurationSpec.getTopSpacing()
        mBottomSpacing = configurationSpec.getBottomSpacing()
        mStartSpacing = configurationSpec.getStartSpacing()
        mEndSpacing = configurationSpec.getEndSpacing()

        /* Get Divider Rules */
        mDivider = configurationSpec.getDivider()
        mDividerPosition = configurationSpec.getDividerPosition()
        mDrawnDivider = configurationSpec.getDrawnDivider()
    }

}
