/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.diff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import lombok.AllArgsConstructor;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;

/**
 * Generic {@link DiffUtil.Callback} base class responsible for parsing changes to the
 * {@link GenericMultipleLayoutAdapter} implementation applied to {@link RecyclerView} instances.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
@AllArgsConstructor public class GmlrvaDiffCallback extends DiffUtil.Callback {

    private final List<? extends IGenericRecyclerViewLayout> mOldList;
    private final List<? extends IGenericRecyclerViewLayout> mNewList;

    /** {@inheritDoc} */
    @Override public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    /** {@inheritDoc} */
    @Override public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();
    }

    /** {@inheritDoc} */
    @Override public boolean areItemsTheSame(final int oldItemPosition, final int newItemPosition) {
        final IGenericRecyclerViewLayout oldItem = mOldList.get(oldItemPosition);
        final IGenericRecyclerViewLayout newItem = mNewList.get(newItemPosition);
        return oldItem.equals(newItem);
    }

    /** {@inheritDoc} */
    @Override public boolean areContentsTheSame(final int oldItemPosition, final int newItemPosition) {
        final IGenericRecyclerViewLayout oldItem = mOldList.get(oldItemPosition);
        final IGenericRecyclerViewLayout newItem = mNewList.get(newItemPosition);
        return oldItem.getTag().equals(newItem.getTag());
    }

    /** {@inheritDoc} */
    @Nullable @Override public Object getChangePayload(final int oldItemPosition, final int newItemPosition) {
        final IGenericRecyclerViewLayout oldItem = mOldList.get(oldItemPosition);
        final IGenericRecyclerViewLayout newItem = mNewList.get(newItemPosition);
        final Bundle diffBundle = new Bundle();

        if (!newItem.getTag().equals(oldItem.getTag())) {
            diffBundle.putSerializable(GenericPayload.UPDATE_ITEM, newItem);
        }

        if (diffBundle.size() == 0) {
            return null;
        }

        return diffBundle;
    }

}
