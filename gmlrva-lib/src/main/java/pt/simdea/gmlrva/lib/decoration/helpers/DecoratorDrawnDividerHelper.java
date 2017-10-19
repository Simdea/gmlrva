/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.View;

import lombok.NoArgsConstructor;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;

/**
 * Auxiliary class meant to handle the drawing operation of an intended {@link SimpleDividerItemDecoration}'s divider,
 * with the correct shape.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
class DecoratorDrawnDividerHelper {

    @NonNull
    private final DecoratorDrawLineDividerHelper mDrawLineDividerHelper = new DecoratorDrawLineDividerHelper();
    @NonNull
    private final DecoratorDrawDottedDividerHelper mDottedDividerHelper = new DecoratorDrawDottedDividerHelper();

    /**
     * Procedure meant to handle the drawing stage of a line shaped divider, via a {@link Paint} object.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied line shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param position the divider's target position. This value is ranged.
     *                 See {@link GenericDecorationDividerPosition} for more information.
     * @throws UnsupportedOperationException if the given {@link GenericDecorationDividerPosition} is invalid.
     */
    protected void drawLineDivider(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                   @NonNull final Paint drawnDivider, @IntRange(from = 0, to = 5) final int position) {
        switch (position) {
            case GenericDecorationDividerPosition.POSITION_TOP:
                mDrawLineDividerHelper.onDrawLineDividerTop(canvas, view, offset, drawnDivider);
                break;
            case GenericDecorationDividerPosition.POSITION_BOTTOM:
                mDrawLineDividerHelper.onDrawLineDividerBottom(canvas, view, offset, drawnDivider);
                break;
            case GenericDecorationDividerPosition.POSITION_START:
                mDrawLineDividerHelper.onDrawLineDividerStart(canvas, view, offset, drawnDivider);
                break;
            case GenericDecorationDividerPosition.POSITION_END:
                mDrawLineDividerHelper.onDrawLineDividerEnd(canvas, view, offset, drawnDivider);
                break;
            case GenericDecorationDividerPosition.POSITION_START_END:
                mDrawLineDividerHelper.onDrawLineDividerStartEnd(canvas, view, offset, drawnDivider);
                break;
            case GenericDecorationDividerPosition.POSITION_TOP_BOTTOM:
                mDrawLineDividerHelper.onDrawLineDividerTopBottom(canvas, view, offset, drawnDivider);
                break;
            default:
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
        }
    }

    /**
     * Procedure meant to handle the drawing stage of a dotted shaped divider, via a {@link Paint} object.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param view the {@link View} for the applied dotted shaped divider.
     * @param offset int value meant to correctly draw the line (stroke width / 2).
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param position the divider's target position. This value is ranged.
     *                 See {@link GenericDecorationDividerPosition} for more information.
     * @throws UnsupportedOperationException if the given {@link GenericDecorationDividerPosition} is invalid.
     */
    protected void drawDottedDivider(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                     @NonNull final Paint drawnDivider,
                                     @IntRange(from = 0, to = 5) final int position) {
        final Path path = new Path();
        switch (position) {
            case GenericDecorationDividerPosition.POSITION_TOP:
                mDottedDividerHelper.onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path);
                break;
            case GenericDecorationDividerPosition.POSITION_BOTTOM:
                mDottedDividerHelper.onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path);
                break;
            case GenericDecorationDividerPosition.POSITION_START:
                mDottedDividerHelper.onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path);
                break;
            case GenericDecorationDividerPosition.POSITION_END:
                mDottedDividerHelper.onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path);
                break;
            case GenericDecorationDividerPosition.POSITION_START_END:
                mDottedDividerHelper.onDrawDottedDividerStartEnd(canvas, view, offset, drawnDivider, path);
                break;
            case GenericDecorationDividerPosition.POSITION_TOP_BOTTOM:
                mDottedDividerHelper.onDrawDottedDividerTopBottom(canvas, view, offset, drawnDivider, path);
                break;
            default:
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
        }
    }

}
