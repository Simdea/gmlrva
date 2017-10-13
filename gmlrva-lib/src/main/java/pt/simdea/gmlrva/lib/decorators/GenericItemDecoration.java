package pt.simdea.gmlrva.lib.decorators;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * TODO...
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public class GenericItemDecoration extends RecyclerView.ItemDecoration {

    private int mTopSpacing;
    private int mBottomSpacing;
    private int mStartSpacing;
    private int mEndSpacing;

    @Nullable private Drawable mDivider;
    @Nullable private Paint mDrawnDivider;

    public GenericItemDecoration(@NonNull final DecorationSpec configurationSpec) {
        applySpec(configurationSpec);
    }

    private void applySpec(@NonNull final DecorationSpec configurationSpec) {
        /* Get Spacing Rules */
        mTopSpacing = configurationSpec.getTopSpacing();
        mBottomSpacing = configurationSpec.getBottomSpacing();
        mStartSpacing = configurationSpec.getStartSpacing();
        mEndSpacing = configurationSpec.getEndSpacing();

        /* Get Divider Rules */
        mDivider = configurationSpec.getDivider();
        mDrawnDivider = configurationSpec.getDrawnDivider();
    }

    @Override public void getItemOffsets(@NonNull final Rect outRect, @NonNull final View view,
                                         @NonNull final RecyclerView parent, @NonNull final RecyclerView.State state) {
        outRect.top = mTopSpacing;
        outRect.bottom = mBottomSpacing;
        outRect.left = mStartSpacing;
        outRect.right = mEndSpacing;
    }

    @Override public void onDrawOver(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                     @NonNull final RecyclerView.State state) {
        if (mDivider != null) {
            applyDrawableDivider(canvas, parent, mDivider);
        } else if (mDrawnDivider != null) {
            applyDrawnDivider(canvas, parent, state, mDrawnDivider);
        }
    }

    private void applyDrawableDivider(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                      @NonNull final Drawable mDivider) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        /* This will iterate over every visible view */
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int top = view.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    // TODO!
    private void applyDrawnDivider(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                   @NonNull final RecyclerView.State state, @NonNull final Paint mDrawnDivider) {
        /* The stroke width was set in the spec, but to correctly draw the line we have to offset by width / 2 */
        final int offset = (int) (mDrawnDivider.getStrokeWidth() / 2);

        /* This will iterate over every visible view */
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i); // get the view
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int position = params.getViewAdapterPosition(); // get the position

            /* Draw the separator */
            if (position < state.getItemCount()) {
                canvas.drawLine(view.getLeft(), view.getBottom() + offset, view.getRight(), view.getBottom() + offset,
                        mDrawnDivider);
            }
        }
    }

}
