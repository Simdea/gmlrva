/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.decoration.specs.ItemDecorationSpec

/**
 * This class is meant to apply any generic implementation of an [ItemDecorationSpec] to a [RecyclerView].
 *
 * @param <T> an instance of [ItemDecorationSpec].
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
</T> */
abstract class GenericItemDecoration<T : ItemDecorationSpec>
/**
 * Instantiates a new GenericItemDecoration.
 * @param configurationSpec a valid [ItemDecorationSpec] containing this item decoration specification.
 */
protected constructor(configurationSpec: T) : RecyclerView.ItemDecoration() {

    init {
        applySpec(configurationSpec)
    }

    /** {@inheritDoc}  */
    abstract override fun getItemOffsets(outRect: Rect, view: View,
                                         parent: RecyclerView, state: RecyclerView.State)

    /** {@inheritDoc}  */
    abstract override fun onDrawOver(canvas: Canvas, parent: RecyclerView,
                                     state: RecyclerView.State)

    /**
     * Procedure meant to apply a given [ItemDecorationSpec] to this item decoration.
     * @param configurationSpec the valid [ItemDecorationSpec] containing this item decoration specification.
     */
    protected abstract fun applySpec(configurationSpec: T)

}
