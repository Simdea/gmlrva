/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.threading

import android.app.Activity
import android.content.Context
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.DiffUtil
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.diff.GmlrvaDiffCallback

/**
 * Class meant to act as a Worker thread for [DiffUtil] calculations.
 *
 * Created by Paulo Ribeiro on 10/5/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class BackgroundDiffUtilWorker(private val mOldDataSet: List<IGenericRecyclerViewLayout<*>>?,
                               private val mNewDataSet: List<IGenericRecyclerViewLayout<*>>?,
                               private val mContext: Context?,
                               private val mAdapter: GenericMultipleLayoutAdapter?) : Runnable {

    /** {@inheritDoc}  */
    @WorkerThread
    override fun run() {
        val diffResult = DiffUtil.calculateDiff(GmlrvaDiffCallback())
        if (mContext != null) {
            (mContext as Activity).runOnUiThread(UpdateUiDiffUtilResult(this.mNewDataSet, diffResult, mAdapter))
        }
    }

}
