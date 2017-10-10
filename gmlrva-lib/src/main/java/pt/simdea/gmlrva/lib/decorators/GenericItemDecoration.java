package pt.simdea.gmlrva.lib.decorators;

import android.graphics.Canvas;
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

    public GenericItemDecoration(@NonNull final DecorationSpec configurationSpec) {
        applySpec(configurationSpec);
    }

    private void applySpec(@NonNull final DecorationSpec configurationSpec) {
        mTopSpacing = configurationSpec.getTopSpacing();
        mBottomSpacing = configurationSpec.getBottomSpacing();
        mStartSpacing = configurationSpec.getStartSpacing();
        mEndSpacing = configurationSpec.getEndSpacing();

        mDivider = configurationSpec.getDivider();
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
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
        }
    }

}
