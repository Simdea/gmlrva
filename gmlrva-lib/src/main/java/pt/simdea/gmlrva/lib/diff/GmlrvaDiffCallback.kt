/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.diff

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.ViewHolder

/**
 * Generic [DiffUtil.Callback] base class responsible for parsing changes to the
 * [GenericMultipleLayoutAdapter] implementation applied to [RecyclerView] instances.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class GmlrvaDiffCallback : DiffUtil.ItemCallback<IGenericRecyclerViewLayout<ViewHolder>>() {
    override fun areItemsTheSame(oldItem: IGenericRecyclerViewLayout<ViewHolder>, newItem: IGenericRecyclerViewLayout<ViewHolder>): Boolean {
        return oldItem.tag == newItem.tag
    }

    override fun areContentsTheSame(oldItem: IGenericRecyclerViewLayout<ViewHolder>, newItem: IGenericRecyclerViewLayout<ViewHolder>): Boolean {
        return oldItem == newItem
    }
}
