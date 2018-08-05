/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.threading;

import androidx.annotation.UiThread;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

import lombok.AllArgsConstructor;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;

/**
 * Class meant to act as the {@link DiffUtil} calculations result dispatcher to the UIThread.
 *
 * Created by Paulo Ribeiro on 10/5/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
final class UpdateUiDiffUtilResult
        implements Runnable {

    private final List<? extends IGenericRecyclerViewLayout> mNewDataSet;
    private final DiffUtil.DiffResult mDiffResult;
    private final GenericMultipleLayoutAdapter mAdapter;

    /** {@inheritDoc} */
    @UiThread
    @Override
    public void run() {
        mAdapter.applyDiffResult(mNewDataSet, mDiffResult);
    }

}
