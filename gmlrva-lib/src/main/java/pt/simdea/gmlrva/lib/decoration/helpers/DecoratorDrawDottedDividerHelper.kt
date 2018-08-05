/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration

/**
 * Auxiliary class meant to handle the drawing operation of an intended [SimpleDividerItemDecoration]'s divider,
 * with a dotted shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
internal class DecoratorDrawDottedDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on top of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerTop(canvas: Canvas, view: View, offset: Int,
                               drawnDivider: Paint, path: Path) {
        path.moveTo(view.left.toFloat(), (view.top + offset).toFloat())
        path.lineTo(view.right.toFloat(), (view.top + offset).toFloat())
        drawPath(path, canvas, drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on top of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerBottom(canvas: Canvas, view: View, offset: Int,
                                  drawnDivider: Paint, path: Path) {
        path.moveTo(view.left.toFloat(), (view.bottom - offset).toFloat())
        path.lineTo(view.right.toFloat(), (view.bottom - offset).toFloat())
        drawPath(path, canvas, drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on start / left of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerStart(canvas: Canvas, view: View, offset: Int,
                                 drawnDivider: Paint, path: Path) {
        path.moveTo(view.left.toFloat(), (view.top + offset).toFloat())
        path.lineTo(view.left.toFloat(), (view.bottom + offset).toFloat())
        drawPath(path, canvas, drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on end / right of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerEnd(canvas: Canvas, view: View, offset: Int,
                               drawnDivider: Paint, path: Path) {
        path.moveTo(view.right.toFloat(), (view.top - offset).toFloat())
        path.lineTo(view.right.toFloat(), (view.bottom - offset).toFloat())
        drawPath(path, canvas, drawnDivider)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on start / left and end / right of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerStartEnd(canvas: Canvas, view: View, offset: Int,
                                    drawnDivider: Paint, path: Path) {
        onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path)
        onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s divider
     * on top and bottom of the parent's [View] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param view the [View] for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's [Paint] object.
     * @param path the configured divider's [Path] object.
     */
    fun onDrawDottedDividerTopBottom(canvas: Canvas, view: View, offset: Int,
                                     drawnDivider: Paint, path: Path) {
        onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path)
        onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path)
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped [SimpleDividerItemDecoration]'s
     * divider, along the specified [Path] source.
     * @param path the configured divider's [Path] object.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param mDrawnDivider the configured divider's [Paint] object.
     */
    private fun drawPath(path: Path, canvas: Canvas, mDrawnDivider: Paint) {
        canvas.drawPath(path, mDrawnDivider)
    }

}
