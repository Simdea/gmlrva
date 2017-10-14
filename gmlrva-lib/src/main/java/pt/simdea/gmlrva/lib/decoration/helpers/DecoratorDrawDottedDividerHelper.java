package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.view.View;

import lombok.NoArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 14/10/2017.
 */
@NoArgsConstructor
class DecoratorDrawDottedDividerHelper {

    // TODO!
    void onDrawDottedDividerTop(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getTop() + offset);
        path.lineTo(view.getRight(), view.getTop() + offset);
        drawPath(path, canvas, drawnDivider);
    }

    // TODO!
    void onDrawDottedDividerBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                   @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getBottom() - offset);
        path.lineTo(view.getRight(), view.getBottom() - offset);
        drawPath(path, canvas, drawnDivider);
    }

    // TODO!
    void onDrawDottedDividerStart(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                  @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getLeft(), view.getTop() + offset);
        path.lineTo(view.getLeft(), view.getBottom() + offset);
        drawPath(path, canvas, drawnDivider);
    }

    // TODO!
    void onDrawDottedDividerEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                @NonNull final Paint drawnDivider, @NonNull final Path path) {
        path.moveTo(view.getRight(), view.getTop() - offset);
        path.lineTo(view.getRight(), view.getBottom() - offset);
        drawPath(path, canvas, drawnDivider);
    }

    // TODO!
    void onDrawDottedDividerStartEnd(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                     @NonNull final Paint drawnDivider, @NonNull final Path path) {
        onDrawDottedDividerStart(canvas, view, offset, drawnDivider, path);
        onDrawDottedDividerEnd(canvas, view, offset, drawnDivider, path);
    }

    // TODO!
    void onDrawDottedDividerTopBottom(@NonNull final Canvas canvas, @NonNull final View view, final int offset,
                                      @NonNull final Paint drawnDivider, @NonNull final Path path) {
        onDrawDottedDividerTop(canvas, view, offset, drawnDivider, path);
        onDrawDottedDividerBottom(canvas, view, offset, drawnDivider, path);
    }

    // TODO!
    void drawPath(@NonNull final Path path, @NonNull final Canvas canvas, @NonNull final Paint mDrawnDivider) {
        canvas.drawPath(path, mDrawnDivider);
    }

}
