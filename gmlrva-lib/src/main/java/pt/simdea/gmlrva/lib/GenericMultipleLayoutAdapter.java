/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

import static pt.simdea.gmlrva.lib.GenericPayload.UPDATE_ITEM;

/**
 * Generic {@link RecyclerView.Adapter} base class responsible for binding "all intents and purposes" layout
 * implementations applied to {@link RecyclerView} instances.
 *
 * @param <T> Generic Layout Implementation to be handled by this adapter.
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
 */
@SuppressWarnings({"unused", "unchecked"})
@AllArgsConstructor public class GenericMultipleLayoutAdapter<T extends GenericRecyclerViewLayout>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> mDataSet = new ArrayList<>();

    @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return mDataSet.get(viewType).createViewHolder(parent);
    }

    @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        mDataSet.get(position).setElements(holder);
    }

    @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position,
                                           @NonNull final List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            applyPayloads(payloads, position);
        }
    }

    @Override public int getItemCount() {
        return mDataSet.size();
    }

    @Override public int getItemViewType(final int position) {
        return position;
    }

    /**
     * Procedure meant to update this adapter's entire data set.
     * This procedure checks for the changes made to this adapter's data set and applies these changes exclusively,
     * meaning there are no wasted operations.
     * @param items the list of Generic Layout Implementation items for the data set.
     */
    public void updateList(@NonNull final List<T> items) {
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new GmlrvaDiffCallback<>(this.mDataSet, items));
        mDataSet = items;
        diffResult.dispatchUpdatesTo(this);
    }

    /**
     * Procedure meant to apply a given payload to this adapter's data set.
     * @param payloads the payload bundle object with the updates.
     * @param position the adapter's position to be updated.
     */
    private void applyPayloads(@NonNull final List<Object> payloads, final int position) {
        final Bundle payload = (Bundle) payloads.get(0);
        if (payload != null && payload.keySet() != null) {
            for (final String key : payload.keySet()) {
                if (UPDATE_ITEM.equals(key)) {
                    applyPayloadChange(position, payload, key);
                }
            }
        }
    }

    /**
     * Procedure meant to apply a given {@link RecyclerView.ViewHolder} change on this adapter's data set.
     * @param position the adapter's position to be updated.
     * @param payload the payload bundle object with the updates.
     * @param key the payload key for the update value object.
     */
    private void applyPayloadChange(final int position, @NonNull final Bundle payload, @NonNull final String key) {
        final RecyclerView.ViewHolder newHolder = (RecyclerView.ViewHolder) payload.get(key);
        if (newHolder != null) {
            mDataSet.get(position).setElements(newHolder);
        }
    }

}
