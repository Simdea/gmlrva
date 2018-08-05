/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.diff

import android.os.Bundle
import androidx.annotation.IntRange
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import lombok.AllArgsConstructor
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout

/**
 * Generic [DiffUtil.Callback] base class responsible for parsing changes to the
 * [GenericMultipleLayoutAdapter] implementation applied to [RecyclerView] instances.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class GmlrvaDiffCallback(private var mOldList: List<IGenericRecyclerViewLayout<*>>?,
                         private var mNewList: List<IGenericRecyclerViewLayout<*>>?)
                         : DiffUtil.Callback() {

     /** {@inheritDoc}  */
    override fun getOldListSize(): Int {
        return mOldList?.size ?: 0
    }

    /** {@inheritDoc}  */
    override fun getNewListSize(): Int {
        return mNewList?.size ?: 0
    }

    /** {@inheritDoc}  */
    override fun areItemsTheSame(@IntRange(from = 0) oldItemPosition: Int,
                                 @IntRange(from = 0) newItemPosition: Int): Boolean {
        val oldItem = mOldList!![oldItemPosition]
        val newItem = mNewList!![newItemPosition]
        return oldItem == newItem
    }

    /** {@inheritDoc}  */
    override fun areContentsTheSame(@IntRange(from = 0) oldItemPosition: Int,
                                    @IntRange(from = 0) newItemPosition: Int): Boolean {
        val oldItem = mOldList!![oldItemPosition]
        val newItem = mNewList!![newItemPosition]
        return oldItem.tag == newItem.tag
    }

    /** {@inheritDoc}  */
    override fun getChangePayload(@IntRange(from = 0) oldItemPosition: Int,
                                  @IntRange(from = 0) newItemPosition: Int): Any? {
        val oldItem = mOldList!![oldItemPosition]
        val newItem = mNewList!![newItemPosition]
        val diffBundle = Bundle()

        if (newItem.tag != oldItem.tag) {
            diffBundle.putSerializable(GenericPayload.UPDATE_ITEM, newItem)
        }

        return if (diffBundle.size() == 0) {
            null
        } else diffBundle

    }

}
