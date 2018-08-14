/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib

import android.util.SparseArray
import android.view.ViewGroup
import androidx.annotation.IntRange
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.diff.GmlrvaDiffCallback

/**
 * Generic [RecyclerView.Adapter] base class responsible for binding "all intents and purposes" layout
 * implementations applied to [RecyclerView] instances.
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
 */
class GenericMultipleLayoutAdapter : PagedListAdapter<IGenericRecyclerViewLayout<ViewHolder>, ViewHolder>(GmlrvaDiffCallback()) {

    /* View Type Auxiliary Variable */
    private val mViewTypes = SparseArray<IGenericRecyclerViewLayout<out ViewHolder>>()

    /** {@inheritDoc}  */
    override fun onCreateViewHolder(parent: ViewGroup, @IntRange(from = 0) viewType: Int): ViewHolder {
        return mViewTypes.get(viewType).createViewHolder(parent)
    }

    /** {@inheritDoc}  */
    override fun onBindViewHolder(holder: ViewHolder, @IntRange(from = 0) position: Int) =
            getItem(position)!!.setElements(holder)

    /**
     * {@inheritDoc}
     */
    override fun onViewRecycled(holder: ViewHolder) {
        holder.recycle()
        super.onViewRecycled(holder)
    }

    /** {@inheritDoc}  */
    override fun getItemViewType(@IntRange(from = 0) position: Int): Int {
        return getItem(position)!!.viewType
    }

    /**
     * Procedure meant to insert a list of Generic Layout Implementation item on this adapter's data set.
     * @param items the list of Generic Layout Implementation items to be inserted.
     * See [IGenericRecyclerViewLayout] for more information.
     */
    override fun submitList(items: PagedList<IGenericRecyclerViewLayout<ViewHolder>>) {
        super.submitList(items)
        updateViewTypes()
    }

    /**
     * Procedure meant to retrieve a Generic Layout Implementation item on this adapter's data set.
     * @param position the target position of the item to be retrieved.
     * @return the Generic Layout Implementation item whose index is the specified target position.
     * @throws NullPointerException if the data set is empty.
     * @throws IndexOutOfBoundsException if the target position is out of range
     * (<tt>position &lt; 0 || position &gt; size()</tt>).
     */
    operator fun get(@IntRange(from = 0) position: Int): IGenericRecyclerViewLayout<*>? {
        return getItem(position)
    }

    /** Procedure meant to update this Adapter's handled View Types.  */
    private fun updateViewTypes() {
        mViewTypes.clear()
        for (item in currentList!!) {
            if (mViewTypes.get(item.viewType) == null) {
                mViewTypes.put(item.viewType, item)
            }
        }
    }
}
