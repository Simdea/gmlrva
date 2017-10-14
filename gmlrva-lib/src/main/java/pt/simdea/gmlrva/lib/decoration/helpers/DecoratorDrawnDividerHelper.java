package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
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
@NoArgsConstructor class DecoratorDrawnDividerHelper {

    @NonNull private final DecoratorDrawLineDividerHelper drawLineDividerHelper = new DecoratorDrawLineDividerHelper();
    @NonNull private final DecoratorDrawDottedDividerHelper dottedDividerHelper
            = new DecoratorDrawDottedDividerHelper();

    // TODO!
    void drawLineDivider(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                         @NonNull final Paint drawnDivider, @IntRange(from = 0, to = 5) final int position) {
        switch (position) {
            case POSITION_TOP:
                drawLineDividerHelper.onDrawLineDividerTop(canvas, view, offset, drawnDivider);
                break;
            case POSITION_BOTTOM:
                drawLineDividerHelper.onDrawLineDividerBottom(canvas, view, offset, drawnDivider);
                break;
            case POSITION_START:
                drawLineDividerHelper.onDrawLineDividerStart(canvas, view, offset, drawnDivider);
                break;
            case POSITION_END:
                drawLineDividerHelper.onDrawLineDividerEnd(canvas, view, offset, drawnDivider);
                break;
            case POSITION_START_END:
                drawLineDividerHelper.onDrawLineDividerStartEnd(canvas, view, offset, drawnDivider);
                break;
            case POSITION_TOP_BOTTOM:
                drawLineDividerHelper.onDrawLineDividerTopBottom(canvas, view, offset, drawnDivider);
                break;
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
        }
    }

    // TODO!
    void drawDottedDivider(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                           @NonNull final Paint drawnDivider, @IntRange(from = 0, to = 5) final int position) {
        final Path path = new Path();
        switch (position) {
            case POSITION_TOP:
                dottedDividerHelper.onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path);
                break;
            case POSITION_BOTTOM:
                dottedDividerHelper.onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path);
                break;
            case POSITION_START:
                dottedDividerHelper.onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path);
                break;
            case POSITION_END:
                dottedDividerHelper.onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path);
                break;
            case POSITION_START_END:
                dottedDividerHelper.onDrawDottedDividerStartEnd(canvas, view, offset, drawnDivider, path);
                break;
            case POSITION_TOP_BOTTOM:
                dottedDividerHelper.onDrawDottedDividerTopBottom(canvas, view, offset, drawnDivider, path);
                break;
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
        }
    }

}
