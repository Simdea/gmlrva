/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;

import lombok.NoArgsConstructor;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;

/**
 * Auxiliary class meant to handle the drawing operation of an intended {@link SimpleDividerItemDecoration}'s divider,
 * with a line shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
class DecoratorDrawLineDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on top of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerTop(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                        @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft(), view.getTop() + offset, view.getRight(), view.getTop() + offset, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on bottom of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                           @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft(), view.getBottom() - offset, view.getRight(), view.getBottom() - offset,
                drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on start / left of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerStart(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                          @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft() + offset, view.getTop(), view.getLeft() + offset, view.getBottom(),
                drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on end / right of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                        @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getRight() - offset, view.getTop(), view.getRight() - offset, view.getBottom(),
                drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on start / left and end / right of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerStartEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                             @NonNull final Paint drawnDivider) {
        onDrawLineDividerStart(canvas, view, offset, drawnDivider);
        onDrawLineDividerEnd(canvas, view, offset, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended line shaped {@link SimpleDividerItemDecoration}'s divider
     * on top and bottom of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     */
    protected void onDrawLineDividerTopBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                              @NonNull final Paint drawnDivider) {
        onDrawLineDividerTop(canvas, view, offset, drawnDivider);
        onDrawLineDividerBottom(canvas, view, offset, drawnDivider);
    }

}
