/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import lombok.NoArgsConstructor;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;

/**
 * Auxiliary class meant to handle the drawing operation of an intended {@link SimpleDividerItemDecoration}'s divider,
 * at the correct {@link RecyclerView} item's position.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
class DecoratorDrawableDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended {@link SimpleDividerItemDecoration}'s divider on top of
     * the parent's {@link RecyclerView} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param mDivider the divider's target {@link Drawable} value.
     */
    protected void drawDrawableDividerPositionTop(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
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

    /**
     * Procedure meant to handle the drawing of the intended {@link SimpleDividerItemDecoration}'s divider on bottom of
     * the parent's {@link RecyclerView} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param mDivider the divider's target {@link Drawable} value.
     */
    protected void drawDrawableDividerPositionBottom(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
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

    /**
     * Procedure meant to handle the drawing of the intended {@link SimpleDividerItemDecoration}'s divider
     * on start / left of the parent's {@link RecyclerView} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param mDivider the divider's target {@link Drawable} value.
     */
    protected void drawDrawableDividerPositionStart(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
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

    /**
     * Procedure meant to handle the drawing of the intended {@link SimpleDividerItemDecoration}'s divider
     * on end / right of the parent's {@link RecyclerView} item.
     * @param canvas the {@link Canvas} object where the divider will be drawn.
     * @param parent the parent {@link RecyclerView} for the applied {@link SimpleDividerItemDecoration}.
     * @param mDivider the divider's target {@link Drawable} value.
     */
    protected void drawDrawableDividerPositionEnd(@NonNull final Canvas canvas, @NonNull final RecyclerView parent,
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
