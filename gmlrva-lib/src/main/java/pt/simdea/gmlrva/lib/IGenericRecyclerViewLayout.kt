/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib

import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import java.io.Serializable

/**
 * Interface meant to define a contract in which we specify the rules for building a Generic [RecyclerView] Layout
 * (used for binding the data).
 *
 * @param <T> an instance of [RecyclerView.ViewHolder].
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
</T> */
interface IGenericRecyclerViewLayout<T> : Serializable where T : RecyclerView.ViewHolder, T : IViewHolder {

    /**
     * Procedure meant to define a tag for the ViewHolder item [RecyclerView.ViewHolder].
     * @return the [Object] representing the ViewHolder item [RecyclerView.ViewHolder]'s tag.
     */
    val tag: Any

    /**
     * Procedure meant to define a ViewType for the ViewHolder item [RecyclerView.ViewHolder].
     * @return the Integer value representing the ViewHolder item [RecyclerView.ViewHolder]'s ViewType.
     */
    @get:IntRange(from = 0)
    val viewType: Int

    /**
     * Procedure meant to handle the ViewHolder instance creation.
     * @param parent the root ViewGroup [ViewGroup] for the ViewHolder instance.
     * @return the created ViewHolder instance.
     */
    fun createViewHolder(parent: ViewGroup): T

    /**
     * Procedure meant to bind the target data from a model to the ViewHolder item [RecyclerView.ViewHolder].
     * @param holder the [RecyclerView.ViewHolder] instance.
     */
    fun setElements(holder: T)

}
