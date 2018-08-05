/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import androidx.annotation.IntRange
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants

/**
 * Auxiliary class meant to handle the drawing operation of an intended [SimpleDividerItemDecoration]'s divider,
 * with the correct shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
internal class DecoratorDrawnDividerHelper {

    private val mDrawLineDividerHelper = DecoratorDrawLineDividerHelper()
    private val mDottedDividerHelper = DecoratorDrawDottedDividerHelper()

    /**
     * Procedure meant to handle the drawing stage of a line shaped divider, via a [Paint] object.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param position the divider's target position. This value is ranged.
     * See [GenericDecorationDividerPosition] for more information.
     * @throws UnsupportedOperationException if the given [GenericDecorationDividerPosition] is invalid.
     */
    fun drawLineDivider(canvas: Canvas, view: View, offset: Int,
                        drawnDivider: Paint, @IntRange(from = 0, to = 5) position: Int) {
        when (position) {
            GenericDecorationDividerPosition.POSITION_TOP -> mDrawLineDividerHelper.onDrawLineDividerTop(canvas, view, offset, drawnDivider)
            GenericDecorationDividerPosition.POSITION_BOTTOM -> mDrawLineDividerHelper.onDrawLineDividerBottom(canvas, view, offset, drawnDivider)
            GenericDecorationDividerPosition.POSITION_START -> mDrawLineDividerHelper.onDrawLineDividerStart(canvas, view, offset, drawnDivider)
            GenericDecorationDividerPosition.POSITION_END -> mDrawLineDividerHelper.onDrawLineDividerEnd(canvas, view, offset, drawnDivider)
            GenericDecorationDividerPosition.POSITION_START_END -> mDrawLineDividerHelper.onDrawLineDividerStartEnd(canvas, view, offset, drawnDivider)
            GenericDecorationDividerPosition.POSITION_TOP_BOTTOM -> mDrawLineDividerHelper.onDrawLineDividerTopBottom(canvas, view, offset, drawnDivider)
            else -> throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
        }
    }

    /**
     * Procedure meant to handle the drawing stage of a dotted shaped divider, via a [Paint] object.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param position the divider's target position. This value is ranged.
     * See [GenericDecorationDividerPosition] for more information.
     * @throws UnsupportedOperationException if the given [GenericDecorationDividerPosition] is invalid.
     */
    fun drawDottedDivider(canvas: Canvas, view: View, offset: Int,
                          drawnDivider: Paint,
                          @IntRange(from = 0, to = 5) position: Int) {
        val path = Path()
        when (position) {
            GenericDecorationDividerPosition.POSITION_TOP -> mDottedDividerHelper.onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path)
            GenericDecorationDividerPosition.POSITION_BOTTOM -> mDottedDividerHelper.onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path)
            GenericDecorationDividerPosition.POSITION_START -> mDottedDividerHelper.onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path)
            GenericDecorationDividerPosition.POSITION_END -> mDottedDividerHelper.onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path)
            GenericDecorationDividerPosition.POSITION_START_END -> mDottedDividerHelper.onDrawDottedDividerStartEnd(canvas, view, offset, drawnDivider, path)
            GenericDecorationDividerPosition.POSITION_TOP_BOTTOM -> mDottedDividerHelper.onDrawDottedDividerTopBottom(canvas, view, offset, drawnDivider, path)
            else -> throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
        }
    }

}
