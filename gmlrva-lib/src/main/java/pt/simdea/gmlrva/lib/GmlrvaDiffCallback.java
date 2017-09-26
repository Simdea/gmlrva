package pt.simdea.gmlrva.lib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

import lombok.AllArgsConstructor;

import static pt.simdea.gmlrva.lib.GenericPayload.UPDATE_ITEM;

/**
 * TODO...
 * Created by Paulo on 9/26/2017.
 */
@AllArgsConstructor public class GmlrvaDiffCallback<T extends GenericRecyclerViewLayout> extends DiffUtil.Callback {

    private List<T> mOldList;
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
            diffBundle.putString("CENAS", (String) newItem.getTag());
        }

        if (diffBundle.size() == 0) {
            return null;
        }
        return diffBundle;
    }

}
