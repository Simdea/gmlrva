/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import lombok.NoArgsConstructor;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;

/**
 * This auxiliary class is meant to apply a {@link SimpleDividerItemDecoration}'s divider specification rules.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
public class DecoratorDrawOverManager {

    @NonNull
    private final DecoratorDrawableDividerHelper mDrawableDividerHelper = new DecoratorDrawableDividerHelper();
    @NonNull
    private final DecoratorDrawnDividerHelper mDrawnDividerHelper = new DecoratorDrawnDividerHelper();

    /**
     * Procedure meant to handle the drawing stage of a {@link SimpleDividerItemDecoration}'s divider, sourced by
     * a {@link Drawable} object.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param divider the divider's target {@link Drawable} value.
     * @param position the divider's target position. This value is ranged.
     *                 See {@link GenericDecorationDividerPosition} for more information.
     * @throws UnsupportedOperationException if the given {@link GenericDecorationDividerPosition} is invalid.
     */
    public void applyDrawableDivider(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                     @NonNull final Drawable divider, @IntRange(from = 0, to = 5) final int position) {
        switch (position) {
            case GenericDecorationDividerPosition.POSITION_TOP:
                mDrawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider);
                break;
            case GenericDecorationDividerPosition.POSITION_BOTTOM:
                mDrawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider);
                break;
            case GenericDecorationDividerPosition.POSITION_START:
                mDrawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider);
                break;
            case GenericDecorationDividerPosition.POSITION_END:
                mDrawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider);
                break;
            case GenericDecorationDividerPosition.POSITION_START_END:
                mDrawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider);
                mDrawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider);
                break;
            case GenericDecorationDividerPosition.POSITION_TOP_BOTTOM:
                mDrawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider);
                mDrawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider);
                break;
            default:
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
        }
    }

    /**
     * Procedure meant to handle the drawing stage of a {@link SimpleDividerItemDecoration}'s divider, via
     * {@link Paint} object.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param state the parent {@link RecyclerView.State} for the applied {@link SimpleDividerItemDecoration}.
     * @param drawnDivider the configured divider's {@link Paint} object.
     * @param position the divider's target position. This value is ranged.
     *                 See {@link GenericDecorationDividerPosition} for more information.
     */
    public void applyDrawnDivider(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                  @NonNull final RecyclerView.State state, @NonNull final Paint drawnDivider,
                                  @IntRange(from = 0, to = 5) final int position) {
        /* The stroke width was set in the spec, but to correctly draw the line we have to offset by width / 2 */
        final int offset = (int) (drawnDivider.getStrokeWidth() / 2);

        /* This will iterate over every visible view */
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i); // get the view
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int pos = params.getViewAdapterPosition(); // get the position

            /* Draw the separator */
            if (pos < state.getItemCount()) {
                if (drawnDivider.getStyle().equals(Paint.Style.STROKE)) {
                    mDrawnDividerHelper.drawDottedDivider(canvas, view, offset, drawnDivider, position);
                } else {
                    mDrawnDividerHelper.drawLineDivider(canvas, view, offset, drawnDivider, position);
                }

            }
        }
    }

}
