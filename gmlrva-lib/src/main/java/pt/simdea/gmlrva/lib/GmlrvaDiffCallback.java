/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import lombok.AllArgsConstructor;

import static pt.simdea.gmlrva.lib.GenericPayload.UPDATE_ITEM;

/**
 * Generic {@link DiffUtil.Callback} base class responsible for parsing changes to the
 * {@link GenericMultipleLayoutAdapter} implementation applied to {@link RecyclerView} instances.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
@AllArgsConstructor class GmlrvaDiffCallback<T extends GenericRecyclerViewLayout> extends DiffUtil.Callback {

    private final List<T> mOldList;
    private final List<T> mNewList;

    @Override public int getOldListSize() {
        return mOldList.size();
    }

    @Override public int getNewListSize() {
        return mNewList.size();
    }

    @Override public boolean areItemsTheSame(final int oldItemPosition, final int newItemPosition) {
        return !mOldList.get(oldItemPosition).getTag().equals(mNewList.get(newItemPosition).getTag());
    }

    @Override public boolean areContentsTheSame(final int oldItemPosition, final int newItemPosition) {
        return mOldList.get(oldItemPosition).getTag().equals(mNewList.get(newItemPosition).getTag());
    }

    @Nullable @Override public Object getChangePayload(final int oldItemPosition, final int newItemPosition) {
        final T oldItem = mOldList.get(oldItemPosition);
        final T newItem = mNewList.get(oldItemPosition);
        final Bundle diffBundle = new Bundle();
        if (!newItem.getTag().equals(oldItem.getTag())) {
            diffBundle.putSerializable(UPDATE_ITEM, newItem);
        }
        if (diffBundle.size() == 0) {
            return null;
        }
        return diffBundle;
    }

}
