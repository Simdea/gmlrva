package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;

import lombok.NoArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 14/10/2017.
 */
@NoArgsConstructor class DecoratorDrawLineDividerHelper {

    // TODO!
    void onDrawLineDividerTop(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                              @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft(), view.getTop() + offset, view.getRight(), view.getTop() + offset, drawnDivider);
    }

    // TODO!
    void onDrawLineDividerBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                 @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft(), view.getBottom() - offset, view.getRight(), view.getBottom() - offset,
                drawnDivider);
    }

    // TODO!
    void onDrawLineDividerStart(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getLeft() + offset, view.getTop(), view.getLeft() + offset, view.getBottom(),
                drawnDivider);
    }

    // TODO!
    void onDrawLineDividerEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                              @NonNull final Paint drawnDivider) {
        canvas.drawLine(view.getRight() - offset, view.getTop(), view.getRight() - offset, view.getBottom(),
                drawnDivider);
    }

    // TODO!
    void onDrawLineDividerStartEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                   @NonNull final Paint drawnDivider) {
        onDrawLineDividerStart(canvas, view, offset, drawnDivider);
        onDrawLineDividerEnd(canvas, view, offset, drawnDivider);
    }

    // TODO!
    void onDrawLineDividerTopBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                    @NonNull final Paint drawnDivider) {
        onDrawLineDividerTop(canvas, view, offset, drawnDivider);
        onDrawLineDividerBottom(canvas, view, offset, drawnDivider);
    }

}
