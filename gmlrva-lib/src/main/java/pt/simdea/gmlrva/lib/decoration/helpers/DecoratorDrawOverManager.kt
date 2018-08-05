/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants

/**
 * This auxiliary class is meant to apply a [SimpleDividerItemDecoration]'s divider specification rules.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
class DecoratorDrawOverManager {

    private val mDrawableDividerHelper = DecoratorDrawableDividerHelper()
    private val mDrawnDividerHelper = DecoratorDrawnDividerHelper()

    /**
     * Procedure meant to handle the drawing stage of a [SimpleDividerItemDecoration]'s divider, sourced by
     * a [Drawable] object.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param divider the divider's target [Drawable] value.
     * @param position the divider's target position. This value is ranged.
     * See [GenericDecorationDividerPosition] for more information.
     * @throws UnsupportedOperationException if the given [GenericDecorationDividerPosition] is invalid.
     */
    fun applyDrawableDivider(canvas: Canvas, parent: RecyclerView,
                             divider: Drawable, @IntRange(from = 0, to = 5) position: Int) {
        when (position) {
            GenericDecorationDividerPosition.POSITION_TOP -> mDrawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider)
            GenericDecorationDividerPosition.POSITION_BOTTOM -> mDrawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider)
            GenericDecorationDividerPosition.POSITION_START -> mDrawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider)
            GenericDecorationDividerPosition.POSITION_END -> mDrawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider)
            GenericDecorationDividerPosition.POSITION_START_END -> {
                mDrawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider)
                mDrawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider)
            }
            GenericDecorationDividerPosition.POSITION_TOP_BOTTOM -> {
                mDrawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider)
                mDrawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider)
            }
            else -> throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
        }
    }

    /**
     * Procedure meant to handle the drawing stage of a [SimpleDividerItemDecoration]'s divider, via
     * [Paint] object.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param state the parent [RecyclerView.State] for the applied [SimpleDividerItemDecoration].
     * @param drawnDivider the configured divider's [Paint] object.
     * @param position the divider's target position. This value is ranged.
     * See [GenericDecorationDividerPosition] for more information.
     */
    fun applyDrawnDivider(canvas: Canvas, parent: RecyclerView,
                          state: RecyclerView.State, drawnDivider: Paint,
                          @IntRange(from = 0, to = 5) position: Int) {
        /* The stroke width was set in the spec, but to correctly draw the line we have to offset by width / 2 */
        val offset = (drawnDivider.strokeWidth / 2).toInt()

        /* This will iterate over every visible view */
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i) // get the view
            val params = view.layoutParams as RecyclerView.LayoutParams
            val pos = params.viewAdapterPosition // get the position

            /* Draw the separator */
            if (pos < state.itemCount) {
                if (drawnDivider.style == Paint.Style.STROKE) {
                    mDrawnDividerHelper.drawDottedDivider(canvas, view, offset, drawnDivider, position)
                } else {
                    mDrawnDividerHelper.drawLineDivider(canvas, view, offset, drawnDivider, position)
                }

            }
        }
    }

}
