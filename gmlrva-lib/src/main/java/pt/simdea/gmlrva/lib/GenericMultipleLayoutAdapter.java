/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import pt.simdea.gmlrva.lib.threading.BackgroundDiffUtilWorker;

import static pt.simdea.gmlrva.lib.diff.GenericPayload.UPDATE_ITEM;

/**
 * Generic {@link RecyclerView.Adapter} base class responsible for binding "all intents and purposes" layout
 * implementations applied to {@link RecyclerView} instances.
 *
 * Created by André Rosa on 7/16/2017.
 * Simdea © All Rights Reserved.
 * andre.rosa@simdea.pt
 */
@SuppressWarnings({"unused", "unchecked"})
public class GenericMultipleLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* Adapter Variables */
    private final Context mContext;
    private final List<IGenericRecyclerViewLayout> mDataSet;
    private final boolean mSkipQueuedUpdates;

    /* View Type Auxiliary Variable */
    private final SparseArray<IGenericRecyclerViewLayout> mViewTypes = new SparseArray<>();

    /* UI & Worker Thread Variables */
    private final ArrayDeque<List<? extends IGenericRecyclerViewLayout>> mPendingUpdates = new ArrayDeque<>();
    private final Handler mHandler = new Handler();

    /**
     * Instantiates a new GenericMultipleLayoutAdapter.
     * @param dataSet the list of items to populate this adapter.
     * @param context the application's current {@link Context}.
     * @param skipQueuedUpdates a boolean value indicating whether this adapter should ignore pending updates and
     *                          skip to the newest one or execute all pending updates sequentially.
     */
    public GenericMultipleLayoutAdapter(@NonNull final List<? extends IGenericRecyclerViewLayout> dataSet,
                                        @NonNull final Context context, final boolean skipQueuedUpdates) {
        super();
        mContext = context;
        mDataSet = (List<IGenericRecyclerViewLayout>) dataSet;
        mSkipQueuedUpdates = skipQueuedUpdates;
        updateViewTypes();
    }

    /** {@inheritDoc} */
    @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return mViewTypes.get(viewType).createViewHolder(parent);
    }

    /** {@inheritDoc} */
    @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        mDataSet.get(position).setElements(holder);
    }

    /** {@inheritDoc} */
    @Override public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position,
                                           @NonNull final List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            applyPayloads(payloads, position);
        }
    }

    /** {@inheritDoc} */
    @Override public int getItemCount() {
        return mDataSet.size();
    }

    /** {@inheritDoc} */
    @Override public int getItemViewType(final int position) {
        return mDataSet.get(position).getViewType();
    }

    /**
     * Procedure meant to insert a Generic Layout Implementation item on this adapter's data set.
     * @param item a Generic Layout Implementation item to be inserted.
     *             See {@link IGenericRecyclerViewLayout} for more information.
     */
    @UiThread public void add(@NonNull final IGenericRecyclerViewLayout item) {
        final List<IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        newList.add(item);
        updateList(newList);
    }

    /**
     * Procedure meant to insert a list of Generic Layout Implementation item on this adapter's data set.
     * @param items the list of Generic Layout Implementation items to be inserted.
     *              See {@link IGenericRecyclerViewLayout} for more information.
     */
    @UiThread public void add(@NonNull final List<? extends IGenericRecyclerViewLayout> items) {
        final List<IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        newList.addAll(items);
        updateList(newList);
    }

    /**
     * Procedure meant to insert a Generic Layout Implementation item on this adapter's data set, at a target position.
     * @param item a Generic Layout Implementation item to be inserted.
     *             See {@link IGenericRecyclerViewLayout} for more information.
     * @param position the target position for this item to be inserted.
     * @throws IndexOutOfBoundsException if the position is out of range
     *                                  (<tt>position &lt; 0 || position &gt; size()</tt>).
     */
    @UiThread public void add(@NonNull final IGenericRecyclerViewLayout item, final int position) {
        final List<IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        newList.add(position, item);
        updateList(newList);
    }

    /**
     * Procedure meant to remove a Generic Layout Implementation item on this adapter's data set.
     * @param item a Generic Layout Implementation item to be removed.
     *             See {@link IGenericRecyclerViewLayout} for more information.
     */
    @UiThread public void remove(@NonNull final IGenericRecyclerViewLayout item) {
        final List<? extends IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        if (!newList.isEmpty() && newList.contains(item)) {
            newList.remove(item);
            updateList(newList);
        }
    }

    /**
     * Unsupported operation, meant to remove a Generic Layout Implementation item on this adapter's data set, at a
     * target position.
     * This procedure is unsupported because the position value is likely to be wrong if there is a pending update.
     * @param position the target position for this item to be removed.
     */
    @Deprecated public void remove(final int position) {
        throw new UnsupportedOperationException(mContext.getString(R.string.gmlrva_unsupported_remove_position));
    }

    /**
     * Procedure meant to remove a list of Generic Layout Implementation items on this adapter's data set.
     * @param items the list of Generic Layout Implementation items to be removed.
     *              See {@link IGenericRecyclerViewLayout} for more information.
     */
    @UiThread public void removed(@NonNull final List<IGenericRecyclerViewLayout> items) {
        final List<IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        if (!newList.isEmpty() && !items.isEmpty()) {
            newList.removeAll(items);
            updateList(newList);
        }
    }

    /**
     * Procedure meant to retrieve a Generic Layout Implementation item on this adapter's data set.
     * @param position the target position of the item to be retrieved.
     * @return the Generic Layout Implementation item whose index is the specified target position.
     * @throws NullPointerException if the data set is empty.
     * @throws IndexOutOfBoundsException if the target position is out of range
     *                                  (<tt>position &lt; 0 || position &gt; size()</tt>).
     */
    @UiThread @Nullable public IGenericRecyclerViewLayout get(final int position) {
        final List<IGenericRecyclerViewLayout> newList
                = new ArrayList<>(mPendingUpdates.isEmpty() ? mDataSet : mPendingUpdates.peekLast());
        if (newList.isEmpty()) {
            return null;
        }
        if (position < 0 && position >= newList.size()) {
            throw new ArrayIndexOutOfBoundsException(position);
        }
        return newList.get(position);
    }

    /**
     * Procedure meant to prepare an update this adapter's entire data set.
     * This procedure checks for the changes made to this adapter's data set and applies these changes exclusively,
     * meaning there are no wasted operations.
     * Allows for update queueing and recursion.
     * @param items the list of Generic Layout Implementation items for the data set.
     */
    @UiThread public void updateList(@NonNull final List<? extends IGenericRecyclerViewLayout> items) {
        mPendingUpdates.add(items);
        if (mPendingUpdates.size() == 1) {
            innerUpdateList(items); // no pending update, so execute the update
        }
    }

    /**
     * Procedure meant to update this adapter's entire data set.
     * Makes use of a background thread to execute the update operation and off load work from the UIThread.
     * @param items the list of Generic Layout Implementation items for the data set.
     */
    @UiThread private void innerUpdateList(@NonNull final List<? extends IGenericRecyclerViewLayout> items) {
        mHandler.post(new BackgroundDiffUtilWorker(mDataSet, items, mContext, this));
    }

    /**
     * Procedure meant to update this adapter's entire data set.
     * This procedure handles and commits the update results.
     * @param newItems the list of Generic Layout Implementation items for the data set.
     * @param diffResult the {@link DiffUtil.DiffResult} with the exclusive changes.
     */
    @UiThread public void applyDiffResult(@NonNull final List<? extends IGenericRecyclerViewLayout> newItems,
                                   @NonNull final DiffUtil.DiffResult diffResult) {
        mPendingUpdates.remove(); // the data set is processed
        mDataSet.clear();
        mDataSet.addAll(newItems);
        diffResult.dispatchUpdatesTo(this);

        /* Process the next queued data set if there is any */
        if (!mPendingUpdates.isEmpty()) {
            if (mSkipQueuedUpdates) {
                skipQueuedUpdates();
            }
            innerUpdateList(mPendingUpdates.peek());
        }
    }

    /** Procedure meant to skip any pending queued update. */
    private void skipQueuedUpdates() {
        if (mPendingUpdates.size() > 1) {
            /* More than one update queued */
            final List<? extends IGenericRecyclerViewLayout> lastList = mPendingUpdates.peekLast();
            mPendingUpdates.clear();
            mPendingUpdates.add(lastList);
        }
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
        if (payload.get(key) instanceof RecyclerView.ViewHolder) {
            final RecyclerView.ViewHolder newHolder = (RecyclerView.ViewHolder) payload.get(key);
            if (newHolder != null) {
                mDataSet.get(position).setElements(newHolder);
            }
        }
    }

    /** Procedure meant to update this Adapter's handled View Types. */
    private void updateViewTypes() {
        for (final IGenericRecyclerViewLayout item : mDataSet) {
            if (mViewTypes.get(item.getViewType()) == null) {
                mViewTypes.put(item.getViewType(), item);
            }
        }
    }

}
