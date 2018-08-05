/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration

/**
 * Auxiliary class meant to handle the drawing operation of an intended [SimpleDividerItemDecoration]'s divider,
 * with a line shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
internal class DecoratorDrawLineDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on top of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerTop(canvas: Canvas, view: View, offset: Int,
                             drawnDivider: Paint) {
        canvas.drawLine(view.left.toFloat(), (view.top + offset).toFloat(), view.right.toFloat(), (view.top + offset).toFloat(), drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on bottom of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerBottom(canvas: Canvas, view: View, offset: Int,
                                drawnDivider: Paint) {
        canvas.drawLine(view.left.toFloat(), (view.bottom - offset).toFloat(), view.right.toFloat(), (view.bottom - offset).toFloat(),
                drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on start / left of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerStart(canvas: Canvas, view: View, offset: Int,
                               drawnDivider: Paint) {
        canvas.drawLine((view.left + offset).toFloat(), view.top.toFloat(), (view.left + offset).toFloat(), view.bottom.toFloat(),
                drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on end / right of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerEnd(canvas: Canvas, view: View, offset: Int,
                             drawnDivider: Paint) {
        canvas.drawLine((view.right - offset).toFloat(), view.top.toFloat(), (view.right - offset).toFloat(), view.bottom.toFloat(),
                drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on start / left and end / right of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerStartEnd(canvas: Canvas, view: View, offset: Int,
                                  drawnDivider: Paint) {
        onDrawLineDividerStart(canvas, view, offset, drawnDivider)
        onDrawLineDividerEnd(canvas, view, offset, drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped [SimpleDividerItemDecoration]'s divider
     * on top and bottom of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     */
    fun onDrawLineDividerTopBottom(canvas: Canvas, view: View, offset: Int,
                                   drawnDivider: Paint) {
        onDrawLineDividerTop(canvas, view, offset, drawnDivider)
        onDrawLineDividerBottom(canvas, view, offset, drawnDivider)
    }

}
