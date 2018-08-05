/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.NonNull;
import android.view.View;

import lombok.NoArgsConstructor;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;

/**
 * Auxiliary class meant to handle the drawing operation of an intended {@link SimpleDividerItemDecoration}'s divider,
 * with a dotted shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
class DecoratorDrawDottedDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on top of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerTop(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                          @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getTop() + offset);
        path.lineTo(view.getRight(), view.getTop() + offset);
        drawPath(path, canvas, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on top of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                             @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getBottom() - offset);
        path.lineTo(view.getRight(), view.getBottom() - offset);
        drawPath(path, canvas, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on start / left of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerStart(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                            @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getTop() + offset);
        path.lineTo(view.getLeft(), view.getBottom() + offset);
        drawPath(path, canvas, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on end / right of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                          @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getRight(), view.getTop() - offset);
        path.lineTo(view.getRight(), view.getBottom() - offset);
        drawPath(path, canvas, drawnDivider);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on start / left and end / right of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerStartEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                               @NonNull final Paint drawnDivider, @NonNull final Path path) {
        onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path);
        onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s divider
     * on top and bottom of the parent's {@link View} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param path the configured divider's {@link Path} object.
     */
    protected void onDrawDottedDividerTopBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                                @NonNull final Paint drawnDivider, @NonNull final Path path) {
        onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path);
        onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path);
    }

    /**
     * Procedure meant to handle the drawing of the intended dotted shaped {@link SimpleDividerItemDecoration}'s
     * divider, along the specified {@link Path} source.
     * @param path the configured divider's {@link Path} object.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param mDrawnDivider the configured divider's {@link Paint} object.
     */
    private void drawPath(@NonNull final Path path, @NonNull final Canvas canvas, @NonNull final Paint mDrawnDivider) {
        canvas.drawPath(path, mDrawnDivider);
    }

}
