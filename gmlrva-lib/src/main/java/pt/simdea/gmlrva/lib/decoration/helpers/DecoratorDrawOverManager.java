package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import lombok.NoArgsConstructor;

import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_BOTTOM;
import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_END;
import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_START;
import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_START_END;
import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_TOP;
import static pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition.POSITION_TOP_BOTTOM;
import static pt.simdea.gmlrva.lib.utilities.GMLRVAConstants.UNSUPPORTED_ERROR;

/**
 * TODO...
 * Created by Paulo on 14/10/2017.
 */
@NoArgsConstructor public class DecoratorDrawOverManager {

    @NonNull private final DecoratorDrawableDividerHelper drawableDividerHelper = new DecoratorDrawableDividerHelper();
    @NonNull private final DecoratorDrawnDividerHelper drawnDividerHelper = new DecoratorDrawnDividerHelper();

    // TODO!
    public void applyDrawableDivider(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                     @NonNull final Drawable divider, @IntRange(from = 0, to = 5) final int position) {
        switch (position) {
            case POSITION_TOP:
                drawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider);
                break;
            case POSITION_BOTTOM:
                drawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider);
                break;
            case POSITION_START:
                drawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider);
                break;
            case POSITION_END:
                drawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider);
                break;
            case POSITION_START_END:
                drawableDividerHelper.drawDrawableDividerPositionStart(canvas, parent, divider);
                drawableDividerHelper.drawDrawableDividerPositionEnd(canvas, parent, divider);
                break;
            case POSITION_TOP_BOTTOM:
                drawableDividerHelper.drawDrawableDividerPositionTop(canvas, parent, divider);
                drawableDividerHelper.drawDrawableDividerPositionBottom(canvas, parent, divider);
                break;
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
        }
    }

    // TODO!
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
                    drawnDividerHelper.drawDottedDivider(canvas, view, offset, drawnDivider, position);
                } else {
                    drawnDividerHelper.drawLineDivider(canvas, view, offset, drawnDivider, position);
                }

            }
        }
    }

}
