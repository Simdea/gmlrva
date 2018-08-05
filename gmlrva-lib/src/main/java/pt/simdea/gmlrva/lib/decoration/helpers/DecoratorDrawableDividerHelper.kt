/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration

/**
 * Auxiliary class meant to handle the drawing operation of an intended [SimpleDividerItemDecoration]'s divider,
 * at the correct [RecyclerView] item's position.
 *
 * Created by Paulo Ribeiro on 14/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
internal class DecoratorDrawableDividerHelper {

    /**
     * Procedure meant to handle the drawing of the intended [SimpleDividerItemDecoration]'s divider on top of
     * the parent's [RecyclerView] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param mDivider the divider's target [Drawable] value.
     */
    fun drawDrawableDividerPositionTop(canvas: Canvas, parent: RecyclerView,
                                       mDivider: Drawable) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        /* This will iterate over every visible view */
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val params = view.layoutParams as RecyclerView.LayoutParams
            val top = view.top + params.topMargin
            val bottom = top + mDivider.intrinsicHeight
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(canvas)
        }
    }

    /**
     * Procedure meant to handle the drawing of the intended [SimpleDividerItemDecoration]'s divider on bottom of
     * the parent's [RecyclerView] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param mDivider the divider's target [Drawable] value.
     */
    fun drawDrawableDividerPositionBottom(canvas: Canvas, parent: RecyclerView,
                                          mDivider: Drawable) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        /* This will iterate over every visible view */
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val params = view.layoutParams as RecyclerView.LayoutParams
            val bottom = view.bottom + params.bottomMargin
            val top = bottom - mDivider.intrinsicHeight
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(canvas)
        }
    }

    /**
     * Procedure meant to handle the drawing of the intended [SimpleDividerItemDecoration]'s divider
     * on start / left of the parent's [RecyclerView] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param mDivider the divider's target [Drawable] value.
     */
    fun drawDrawableDividerPositionStart(canvas: Canvas, parent: RecyclerView,
                                         mDivider: Drawable) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val params = view.layoutParams as RecyclerView.LayoutParams
            val left = view.left + params.leftMargin
            val right = left + mDivider.intrinsicWidth
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(canvas)
        }
    }

    /**
     * Procedure meant to handle the drawing of the intended [SimpleDividerItemDecoration]'s divider
     * on end / right of the parent's [RecyclerView] item.
     * @param canvas the [Canvas] object where the divider will be drawn.
     * @param parent the parent [RecyclerView] for the applied [SimpleDividerItemDecoration].
     * @param mDivider the divider's target [Drawable] value.
     */
    fun drawDrawableDividerPositionEnd(canvas: Canvas, parent: RecyclerView,
                                       mDivider: Drawable) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val params = view.layoutParams as RecyclerView.LayoutParams
            val right = view.right + params.rightMargin
            val left = right - mDivider.intrinsicWidth
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(canvas)
        }
    }

}
