/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import lombok.AllArgsConstructor;

import static pt.simdea.gmlrva.lib.GenericPayload.UPDATE_ITEM;

/**
 * Generic {@link RecyclerView.Adapter} base class reponsible for binding "all intents and purposes" layout
 * implementations applied to {@link RecyclerView} instances.
 *
 * @param <T> Generic Layout Implementation to be handled by this adapter.
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
 */
@SuppressWarnings("unused")
@AllArgsConstructor
public class GenericMultipleLayoutAdapter<T extends GenericRecyclerViewLayout>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<T> mDataSet;

    @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return mDataSet.get(viewType).createViewHolder(parent);
    }

    @SuppressWarnings("unchecked") @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder,
                                                                          final int position) {
        mDataSet.get(position).setElements(holder);
    }

    @SuppressWarnings("unchecked") @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder,
                                                                          final int position,
                                                                          @NonNull final List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            final Bundle o = (Bundle) payloads.get(0);
            for (final String key : o.keySet()) {
                if ("CENAS".equals(key)) {
                    mDataSet.get(position).setElements(holder);
                }
            }
        }
    }

    @Override public int getItemCount() {
        return mDataSet.size();
    }

    @Override public int getItemViewType(final int position) {
        return position;
    }

    /**
     * Procedure meant to insert a Generic Layout Implementation item on this adapter's data set.
     * @param item a Generic Layout Implementation item.
     */
    public void add(@NonNull final T item) {
        final int index = validateItemPosition(item);
        mDataSet.add(item);
        notifyItemInserted(index);
    }

    /**
     * Procedure meant to insert a list of Generic Layout Implementation item on this adapter's data set.
     * @param items the list of Generic Layout Implementation items to be inserted.
     */
    public void add(@NonNull final List<T> items) {
        final int index = validateLastItemPosition();
        mDataSet.addAll(items);
        notifyItemRangeChanged(index, items.size());
    }

    /**
     * Procedure meant to insert a Generic Layout Implementation item on this adapter's data set, at a target position.
     * @param item a Generic Layout Implementation item.
     * @param position the target position for this item to be inserted.
     * @throws IndexOutOfBoundsException if the position is out of range
     *                 (<tt>position &lt; 0 || position &gt; size()</tt>)
     */
    public void add(@NonNull final T item, final int position) {
        mDataSet.add(position, item);
        notifyItemChanged(position);
    }

    /**
     * Procedure meant to remove a Generic Layout Implementation item on this adapter's data set, at a target position.
     * @param position the target position for this item to be removed.
     */
    public void remove(final int position) {
        if (!mDataSet.isEmpty() && validateItemPosition(position)) {
            mDataSet.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * Procedure meant to remove a list of Generic Layout Implementation item on this adapter's data set.
     * @param items the list of Generic Layout Implementation items to be removed.
     */
    public void remove(@NonNull final List<T> items) {
        if (!mDataSet.isEmpty() && !items.isEmpty()) {
            final int index = validateLastItemPosition();
            mDataSet.removeAll(items);
            notifyItemRangeRemoved(index, items.size());
        }
    }

    /**
     * Procedure meant to update a Generic Layout Implementation item present on this adapter's data set.
     * @param item a Generic Layout Implementation item.
     */
    public void update(@NonNull final T item) {
        add(item);
    }

    /**
     * Procedure meant to update this adapter's entire data set.
     * @param items the list of Generic Layout Implementation items to be added.
     */
    public void updateList(@NonNull final List<T> items) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new GmlrvaDiffCallback<>(this.mDataSet, items));
        diffResult.dispatchUpdatesTo(this);
    }

    /**
     * Procedure meant to swap this adapter's entire data set.
     * @param items the list of Generic Layout Implementation items to be added.
     */
    public void swap(@NonNull final List<T> items) {
        if (!items.isEmpty()) {
            mDataSet.clear();
            mDataSet.addAll(items);
            notifyDataSetChanged();
        }
    }

    /**
     * Procedure meant to perform an integrity check on a target index.
     * @param index the target index.
     * @return whether the target index is in range on this adapter's data set.
     */
    private boolean validateItemPosition(final int index) {
        return index > 0 && index < getItemCount();
    }

    /**
     * Procedure meant to check the position of a target item on the data set.
     * @param item the target Generic Layout Implementation item.
     * @return the position of a target item on the data set if it exists, else returns the next position to be filled.
     */
    private int validateItemPosition(@NonNull final T item) {
        return mDataSet.contains(item) ? mDataSet.indexOf(item) : getItemCount();
    }

    /**
     * Procedure meant to check the last known filled position on the data set.
     * @return the last known filled position on the data set.
     */
    private int validateLastItemPosition() {
        return getItemCount() - 1 < 0 ? 0 : getItemCount() - 1;
    }
}
