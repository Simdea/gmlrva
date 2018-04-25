/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Interface meant to define a contract in which we specify the rules for building a Generic {@link RecyclerView} Layout
 * (used for binding the data).
 *
 * @param <T> an instance of {@link RecyclerView.ViewHolder}.
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
public interface IGenericRecyclerViewLayout<T extends RecyclerView.ViewHolder & IViewHolder> extends Serializable {

    /**
     * Procedure meant to handle the ViewHolder instance creation.
     * @param parent the root ViewGroup {@link ViewGroup} for the ViewHolder instance.
     * @return the created ViewHolder instance.
     */
    @NonNull
    T createViewHolder(@NonNull final ViewGroup parent);

    /**
     * Procedure meant to bind the target data from a model to the ViewHolder item {@link RecyclerView.ViewHolder}.
     * @param holder the {@link RecyclerView.ViewHolder} instance.
     */
    void setElements(@NonNull final T holder);

    /**
     * Procedure meant to define a tag for the ViewHolder item {@link RecyclerView.ViewHolder}.
     * @return the {@link Object} representing the ViewHolder item {@link RecyclerView.ViewHolder}'s tag.
     */
    @NonNull
    Object getTag();

    /**
     * Procedure meant to define a ViewType for the ViewHolder item {@link RecyclerView.ViewHolder}.
     * @return the Integer value representing the ViewHolder item {@link RecyclerView.ViewHolder}'s ViewType.
     */
    @IntRange(from = 0)
    int getViewType();

}
