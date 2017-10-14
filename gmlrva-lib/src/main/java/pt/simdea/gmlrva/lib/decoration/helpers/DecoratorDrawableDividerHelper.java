package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import lombok.NoArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 14/10/2017.
 */
@NoArgsConstructor class DecoratorDrawableDividerHelper {

    void drawDrawableDividerPositionTop(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                        @NonNull final Drawable mDivider) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        /* This will iterate over every visible view */
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int top = view.getTop() + params.topMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    void drawDrawableDividerPositionBottom(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                           @NonNull final Drawable mDivider) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        /* This will iterate over every visible view */
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int bottom = view.getBottom() + params.bottomMargin;
            final int top = bottom - mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    void drawDrawableDividerPositionStart(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                          @NonNull final Drawable mDivider) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int left = view.getLeft() + params.leftMargin;
            final int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    void drawDrawableDividerPositionEnd(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
                                        @NonNull final Drawable mDivider) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int right = view.getRight() + params.rightMargin;
            final int left = right - mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

}
