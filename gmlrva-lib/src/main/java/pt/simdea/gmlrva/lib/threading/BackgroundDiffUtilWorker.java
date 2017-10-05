/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.threading;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v7.util.DiffUtil;

import java.util.List;

import lombok.AllArgsConstructor;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.diff.GmlrvaDiffCallback;

/**
 * Class meant to act as a Worker thread for {@link DiffUtil} calculations.
 *
 * Created by Paulo Ribeiro on 10/5/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor public final class BackgroundDiffUtilWorker implements Runnable {

    private final List<? extends IGenericRecyclerViewLayout> mOldDataSet;
    private final List<? extends IGenericRecyclerViewLayout> mNewDataSet;
    private final Context mContext;
    private final GenericMultipleLayoutAdapter mAdapter;

    /** {@inheritDoc} */
    @WorkerThread @Override public void run() {
        final DiffUtil.DiffResult diffResult
                = DiffUtil.calculateDiff(new GmlrvaDiffCallback(this.mOldDataSet, this.mNewDataSet));
        if (mContext != null) {
            ((Activity) mContext).runOnUiThread(new UpdateUiDiffUtilResult(this.mNewDataSet, diffResult, mAdapter));
        }
    }

}
